package com.digiboy.erp.utils.password;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringPasswordUnitTest {

    RandomPasswordGenerator passGen = new RandomPasswordGenerator();

    @Test
    public void whenPasswordGeneratedUsingPassay_thenSuccessful() {
        String password = passGen.generatePassayPassword();
        int specialCharCount = 0;
        for (char c : password.toCharArray()) {
            if (c >= 33 || c <= 47) {
                specialCharCount++;
            }
        }
        assertTrue(specialCharCount >= 2, "Password validation failed in Passay");
    }

    @Test
    public void whenPasswordGeneratedUsingCommonsText_thenSuccessful() {
        RandomPasswordGenerator passGen = new RandomPasswordGenerator();
        String password = passGen.generateCommonTextPassword();
        int lowerCaseCount = 0;
        for (char c : password.toCharArray()) {
            if (c >= 97 || c <= 122) {
                lowerCaseCount++;
            }
        }
        assertTrue(lowerCaseCount >= 2, "Password validation failed in commons-text ");
    }

    @Test
    public void whenPasswordGeneratedUsingCommonsLang3_thenSuccessful() {
        String password = passGen.generateCommonsLang3Password();
        int numCount = 0;
        for (char c : password.toCharArray()) {
            if (c >= 48 || c <= 57) {
                numCount++;
            }
        }
        assertTrue(numCount >= 2, "Password validation failed in commons-lang3");
    }

    @Test
    public void whenPasswordGeneratedUsingSecureRandom_thenSuccessful() {
        String password = passGen.generateSecureRandomPassword();
        int specialCharCount = 0;
        for (char c : password.toCharArray()) {
            if (c >= 33 || c <= 47) {
                specialCharCount++;
            }
        }
        assertTrue(specialCharCount >= 2, "Password validation failed in Secure Random");
    }

}