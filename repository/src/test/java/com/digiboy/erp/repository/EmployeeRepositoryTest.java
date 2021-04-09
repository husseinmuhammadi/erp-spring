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

        Company company = new Company();
        Company company1 = companyRepository.save(company);

        Person person1 = new Person();
        person1.setName("Ali");
        personRepository.save(person1);

        Person person = new Person();
        person.setName("Ali");

        Employee employee = new Employee();
        // employee.setPerson(person);
        employee.setEmployeeCode("10000001");
        employee.setCompany(company1);

        employeeRepository.save(employee);

        logger.info("---> {}", employeeRepository.findAll().size());

        employeeRepository.findAll().forEach(emp -> {
            logger.info(JsonUtil.jsonString(emp));
        });
    }
}