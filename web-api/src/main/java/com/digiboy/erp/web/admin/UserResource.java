package com.digiboy.erp.web.admin;


import com.digiboy.erp.api.EmployeeService;
import com.digiboy.erp.api.UserService;
import com.digiboy.erp.dto.EmployeeDTO;
import com.digiboy.erp.dto.UserDTO;
import com.digiboy.erp.utils.JsonUtil;
import com.digiboy.erp.utils.password.RandomPasswordGenerator;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
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

    @GetMapping(value = "/exportCSV", produces = "text/csv")
    public ResponseEntity<Resource> exportCSV() {
        // replace this with your header (if required)
        String[] csvHeader = {
                "employee", "username", "password"
        };

        // replace this with your data retrieving logic
        List<List<String>> csvBody = new ArrayList<>();

        List<UserDTO> users = userService.findAll();
        for (UserDTO user : users) {
            csvBody.add(Arrays.asList(user.getUsername(), user.getUsername(), user.getCleanPassword()));
        }

        ByteArrayInputStream byteArrayOutputStream;

        // closing resources by using a try with resources
        // https://www.baeldung.com/java-try-with-resources
        try (
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                // defining the CSV printer
                CSVPrinter csvPrinter = new CSVPrinter(
                        new PrintWriter(out),
                        // withHeader is optional
                        CSVFormat.DEFAULT.withHeader(csvHeader)
                );
        ) {
            // populating the CSV content
            for (List<String> record : csvBody)
                csvPrinter.printRecord(record);

            // writing the underlying stream
            csvPrinter.flush();

            byteArrayOutputStream = new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

        InputStreamResource fileInputStream = new InputStreamResource(byteArrayOutputStream);

        String csvFileName = "employees.csv";

        // setting HTTP headers
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + csvFileName);
        // defining the custom Content-Type
        headers.set(HttpHeaders.CONTENT_TYPE, "text/csv");

        return new ResponseEntity<>(
                fileInputStream,
                headers,
                HttpStatus.OK
        );
    }
}
