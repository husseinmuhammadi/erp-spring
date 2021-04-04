package com.digiboy.erp.web.security;

import com.digiboy.erp.api.RoleService;
import com.digiboy.erp.api.UserService;
import com.digiboy.erp.dto.Role;
import com.digiboy.erp.dto.UserDTO;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:administrative.properties")
public class SecurityInitializer {

    public final Logger logger;

    @Autowired
    private UserService userService;

    @Autowired
    RoleService roleService;

    @Value("${admin.password}")
    private String adminPassword;

    public SecurityInitializer(Logger logger) {
        this.logger = logger;
    }

    @EventListener
    public void addAdminUser(ApplicationReadyEvent event) {
        UserDTO admin = new UserDTO("admin");
        if (userService.exists(admin.getUsername())) {
            logger.info("User {} is already exists, it will keep untouched", admin.getUsername());
            return;
        }

        logger.info("Instantiate admin user with password {}", adminPassword);
        Role role;

        role = getExistingRoleOtherwiseNewRole("ADMIN");
        admin.getRoles().add(role);

        role = getExistingRoleOtherwiseNewRole("USER");
        admin.getRoles().add(role);

        admin.setPassword(adminPassword);
        userService.save(admin);
    }

    /**
     * pickup role by given name
     * @param name
     * @return an existing role otherwise pickup a new one
     */
    private Role getExistingRoleOtherwiseNewRole(final String name) {
        Role role = roleService.findByName(name);
        if (role != null) {
            logger.info("Role {} is exists, it will pickup by user", role.getName());
        } else {
            role = new Role(name);
            logger.info("Role {} is not exists, it will be prepared", name);
        }
        return role;
    }
}
