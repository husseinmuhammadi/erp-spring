package com.digiboy.erp.api;

import com.digiboy.erp.dto.Role;

public interface RoleService {
    Role findByName(String name);

    boolean exists(String name);
}
