package com.digiboy.erp.dto;

public class Role extends DTOBase{

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
