package com.digiboy.erp.web.controller;

import com.digiboy.erp.api.CompanyService;
import com.digiboy.erp.api.GeneralService;
import com.digiboy.erp.dto.CompanyDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
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
    Logger getLogger() {
        return logger;
    }

    @Override
    GeneralService service() {
        return service;
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

    @PostMapping("/save")
    public String save(CompanyDTO dto) {
        try {
            getLogger().info("Saving user");
            ObjectMapper mapper = new ObjectMapper();
            logger.info(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dto));
            CompanyDTO dto1 = service.save(dto);
            return "redirect:/admin/company/index";
        } catch (Exception e) {
            getLogger().error("Error during saving entity", e);
            return null;
        }
    }

}
