package com.digiboy.erp.repository;

import com.digiboy.erp.to.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

    boolean existsByName(String name);
}
