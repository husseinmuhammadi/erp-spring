package com.digiboy.erp.web.controller;

import com.digiboy.erp.api.CompanyService;
import com.digiboy.erp.api.GeneralService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/company")
public class CompanyController extends ControllerBase {

    private final Logger logger;

    @Autowired
    private CompanyService service;

    @Autowired
    public CompanyController(Logger logger) {
        this.logger = logger;
    }

    @Override
    GeneralService service() {
        return service;
    }

    @Override
    String index() {
        return "company/index";
    }

}
