package com.digiboy.erp.service;

import com.digiboy.erp.api.PayStubService;
import com.digiboy.erp.cfg.Endpoint;
import com.digiboy.erp.dto.*;
import com.digiboy.erp.dto.sg.AttendanceSG;
import com.digiboy.erp.dto.sg.LoanSG;
import com.digiboy.erp.dto.sg.PayStubItemSG;
import com.digiboy.erp.dto.sg.PayStubSG;
import com.digiboy.erp.mapper.EntityMapper;
import com.digiboy.erp.mapper.PayStubMapper;
import com.digiboy.erp.repository.PayStubRepository;
import com.digiboy.erp.to.PayStub;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.DecimalFormat;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PayStubServiceImpl extends GeneralServiceImpl<PayStub, PayStubDTO> implements PayStubService {

    @Autowired
    private PayStubRepository repository;

    @Autowired
    private PayStubMapper mapper;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    public PayStubServiceImpl(Logger logger) {
        super(logger);
    }

    @Override
    JpaRepository<PayStub, Long> getRepository() {
        return repository;
    }

    @Override
    EntityMapper<PayStub, PayStubDTO> mapper() {
        return mapper;
    }

    @Override
    public List<String> findAllHeadings() {
        return repository.findAll().stream().map(PayStub::getPayDate).collect(Collectors.toList());
    }

    @Autowired
    private Endpoint endpoint;

    @Override
    public Optional<PayStubDTO> findByEmployeeAndPayDate(EmployeeDTO employee, String year, String month) {
        String url = String.format(endpoint.getSystemGroupEmployeePayStubs(), employee.getSysId());
        PayStubSG[] sgPayStubs = restTemplate.getForObject(url, PayStubSG[].class);
        Optional<PayStubSG> sgPayStub = Arrays.stream(Objects.requireNonNull(sgPayStubs))
                .filter(payStubSG -> payStubSG.getIssueYearMonth().equals(year + month))
                .findFirst();
        if (sgPayStub.isEmpty())
            return Optional.empty();

        String url2 = String.format(endpoint.getSystemGroupPayStubPayItems(), sgPayStub.get().getId());
        PayStubItemSG[] sgPayStubItems = restTemplate.getForObject(url2, PayStubItemSG[].class);
        Arrays.stream(Objects.requireNonNull(sgPayStubItems)).map(item -> String.format("%s:%d", item.getTitle(), item.getAmount())).forEach(logger::info);

        PayStubDTO payStubDTO = new PayStubDTO();
        payStubDTO.setEmployeeCode(employee.getEmployeeCode());
        payStubDTO.setEmployeeName(employee.getFirstName() + " " + employee.getLastName());
        payStubDTO.setPayDate(year + month);

        extractPayStubItem(sgPayStubItems, 7, payStubDTO::setNetPay);
        extractPayStubItem(sgPayStubItems, 12, payStubDTO::setTotalEarning);
        extractPayStubItem(sgPayStubItems, 13, payStubDTO::setTotalDeduction);
        extractPayStubItem(sgPayStubItems, 50, payStubDTO::setTotalLoan);

        List<Long> otherFilter = Arrays.asList(
                64L, 110L, 111L, 113L, 116L, 121L, 187L, 386L, 394L, 426L, 458L
        );

        Set<OtherPayStubItemDTO> otherPayStubItems = new TreeSet<>(Comparator.comparing(OtherPayStubItemDTO::getId));
        otherPayStubItems.addAll(getEmployeeAttendance(employee.getSysId(), year, month));
        otherPayStubItems.add(extractLeaveBalance(sgPayStubItems));
        otherPayStubItems.add(extractLeaveUsedInCurrentMonth(sgPayStubItems));
        Set<OtherPayStubItemDTO> others = Arrays.stream(Objects.requireNonNull(sgPayStubItems))
                .filter(item -> otherFilter.contains(item.getCompensationFactorId()))
                .map(item -> {
                    OtherPayStubItemDTO otherPayStubItemDTO = new OtherPayStubItemDTO();
                    otherPayStubItemDTO.setId(item.getCompensationFactorId());
                    otherPayStubItemDTO.setTitle(item.getTitle());
                    otherPayStubItemDTO.setAmount(new DecimalFormat("###,###").format(item.getAmount()));
                    return otherPayStubItemDTO;
                }).collect(Collectors.toSet());
        otherPayStubItems.addAll(others);
        payStubDTO.setOthers(otherPayStubItems);

        List<Long> earningFilter = Arrays.asList(
                3L, 10L, 14L, 15L, 16L, 17L, 18L, 20L, 21L, 22L, 25L, 27L, 29L, 31L, 33L, 35L, 39L, 40L, 41L, 42L, 43L, 44L, 129L, 130L, 131L, 178L, 179L, 181L, 182L, 194L, 216L, 242L, 243L, 244L, 331L, 336L, 339L, 375L, 427L, 445L, 446L, 447L, 450L, 451L, 452L, 453L, 454L, 455L, 456L, 457L, 461L, 462L, 463L
        );
        Set<EarningPayStubItemDTO> earningPayStubItems = Arrays.stream(Objects.requireNonNull(sgPayStubItems))
                .filter(item -> earningFilter.contains(item.getCompensationFactorId()))
                .map(item -> {
                    EarningPayStubItemDTO deductionPayStubItemDTO = new EarningPayStubItemDTO();
                    deductionPayStubItemDTO.setTitle(item.getTitle());
                    deductionPayStubItemDTO.setAmount(item.getAmount());
                    deductionPayStubItemDTO.setId(item.getCompensationFactorId());
                    return deductionPayStubItemDTO;
                }).collect(Collectors.toSet());
        payStubDTO.setEarnings(earningPayStubItems);

        List<Long> deductionFilter = Arrays.asList(
                8L, 11L, 45L, 49L, 50L, 51L, 52L, 118L, 122L, 186L, 196L, 340L, 341L, 385L, 442L
        );
        Set<DeductionPayStubItemDTO> deductionPayStubItems = Arrays.stream(Objects.requireNonNull(sgPayStubItems))
                .filter(item -> deductionFilter.contains(item.getCompensationFactorId()))
                .map(item -> {
                    DeductionPayStubItemDTO deductionPayStubItemDTO = new DeductionPayStubItemDTO();
                    deductionPayStubItemDTO.setTitle(item.getTitle());
                    deductionPayStubItemDTO.setAmount(item.getAmount());
                    deductionPayStubItemDTO.setId(item.getCompensationFactorId());
                    return deductionPayStubItemDTO;
                }).collect(Collectors.toSet());
        payStubDTO.setDeductions(deductionPayStubItems);

        String url3 = String.format(endpoint.getSystemGroupEmployeeLoans(), employee.getSysId());
        LoanSG[] sgLoans = restTemplate.getForObject(url3, LoanSG[].class);

        String payDate = year + month;
        Set<LoanPayStubItemDTO> loanPayStubItems = Arrays.stream(Objects.requireNonNull(sgLoans))
                .filter(item -> payDate.equals(item.getPaymentYearMonth()))
                .map(item -> {
                    LoanPayStubItemDTO loanPayStubItemDTO = new LoanPayStubItemDTO();
                    loanPayStubItemDTO.setTitle(item.getTitle());
                    loanPayStubItemDTO.setPrincipal(item.getPrincipal());
                    loanPayStubItemDTO.setInstallment(item.getInstallment());
                    loanPayStubItemDTO.setOutstanding(item.getOutstanding());
                    loanPayStubItemDTO.setPaymentYearMonth(item.getPaymentYearMonth());
                    return loanPayStubItemDTO;
                }).collect(Collectors.toSet());
        payStubDTO.setLoans(loanPayStubItems);

        return Optional.of(payStubDTO);
    }

    private Set<OtherPayStubItemDTO> getEmployeeAttendance(Long sysId, String year, String month) {
        String url = String.format(endpoint.getSystemGroupEmployeeAttendance(), sysId, year, month);
        AttendanceSG[] attendance = restTemplate.getForObject(url, AttendanceSG[].class);

        List<Integer> attendanceFilter = Arrays.asList(
                24, 192, 26, 28, 30, 32, 34, 239
        );

        Set<OtherPayStubItemDTO> attendancePayStubItems = Arrays.stream(Objects.requireNonNull(attendance))
                .filter(item -> attendanceFilter.contains(item.getAttendanceFactorID().intValue()))
                .map(item -> {
                    OtherPayStubItemDTO otherPayStubItemDTO = new OtherPayStubItemDTO();
                    otherPayStubItemDTO.setId(item.getAttendanceFactorID());
                    otherPayStubItemDTO.setTitle(item.getTitle());
                    otherPayStubItemDTO.setAmount(item.getValue() / 60 + ":" + item.getValue() % 60);
                    return otherPayStubItemDTO;
                }).collect(Collectors.toSet());
        return attendancePayStubItems;
    }

    @Override
    public List<String> findAllIssueYears(EmployeeDTO employee) {
        String url = String.format(endpoint.getSystemGroupPayEmployeeIssueYears(), employee.getSysId());
        logger.info("url: {}", url);
        String[] issueYears = restTemplate.getForObject(url, String[].class);
        return Arrays.asList(issueYears);
    }

    private void extractPayStubItem(PayStubItemSG[] sgPayStubItems, int compensationFactorId, Consumer<Long> consumer) {
        Arrays.stream(Objects.requireNonNull(sgPayStubItems))
                .filter(item -> item.getCompensationFactorId() == compensationFactorId)
                .findFirst().map(PayStubItemSG::getAmount)
                .ifPresent(consumer);
    }

    private OtherPayStubItemDTO extractLeaveUsedInCurrentMonth(PayStubItemSG[] sgPayStubItems) {
        OtherPayStubItemDTO leaveUsed = new OtherPayStubItemDTO();
        leaveUsed.setId(387L);

        Optional<PayStubItemSG> payStubItemSG = Arrays.stream(Objects.requireNonNull(sgPayStubItems))
                .filter(item -> item.getCompensationFactorId() == 387)
                .findFirst();

        payStubItemSG.map(PayStubItemSG::getTitle)
                .ifPresent(leaveUsed::setTitle);

        List<String> result = new ArrayList<>();
        payStubItemSG.map(PayStubItemSG::getAmount)
                .ifPresent(value -> {
                    result.add(String.format("%02d", value % 60));
                    value = value / 60;
                    result.add(String.format("%02d", value % 24));
                    value = value / 24;
                    result.add(String.format("%02d", value));
                    Collections.reverse(result);
                });
        leaveUsed.setAmount(StringUtils.join(result, ":"));
        return leaveUsed;
    }

    private OtherPayStubItemDTO extractLeaveBalance(PayStubItemSG[] sgPayStubItems) {
        OtherPayStubItemDTO leaveBalance = new OtherPayStubItemDTO();
        ResourceBundle bundle = ResourceBundle.getBundle("paystub", new Locale("fa", "IR"));
        leaveBalance.setId(399L);
        leaveBalance.setTitle(bundle.getString("leave.balance"));
        StringBuilder builder = new StringBuilder();
        Arrays.stream(Objects.requireNonNull(sgPayStubItems))
                .filter(item -> item.getCompensationFactorId() == 389)
                .findFirst().map(PayStubItemSG::getAmount)
                .ifPresent(builder::append);
        builder.append(":");
        Arrays.stream(Objects.requireNonNull(sgPayStubItems))
                .filter(item -> item.getCompensationFactorId() == 391)
                .findFirst().map(PayStubItemSG::getAmount)
                .ifPresent(builder::append);
        builder.append(":");
        Arrays.stream(Objects.requireNonNull(sgPayStubItems))
                .filter(item -> item.getCompensationFactorId() == 393)
                .findFirst().map(PayStubItemSG::getAmount)
                .ifPresent(builder::append);
        leaveBalance.setAmount(builder.toString());
        return leaveBalance;
    }
}
