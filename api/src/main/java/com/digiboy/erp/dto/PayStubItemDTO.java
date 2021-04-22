package com.digiboy.erp.dto;

public abstract class PayStubItemDTO extends DTOBase {
    private Long id;

    private Long amount;

    private String title;

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
