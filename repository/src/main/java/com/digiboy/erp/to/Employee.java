package com.digiboy.erp.to;

import com.digiboy.erp.to.base.EntityBase;

import javax.persistence.*;

@Entity
@Table(name = "employee")
@SequenceGenerator(name = "SEQUENCE_GENERATOR", sequenceName = "employee_seq")
public class Employee extends EntityBase {

//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
//    private Person person;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @Column(name = "employee_code", length = 50)
    private String employeeCode;

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
