package com.digiboy.erp.dto;

import java.util.Date;
import java.util.List;

public class PayStubDTO extends DTOBase {
    private Long id;
    private String employeeCode;
    private String employeeName;
    private String payPeriod;

    private Date date;

    private List<DeductionPayStubItemDTO> deductions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPayPeriod() {
        return payPeriod;
    }

    public void setPayPeriod(String payPeriod) {
        this.payPeriod = payPeriod;
    }

    public List<DeductionPayStubItemDTO> getDeductions() {
        return deductions;
    }

    public void setDeductions(List<DeductionPayStubItemDTO> deductions) {
        this.deductions = deductions;
    }
}
