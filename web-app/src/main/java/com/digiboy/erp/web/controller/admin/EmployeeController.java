package com.digiboy.erp.web.controller.admin;

import com.digiboy.erp.api.EmployeeService;
import com.digiboy.erp.api.GeneralService;
import com.digiboy.erp.dto.DTOBase;
import com.digiboy.erp.dto.EmployeeDTO;
import com.digiboy.erp.web.controller.base.ControllerBase;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin/employees")
@Controller
public class EmployeeController extends ControllerBase<EmployeeDTO> {

    @Autowired
    private EmployeeService service;

    @Autowired
    public EmployeeController(Logger logger) {
        super(logger);
    }

    @Override
    protected GeneralService<EmployeeDTO> service() {
        return service;
    }

    @Override
    public DTOBase getModel() {
        return new EmployeeDTO();
    }

    @Override
    protected String index() {
        return null;
    }

    @Override
    protected String entry() {
        return null;
    }

    @Override
    protected String indexController() {
        return null;
    }
}
