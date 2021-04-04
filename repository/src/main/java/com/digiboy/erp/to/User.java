package com.digiboy.erp.to;

import com.digiboy.erp.to.base.TEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements TEntity {

    @Id
    private String username;

    private String password;

    private String email;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "USER_ROLE",
            joinColumns = @JoinColumn(name = "username", referencedColumnName = "username", foreignKey = @ForeignKey(name = "FK_USER_ROLE_USER")),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_USER_ROLE_ROLE"))
    )
    Set<Role> roles = new HashSet<>();

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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
