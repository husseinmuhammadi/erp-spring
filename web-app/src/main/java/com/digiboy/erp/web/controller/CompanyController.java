package com.digiboy.erp.web.controller;

import com.digiboy.erp.api.CompanyService;
import com.digiboy.erp.api.GeneralService;
import com.digiboy.erp.dto.CompanyDTO;
import com.digiboy.erp.dto.DTOBase;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/company")
public class CompanyController extends ControllerBase {

    @Autowired
    private CompanyService service;

    @Autowired
    public CompanyController(Logger logger) {
        super(logger);
    }

    @Override
    GeneralService service() {
        return service;
    }

    @Override
    public DTOBase getModel() {
        logger.info("----------> create new company");
        return new CompanyDTO();
    }

    @Override
    String index() {
        return "company/index";
    }

    @Override
    String entry() {
        return "company/insert";
    }

    @Override
    String indexController() {
        return "redirect:/admin/company/index";
    }
}
