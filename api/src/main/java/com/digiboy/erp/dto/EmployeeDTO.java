package com.digiboy.erp.dto;

public class EmployeeDTO extends DTOBase {

    private Long id;

    private String employeeCode;

//    private CompanyDTO company;

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
