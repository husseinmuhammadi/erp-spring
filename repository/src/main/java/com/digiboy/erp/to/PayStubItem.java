package com.digiboy.erp.to;

import com.digiboy.erp.to.base.EntityBase;

import javax.persistence.*;

@Entity
@Table(name = "pay_stub_item")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "pay_stub_item_type", discriminatorType = DiscriminatorType.STRING)
@SequenceGenerator(name = "SEQUENCE_GENERATOR", sequenceName = "pay_stub_item_seq")
public abstract class PayStubItem extends EntityBase {

    private Long amount;
    private String value;
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pay_stub_id", nullable = false, foreignKey = @ForeignKey(name = "FK_PAY_STUB_ITEM_PAY_STUB_ID"))
    PayStub payStub;

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public PayStub getPayStub() {
        return payStub;
    }

    public void setPayStub(PayStub payStub) {
        this.payStub = payStub;
    }
}
