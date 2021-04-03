package com.digiboy.erp.to;

import com.digiboy.erp.to.base.EntityBase;
import com.digiboy.erp.to.base.FSM;

import javax.persistence.*;

@Entity
@Table(name = "company")
@DiscriminatorValue("C")
@SequenceGenerator(name = "SEQUENCE_GENERATOR", sequenceName = "COMPANY_SEQ")
public class Company extends EntityBase implements FSM {

    @Column(name = "name", length = 100)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
