package com.digiboy.erp.to;

import com.digiboy.erp.to.base.EntityBase;

import javax.persistence.*;
import java.util.List;

/**
 * A pay stub is part of a paycheck that lists details about the employee’s pay.
 * It itemizes the wages earned for the pay period and year-to-date payroll.
 * The pay stub also shows taxes and other deductions taken out of an employee’s earnings.
 * And, the pay stub shows the amount the employee actually receives (net pay).
 */
@Entity
@Table(name = "pay_stub")
@SequenceGenerator(name = "SEQUENCE_GENERATOR", sequenceName = "pay_stub_seq")

public class PayStub extends EntityBase {

    @Column(name = "employee_code")
    private String employeeCode;

    @Column(name = "employee_name")
    private String employeeName;

    @Column(name = "pay_period")
    private String payPeriod;

    @Column(name = "pay_date")
    private String payDate;

    @Column(name = "hours_worked")
    private String hoursWorked;

    @Column(name = "gross_pay")
    private String grossPay;

    @ManyToOne
    private Employee employee;

    @OneToMany(mappedBy = "payStub", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<DeductionPayStubItem> deductions;

    @OneToMany(mappedBy = "payStub")
    private List<EarningPayStubItem> earnings;

    @OneToMany(mappedBy = "payStub")
    private List<OtherPayStubItem> others;

    @OneToMany(mappedBy = "payStub")
    private List<LoanPayStubItem> loans;

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

    public String getPayPeriod() {
        return payPeriod;
    }

    public void setPayPeriod(String payPeriod) {
        this.payPeriod = payPeriod;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public String getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(String hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public String getGrossPay() {
        return grossPay;
    }

    public void setGrossPay(String grossPay) {
        this.grossPay = grossPay;
    }

    public List<DeductionPayStubItem> getDeductions() {
        return deductions;
    }

    public void setDeductions(List<DeductionPayStubItem> deductions) {
        this.deductions = deductions;
    }

    public List<EarningPayStubItem> getEarnings() {
        return earnings;
    }

    public void setEarnings(List<EarningPayStubItem> earnings) {
        this.earnings = earnings;
    }

    public List<OtherPayStubItem> getOthers() {
        return others;
    }

    public void setOthers(List<OtherPayStubItem> others) {
        this.others = others;
    }

    public List<LoanPayStubItem> getLoans() {
        return loans;
    }

    public void setLoans(List<LoanPayStubItem> loans) {
        this.loans = loans;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
