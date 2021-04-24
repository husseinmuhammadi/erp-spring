package com.digiboy.erp.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin/employees")
@Controller
public class EmployeeController {

    @GetMapping
    public String index() {
        return "";
    }
}
