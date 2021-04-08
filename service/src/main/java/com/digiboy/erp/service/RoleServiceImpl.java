package com.digiboy.erp.service;

import com.digiboy.erp.api.RoleService;
import com.digiboy.erp.dto.Role;
import com.digiboy.erp.mapper.RoleMapper;
import com.digiboy.erp.repository.RoleRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private final Logger logger;

    @Autowired
    private RoleRepository repository;

    @Autowired
    private RoleMapper mapper;

    public RoleServiceImpl(Logger logger) {
        this.logger = logger;
    }

    @Override
    public Role findByName(String name) {
        return mapper.map(repository.findByName(name));
    }

    @Override
    public boolean exists(String name) {
        return repository.existsByName(name);
    }
}
