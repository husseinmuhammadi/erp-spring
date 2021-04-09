package com.digiboy.erp.to;

import com.digiboy.erp.to.base.EntityBase;
import com.digiboy.erp.to.base.FSM;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "company")
@SequenceGenerator(name = "SEQUENCE_GENERATOR", sequenceName = "COMPANY_SEQ")
public class Company extends EntityBase implements FSM {

    @Column(name = "name", length = 100)
    private String name;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    private List<Employee> employees;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "company_id")
    private Set<Employee> employees;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
