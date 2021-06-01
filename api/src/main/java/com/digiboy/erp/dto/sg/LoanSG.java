package com.digiboy.erp.dto.sg;

public class LoanSG {

    private String title;
    private Long principal;
    private Long installment;
    private Long outstanding;
    private String paymentYearMonth;
    private Long employeeId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getPrincipal() {
        return principal;
    }

    public void setPrincipal(Long principal) {
        this.principal = principal;
    }

    public Long getInstallment() {
        return installment;
    }

    public void setInstallment(Long installment) {
        this.installment = installment;
    }

    public Long getOutstanding() {
        return outstanding;
    }

    public void setOutstanding(Long outstanding) {
        this.outstanding = outstanding;
    }

    public String getPaymentYearMonth() {
        return paymentYearMonth;
    }

    public void setPaymentYearMonth(String paymentYearMonth) {
        this.paymentYearMonth = paymentYearMonth;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }
}
