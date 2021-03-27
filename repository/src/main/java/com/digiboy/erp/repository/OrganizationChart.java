package com.digiboy.erp.repository;

import com.digiboy.erp.to.Company;
import com.digiboy.erp.to.Employee;
import com.digiboy.erp.to.base.EntityBase;

import javax.persistence.*;

@Entity
@Table(name="organization_chart")
@SequenceGenerator(name = "SEQUENCE_GENERATOR", sequenceName = "organization_chart_seq")
public class OrganizationChart extends EntityBase {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
