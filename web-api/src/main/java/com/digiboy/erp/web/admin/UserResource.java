package com.digiboy.erp.web.admin;


import com.digiboy.erp.api.EmployeeService;
import com.digiboy.erp.api.UserService;
import com.digiboy.erp.dto.EmployeeDTO;
import com.digiboy.erp.dto.UserDTO;
import com.digiboy.erp.utils.JsonUtil;
import com.digiboy.erp.utils.password.RandomPasswordGenerator;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/admin/users")
@RestController
public class UserResource {

    private final Logger logger;

    @Autowired
    private UserService userService;

    @Autowired
    private EmployeeService employeeService;

    RandomPasswordGenerator passwordGenerator = new RandomPasswordGenerator();

    public UserResource(Logger logger) {
        this.logger = logger;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<UserDTO> users = userService.findAll();
        return ResponseEntity.ok(users);
    }

    @ResponseBody
    @PutMapping("/setup/password")
    public String resetAllPasswords() {
        List<EmployeeDTO> employees = employeeService.fetchAll();
        for (EmployeeDTO employee : employees) {
            UserDTO user = new UserDTO();
            user.setUsername(employee.getEmployeeCode());
            user.setPassword(passwordGenerator.generatePassayPassword());
            logger.info(JsonUtil.jsonString(user));
            userService.save(user);
        }
        return "Done";
    }
}
