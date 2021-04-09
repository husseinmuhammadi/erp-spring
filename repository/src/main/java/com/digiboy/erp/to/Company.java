package com.digiboy.erp.to;

import com.digiboy.erp.to.base.EntityBase;
import com.digiboy.erp.to.base.FSM;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "company")
@DiscriminatorValue("C")
@SequenceGenerator(name = "SEQUENCE_GENERATOR", sequenceName = "COMPANY_SEQ")
public class Company extends EntityBase implements FSM {

    @Column(name = "name", length = 100)
    private String name;

    @OneToMany(mappedBy = "company", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Employee> employees;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
