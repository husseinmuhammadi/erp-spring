package com.digiboy.erp.dto;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class PayStubDTO extends DTOBase {

    private Long id;

    private String employeeCode;

    private String employeeName;

    private String payPeriod;

    private String payDate;

    private Date date;

    private Long totalEarning;

    private Long totalDeduction;

    private Long totalLoan;

    private Long netPay;

    private Set<DeductionPayStubItemDTO> deductions;

    private Set<EarningPayStubItemDTO> earnings;

    private Set<OtherPayStubItemDTO> others;

    private Set<LoanPayStubItemDTO> loans;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPayPeriod() {
        return payPeriod;
    }

    public void setPayPeriod(String payPeriod) {
        this.payPeriod = payPeriod;
    }

    public Set<DeductionPayStubItemDTO> getDeductions() {
        return deductions;
    }

    public void setDeductions(Set<DeductionPayStubItemDTO> deductions) {
        this.deductions = deductions;
    }

    public Set<EarningPayStubItemDTO> getEarnings() {
        return earnings;
    }

    public void setEarnings(Set<EarningPayStubItemDTO> earnings) {
        this.earnings = earnings;
    }

    public Set<OtherPayStubItemDTO> getOthers() {
        return others;
    }

    public void setOthers(Set<OtherPayStubItemDTO> others) {
        this.others = others;
    }

    public Set<LoanPayStubItemDTO> getLoans() {
        return loans;
    }

    public void setLoans(Set<LoanPayStubItemDTO> loans) {
        this.loans = loans;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public Long getTotalEarning() {
        return totalEarning;
    }

    public void setTotalEarning(Long totalEarning) {
        this.totalEarning = totalEarning;
    }

    public Long getTotalDeduction() {
        return totalDeduction;
    }

    public void setTotalDeduction(Long totalDeduction) {
        this.totalDeduction = totalDeduction;
    }

    public Long getTotalLoan() {
        return totalLoan;
    }

    public void setTotalLoan(Long totalLoan) {
        this.totalLoan = totalLoan;
    }

    public Long getNetPay() {
        return netPay;
    }

    public void setNetPay(Long netPay) {
        this.netPay = netPay;
    }
}
