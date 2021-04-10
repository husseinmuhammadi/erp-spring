package com.digiboy.erp.web.admin;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:paystub.properties")
public class AdminPayStub {

    @Value("${employee.name}")
    private String employeeName;

    @Value("${employee.code}")
    private String employeeCode;

    @Value("${paystub.deduction.round.title}")
    private String deductionRoundTitle;

    @Value("${paystub.deduction.round.amount}")
    private Long deductionRoundAmount;

    @Value("${paystub.deduction.insurance.title}")
    private String deductionInsuranceTitle;

    @Value("${paystub.deduction.insurance.amount}")
    private Long deductionInsuranceAmount;

    @Value("${paystub.deduction.tax.title}")
    private String deductionTaxTitle;

    @Value("${paystub.deduction.tax.amount}")
    private Long deductionTaxAmount;

    @Value("${paystub.deduction.insurance.complementary.title}")
    private String deductionInsuranceComplementaryTitle;

    @Value("${paystub.deduction.insurance.complementary.amount}")
    private Long deductionInsuranceComplementaryAmount;

    @Value("${paystub.deduction.help.title}")
    private String deductionHelpTitle;

    @Value("${paystub.deduction.help.amount}")
    private Long deductionHelpAmount;

    @Value("${paystub.earning.over.time.title}")
    private String earningOverTimeTitle;

    @Value("${paystub.earning.over.time.amount}")
    private Long earningOverTimeAmount;

    public Long getEarningOverTimeAmount() {
        return earningOverTimeAmount;
    }

    public void setEarningOverTimeAmount(Long earningOverTimeAmount) {
        this.earningOverTimeAmount = earningOverTimeAmount;
    }

    public String getEarningOverTimeTitle() {
        return earningOverTimeTitle;
    }

    public void setEarningOverTimeTitle(String earningOverTimeTitle) {
        this.earningOverTimeTitle = earningOverTimeTitle;
    }

    public String getDeductionRoundTitle() {
        return deductionRoundTitle;
    }

    public void setDeductionRoundTitle(String deductionRoundTitle) {
        this.deductionRoundTitle = deductionRoundTitle;
    }


    public Long getDeductionRoundAmount() {
        return deductionRoundAmount;
    }

    public void setDeductionRoundAmount(Long deductionRoundAmount) {
        this.deductionRoundAmount = deductionRoundAmount;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getDeductionInsuranceTitle() {
        return deductionInsuranceTitle;
    }

    public void setDeductionInsuranceTitle(String deductionInsuranceTitle) {
        this.deductionInsuranceTitle = deductionInsuranceTitle;
    }

    public Long getDeductionInsuranceAmount() {
        return deductionInsuranceAmount;
    }

    public void setDeductionInsuranceAmount(Long deductionInsuranceAmount) {
        this.deductionInsuranceAmount = deductionInsuranceAmount;
    }

    public String getDeductionTaxTitle() {
        return deductionTaxTitle;
    }

    public void setDeductionTaxTitle(String deductionTaxTitle) {
        this.deductionTaxTitle = deductionTaxTitle;
    }

    public Long getDeductionTaxAmount() {
        return deductionTaxAmount;
    }

    public void setDeductionTaxAmount(Long deductionTaxAmount) {
        this.deductionTaxAmount = deductionTaxAmount;
    }

    public String getDeductionInsuranceComplementaryTitle() {
        return deductionInsuranceComplementaryTitle;
    }

    public void setDeductionInsuranceComplementaryTitle(String deductionInsuranceComplementaryTitle) {
        this.deductionInsuranceComplementaryTitle = deductionInsuranceComplementaryTitle;
    }

    public Long getDeductionInsuranceComplementaryAmount() {
        return deductionInsuranceComplementaryAmount;
    }

    public void setDeductionInsuranceComplementaryAmount(Long deductionInsuranceComplementaryAmount) {
        this.deductionInsuranceComplementaryAmount = deductionInsuranceComplementaryAmount;
    }

    public String getDeductionHelpTitle() {
        return deductionHelpTitle;
    }

    public void setDeductionHelpTitle(String deductionHelpTitle) {
        this.deductionHelpTitle = deductionHelpTitle;
    }

    public Long getDeductionHelpAmount() {
        return deductionHelpAmount;
    }

    public void setDeductionHelpAmount(Long deductionHelpAmount) {
        this.deductionHelpAmount = deductionHelpAmount;
    }
}
