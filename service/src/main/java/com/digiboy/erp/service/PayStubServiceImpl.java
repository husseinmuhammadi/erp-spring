package com.digiboy.erp.service;

import com.digiboy.erp.api.PayStubService;
import com.digiboy.erp.cfg.Endpoint;
import com.digiboy.erp.dto.*;
import com.digiboy.erp.dto.sg.PayStubItemSG;
import com.digiboy.erp.dto.sg.PayStubSG;
import com.digiboy.erp.mapper.EntityMapper;
import com.digiboy.erp.mapper.PayStubMapper;
import com.digiboy.erp.repository.PayStubRepository;
import com.digiboy.erp.to.PayStub;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

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
    public Optional<PayStubDTO> findByEmployeeAndPayDate(EmployeeDTO employee, String payDate) {
        String url = String.format(endpoint.getSystemGroupEmployeePayStubs(), employee.getSysId());
        PayStubSG[] sgPayStubs = restTemplate.getForObject(url, PayStubSG[].class);
        Optional<PayStubSG> sgPayStub = Arrays.stream(Objects.requireNonNull(sgPayStubs)).filter(payStubSG -> payStubSG.getIssueYearMonth().equals(payDate)).findFirst();
        if (sgPayStub.isEmpty())
            return Optional.empty();
        String url2 = String.format(endpoint.getSystemGroupPayStubPayItems(), sgPayStub.get().getId());
        PayStubItemSG[] sgPayStubItems = restTemplate.getForObject(url2, PayStubItemSG[].class);
        Arrays.stream(Objects.requireNonNull(sgPayStubItems)).map(item -> String.format("%s:%d", item.getTitle(), item.getAmount())).forEach(logger::info);

        PayStubDTO payStubDTO = new PayStubDTO();
        payStubDTO.setEmployeeCode(employee.getEmployeeCode());
        payStubDTO.setPayDate(payDate);

        extractPayStubItem(sgPayStubItems, 7, payStubDTO::setNetPay);
        extractPayStubItem(sgPayStubItems, 12, payStubDTO::setTotalEarning);
        extractPayStubItem(sgPayStubItems, 13, payStubDTO::setTotalDeduction);

        List<Long> otherFilter = Arrays.asList(110L, 113L, 389L, 391L, 393L);
        Set<OtherPayStubItemDTO> otherPayStubItems = Arrays.stream(Objects.requireNonNull(sgPayStubItems))
                .filter(item -> otherFilter.contains(item.getCompensationFactorId()))
                .map(item -> {
                    OtherPayStubItemDTO otherPayStubItemDTO = new OtherPayStubItemDTO();
                    otherPayStubItemDTO.setTitle(item.getTitle());
                    otherPayStubItemDTO.setAmount(item.getAmount());
                    otherPayStubItemDTO.setId(item.getCompensationFactorId());
                    return otherPayStubItemDTO;
                }).collect(Collectors.toSet());
        payStubDTO.setOthers(otherPayStubItems);

        List<Long> earningFilter = Arrays.asList(194L, 182L, 336L, 16L, 17L, 18L, 22L, 181L, 216L, 41L);
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

        List<Long> deductionFilter = Arrays.asList(8L, 45L, 49L, 341L, 51L);
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

        return Optional.of(payStubDTO);
    }

    @Override
    public List<String> findAllIssueYears(EmployeeDTO employee) {
        String url = String.format(endpoint.getSystemGroupEmployeePayStubs(), employee.getSysId());
        String[] issueYears = restTemplate.getForObject(endpoint.getSystemGroupPayEmployeeIssueYears(), String[].class);
        return Arrays.asList(issueYears);
    }

    private void extractPayStubItem(PayStubItemSG[] sgPayStubItems, int compensationFactorId, Consumer<Long> consumer) {
        Arrays.stream(Objects.requireNonNull(sgPayStubItems))
                .filter(item -> item.getCompensationFactorId() == compensationFactorId)
                .findFirst().map(PayStubItemSG::getAmount)
                .ifPresent(consumer);
    }
}
