package com.digiboy.erp.dto.sg;

public class AttendanceSG {
    private Long attendanceFactorID;
    private String title;
    private Long value;
    private Long employeeId;
    private String issueYearMonth;

    public Long getAttendanceFactorID() {
        return attendanceFactorID;
    }

    public void setAttendanceFactorID(Long attendanceFactorID) {
        this.attendanceFactorID = attendanceFactorID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getIssueYearMonth() {
        return issueYearMonth;
    }

    public void setIssueYearMonth(String issueYearMonth) {
        this.issueYearMonth = issueYearMonth;
    }
}
