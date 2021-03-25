package com.digiboy.erp.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/company")
public class CompanyController {

    private Logger logger = LoggerFactory.getLogger(CompanyController.class);

    @GetMapping("/index")
    public String index() {
        logger.info("CompanyController -> index");
        return "company/index";
    }

}
