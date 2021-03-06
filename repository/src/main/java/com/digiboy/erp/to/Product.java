package com.digiboy.erp.to;

import com.digiboy.erp.to.base.EntityBase;
import com.digiboy.erp.to.base.FSM;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "product")
@SequenceGenerator(name = "SEQUENCE_GENERATOR", sequenceName = "PRODUCT_SEQ")
public class Product extends EntityBase implements FSM {

    @Column(length = 100)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
