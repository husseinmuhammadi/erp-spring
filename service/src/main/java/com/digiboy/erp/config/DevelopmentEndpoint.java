package com.digiboy.erp.config;

import com.digiboy.erp.cfg.Endpoint;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("dev")
@Configuration
public class DevelopmentEndpoint implements Endpoint {
    @Override
    public String getSystemGroupAllEmployees() {
        return "http://178.173.146.154:8086/api/v1/employees";
    }

    @Override
    public String getSystemGroupEmployeeByCode() {
        return "http://178.173.146.154:8086/api/v1/employees?code=";
    }

    @Override
    public String getSystemGroupEmployeePayStubs() {
        return "http://178.173.146.154:8086/api/v1/employees/%d/paystubs";
    }

    @Override
    public String getSystemGroupEmployeeLoans() {
        return "http://178.173.146.154:8086/api/v1/employees/%d/loans";
    }

    @Override
    public String getSystemGroupEmployeeAttendance() {
        return "http://178.173.146.154:8086/api/v1/employees/%d/attendance/%s/%s";
    }

    @Override
    public String getSystemGroupPayStubPayItems() {
        return "http://178.173.146.154:8086/api/v1/paystubs/%s/paystubitems";
    }

    @Override
    public String getSystemGroupPayEmployeeIssueYears() {
        return "http://178.173.146.154:8086/api/v1/employees/%d/paystubs/issue-years";
    }
}
