package com.digiboy.erp.web.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

    @GetMapping({"/", "/home", "/index"})
    @ResponseBody
    public String index() {
        return "Server is up!";
    }
}
