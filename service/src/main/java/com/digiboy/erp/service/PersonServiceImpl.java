package com.digiboy.erp.service;

import com.digiboy.erp.api.PersonService;
import com.digiboy.erp.dto.PersonDTO;
import com.digiboy.erp.mapper.PersonMapper;
import com.digiboy.erp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository repository;

    @Autowired
    PersonMapper mapper;

    @Override
    public void save(PersonDTO personDTO) {
        repository.save(mapper.from(personDTO));
    }
}
