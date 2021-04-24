package com.digiboy.erp.web.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    private final Logger logger;

    public LoginController(Logger logger) {
        this.logger = logger;
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        logger.info("Redirecting to login page ...");
        if (error != null) {
            logger.warn("Your username and password is invalid.");
            model.addAttribute("error", "Your username and password is invalid.");
        }
        if (logout != null) {
            logger.info("You have been logged out successfully.");
            model.addAttribute("message", "You have been logged out successfully.");
        }
        return "login";
    }
}
