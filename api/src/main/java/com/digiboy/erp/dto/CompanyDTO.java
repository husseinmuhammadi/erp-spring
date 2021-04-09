package com.digiboy.erp.dto;

import java.util.List;

public class CompanyDTO extends DTOBase {

    private Long id;

    private String name;

//    private List<EmployeeDTO> employees;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
