package com.digiboy.erp.to;

import com.digiboy.erp.to.base.EntityBase;

import javax.persistence.*;

@Entity
@Table(name = "product")
@SequenceGenerator(name = "GGG", sequenceName = "pseq")
public class Product extends EntityBase<Long> {

    @Column(length = 100)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
