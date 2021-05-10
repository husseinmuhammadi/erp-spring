package com.digiboy.erp.dto;

import java.util.HashSet;
import java.util.Set;

public class UserDTO extends DTOBase {

    public UserDTO() {
    }

    public UserDTO(String username) {
        this.username = username;
    }

    private String username;
    private String password;
    private String cleanPassword;
    private String email;

    private Set<Role> roles = new HashSet<>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getCleanPassword() {
        return cleanPassword;
    }

    public void setCleanPassword(String cleanPassword) {
        this.cleanPassword = cleanPassword;
    }
}
