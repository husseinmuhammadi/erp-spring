package com.digiboy.erp.service;

import com.digiboy.erp.api.EmployeeService;
import com.digiboy.erp.cfg.Endpoint;
import com.digiboy.erp.dto.EmployeeDTO;
import com.digiboy.erp.dto.sg.EmployeeSG;
import com.digiboy.erp.mapper.EmployeeMapper;
import com.digiboy.erp.mapper.EntityMapper;
import com.digiboy.erp.to.Employee;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeServiceImpl extends GeneralServiceImpl<Employee, EmployeeDTO> implements EmployeeService {

    @Autowired
    private EmployeeMapper mapper;

    @Autowired
    public EmployeeServiceImpl(Logger logger) {
        super(logger);
    }

    @Autowired
    private Endpoint endpoint;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    JpaRepository<Employee, Long> getRepository() {
        return null;
    }

    @Override
    EntityMapper<Employee, EmployeeDTO> mapper() {
        return mapper;
    }

    @Override
    public EmployeeDTO findEmployeeByCode(String code) {
        String url = endpoint.getSystemGroupEmployeeByCode() + code;
        EmployeeSG[] sgEmployees = restTemplate.getForObject(url, EmployeeSG[].class);
        if (sgEmployees.length > 0) {
            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.setEmployeeCode(sgEmployees[0].getCode());
            employeeDTO.setSysId(sgEmployees[0].getId());
            return employeeDTO;
        }
        return null;
    }
}
