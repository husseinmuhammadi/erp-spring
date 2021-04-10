package com.digiboy.erp.to;

import com.digiboy.erp.to.base.EntityBase;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * A pay stub is part of a paycheck that lists details about the employee’s pay.
 * It itemizes the wages earned for the pay period and year-to-date payroll.
 * The pay stub also shows taxes and other deductions taken out of an employee’s earnings.
 * And, the pay stub shows the amount the employee actually receives (net pay).
 */
@Entity
@Table(name = "pay_stub", uniqueConstraints = {
        @UniqueConstraint(name = "UQ_PAY_STUB_EMPLOYEE_CODE_PAY_DATE", columnNames = {"employee_code", "pay_date"})
})
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
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    @JoinColumn(name = "pay_stub_id")
    private Set<DeductionPayStubItem> deductions;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    @JoinColumn(name = "pay_stub_id")
    private Set<EarningPayStubItem> earnings;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    @JoinColumn(name = "pay_stub_id")
    private Set<OtherPayStubItem> others;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    @JoinColumn(name = "pay_stub_id")
    private Set<LoanPayStubItem> loans;

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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Set<DeductionPayStubItem> getDeductions() {
        return deductions;
    }

    public void setDeductions(Set<DeductionPayStubItem> deductions) {
        this.deductions = deductions;
    }

    public Set<EarningPayStubItem> getEarnings() {
        return earnings;
    }

    public void setEarnings(Set<EarningPayStubItem> earnings) {
        this.earnings = earnings;
    }

    public Set<OtherPayStubItem> getOthers() {
        return others;
    }

    public void setOthers(Set<OtherPayStubItem> others) {
        this.others = others;
    }

    public Set<LoanPayStubItem> getLoans() {
        return loans;
    }

    public void setLoans(Set<LoanPayStubItem> loans) {
        this.loans = loans;
    }
}
