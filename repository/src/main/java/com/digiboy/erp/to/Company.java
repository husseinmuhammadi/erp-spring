package com.digiboy.erp.to;

import com.digiboy.erp.to.base.AbstractEntityBase;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Company extends AbstractEntityBase<Long> {

    @Column(name = "name", length = 100)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
