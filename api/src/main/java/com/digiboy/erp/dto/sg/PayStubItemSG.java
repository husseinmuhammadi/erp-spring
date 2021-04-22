package com.digiboy.erp.dto.sg;

public class PayStubItemSG {
    private String name;
    private String title;
    private Long compensationFactorPropertyId;
    private String applyYearMonth;
    private Long amount;
    private Long compensationFactorId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getCompensationFactorPropertyId() {
        return compensationFactorPropertyId;
    }

    public void setCompensationFactorPropertyId(Long compensationFactorPropertyId) {
        this.compensationFactorPropertyId = compensationFactorPropertyId;
    }

    public String getApplyYearMonth() {
        return applyYearMonth;
    }

    public void setApplyYearMonth(String applyYearMonth) {
        this.applyYearMonth = applyYearMonth;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getCompensationFactorId() {
        return compensationFactorId;
    }

    public void setCompensationFactorId(Long compensationFactorId) {
        this.compensationFactorId = compensationFactorId;
    }
}
