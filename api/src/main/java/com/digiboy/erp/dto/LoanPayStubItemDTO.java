package com.digiboy.erp.dto;

public class LoanPayStubItemDTO {
    private String title;
    private Long principal;
    private Long installment;
    private Long outstanding;

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
}
