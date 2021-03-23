package com.digiboy.erp.service;

import com.digiboy.erp.api.UserService;
import com.digiboy.erp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;

}
