package com.digiboy.erp.dto.sg;

public class PayStubSG {
    private Long id;
    private String issueYearMonth;
    private Long employeeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIssueYearMonth() {
        return issueYearMonth;
    }

    public void setIssueYearMonth(String issueYearMonth) {
        this.issueYearMonth = issueYearMonth;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }
}
