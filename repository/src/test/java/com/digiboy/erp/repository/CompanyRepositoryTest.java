package com.digiboy.erp.repository;

import com.digiboy.erp.to.Company;
import com.digiboy.erp.to.Employee;
import com.digiboy.erp.utils.JsonUtil;
import org.assertj.core.api.AbstractListAssert;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.ObjectAssert;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CompanyRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(CompanyRepositoryTest.class);

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    void whenSaveCompany_thenCompanyShouldContainsEmployees() {
        Company company = new Company();
        company.setName("SPG");

        Employee employee = new Employee();
        employee.setEmployeeCode("10000001");
//        employee.setCompany(company);

//        company.setEmployees(Arrays.asList(employee));

        Company company1 = companyRepository.save(company);

        Assertions.assertThat(company1.getId()).isNotNull();

        Optional<Company> company2 = companyRepository.findById(company1.getId());

        Assertions.assertThat(company2).isPresent();

//        Assertions.assertThat(company2.get().getEmployees())
//                .isNotEmpty()
//                .hasSize(1)
//                .extracting(Employee::getEmployeeCode)
//                .contains("10000001");

        logger.info(JsonUtil.jsonString(company2.get()));

        /*
        List<Employee> employees = employeeRepository.findAll();

        employees.stream().map(JsonUtil::jsonString).forEach(logger::info);

//        Assertions.assertThat(employeeRepository.findAll())
//                .extracting(Employee::getEmployeeCode);

        List<Company> companies = companyRepository.findAll();


        companies.stream()
                .map(Company::getEmployees)
                .map(JsonUtil::jsonString)
                .forEach(logger::info);

        companies.forEach(company1 -> {
            Assertions.assertThat(company1.getEmployees().size()> 0);
        });
         */
    }

    @Test
    void whenSaveCompany_thenAllEmployeesShouldBeSavedAndRelatedToItsParent() {
        Company company = new Company();
        company.setName("SPG");

        Employee employee = new Employee();
        employee.setEmployeeCode("10000001");

//        company.setEmployees(Arrays.asList(employee));

        companyRepository.save(company);

        List<Employee> employees = employeeRepository.findAll();

        logger.info("----------------------------------------");
        employees.stream().map(JsonUtil::jsonString).forEach(logger::info);
        logger.info("----------------------------------------");

//        Assertions.assertThat(employeeRepository.findAll())
//                .extracting(Employee::getEmployeeCode);

        // companyRepository.findAll().stream().map(JsonUtil::jsonString).forEach(logger::info);
    }
}