package com.digiboy.erp.cfg;

import com.digiboy.erp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class SecurityInitializer {

    @Autowired
    private UserRepository userRepository;

    @EventListener
    public void addAdminUser(ApplicationReadyEvent event) {

    }
}
