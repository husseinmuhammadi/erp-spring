package com.digiboy.erp.web.controller.admin;

import com.digiboy.erp.api.CompanyService;
import com.digiboy.erp.api.GeneralService;
import com.digiboy.erp.dto.CompanyDTO;
import com.digiboy.erp.dto.DTOBase;
import com.digiboy.erp.web.controller.base.ControllerBase;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/company")
public class CompanyController extends ControllerBase<CompanyDTO> {

    @Autowired
    private CompanyService service;

    @Autowired
    public CompanyController(Logger logger) {
        super(logger);
    }

    @Override
    protected GeneralService service() {
        return service;
    }

    @Override
    public DTOBase getModel() {
        logger.info("----------> create new company");
        return new CompanyDTO();
    }

    @Override
    protected String index() {
        return "company/index";
    }

    @Override
    protected String entry() {
        return "company/insert";
    }

    @Override
    protected String indexController() {
        return "/admin/company/index";
    }
}
