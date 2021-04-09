package com.digiboy.erp.dto;

import java.util.List;
import java.util.Set;

public class CompanyDTO extends DTOBase {

    private Long id;

    private String name;

    private Set<EmployeeDTO> employees;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<EmployeeDTO> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<EmployeeDTO> employees) {
        this.employees = employees;
    }
}
