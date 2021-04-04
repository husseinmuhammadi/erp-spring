package com.digiboy.erp.service;

import com.digiboy.erp.api.UserService;
import com.digiboy.erp.dto.UserDTO;
import com.digiboy.erp.mapper.UserMapper;
import com.digiboy.erp.repository.UserRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final Logger logger;

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserMapper mapper;

    public UserServiceImpl(Logger logger) {
        this.logger = logger;
    }

    @Override
    public Page<UserDTO> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::from);
    }

    @Override
    public List<UserDTO> findAll() {
        return repository.findAll()
                .stream().map(mapper::from)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserDTO> findById(String username) {
        return repository.findById(username).map(mapper::from);
    }

    @Override
    public UserDTO save(UserDTO dto) {
        return mapper.from(repository.save(mapper.to(dto)));
    }

    @Override
    public void remove(String username) {
        repository.deleteById(username);
    }
}
