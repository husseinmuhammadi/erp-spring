package com.digiboy.erp.service;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PayStubServiceTest {
    @Test
    void extractLeaveUsedInCurrentMonth() {
        List<String> result = new ArrayList<>();
        Long value = 14560L;
        result.add(String.format("%02d", value % 60));
        value = value / 60;
        result.add(String.format("%02d", value % 24));
        value = value / 24;
        result.add(String.format("%02d", value));
        Collections.reverse(result);
        assertEquals(StringUtils.join(result, ":"), "10:02:40");
    }

    @Test
    void getLeaveBalanceValueFromResourceBundle() {
        ResourceBundle bundle = ResourceBundle.getBundle("paystub", new Locale("fa", "IR"));
        System.out.println(bundle.getString("leave.balance"));
    }
}