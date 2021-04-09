package com.digiboy.erp.repository;

import com.digiboy.erp.to.Company;
import com.digiboy.erp.to.Employee;
import com.digiboy.erp.to.Person;
import com.digiboy.erp.utils.JsonUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class EmployeeRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(EmployeeRepositoryTest.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Test
    void name() {
        Employee employee = new Employee();
        employee.setEmployeeCode("10000001");

        employeeRepository.save(employee);

        logger.info("---> {}", employeeRepository.findAll().size());

        employeeRepository.findAll().forEach(emp -> {
            logger.info(JsonUtil.jsonString(emp));
        });
    }
}