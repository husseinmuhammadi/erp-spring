package com.digiboy.erp.web.config;

import com.digiboy.erp.cfg.Endpoint;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("prod")
@Configuration
public class ProductionEndpoint implements Endpoint {
    @Override
    public String getSystemGroupEmployeeByCode() {
        return "http://localhost:9086/api/v1/employees?code=";
    }

    @Override
    public String getSystemGroupEmployeePayStubs() {
        return "http://localhost:9086/api/v1/employees/%d/paystubs";
    }

    @Override
    public String getSystemGroupPayStubPayItems() {
        return "http://localhost:9086/api/v1/paystubs/%s/paystubitems";
    }
}
