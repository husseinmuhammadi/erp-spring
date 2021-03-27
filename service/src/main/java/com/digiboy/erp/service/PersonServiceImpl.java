package com.digiboy.erp.service;

import com.digiboy.erp.api.PersonService;
import com.digiboy.erp.dto.PersonDTO;
import com.digiboy.erp.mapper.EntityMapper;
import com.digiboy.erp.mapper.PersonMapper;
import com.digiboy.erp.repository.PersonRepository;
import com.digiboy.erp.to.Person;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl extends GeneralServiceImpl<Person, PersonDTO> implements PersonService {

    @Autowired
    PersonRepository repository;

    @Autowired
    PersonMapper mapper;

    @Autowired
    public PersonServiceImpl(Logger logger) {
        super(logger);
    }

    @Override
    JpaRepository<Person, Long> getRepository() {
        return repository;
    }

    @Override
    EntityMapper<Person, PersonDTO> mapper() {
        return mapper;
    }
}
