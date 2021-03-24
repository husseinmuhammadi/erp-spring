package com.digiboy.erp.mapper;

import com.digiboy.erp.dto.PersonDTO;
import com.digiboy.erp.to.Person;
import org.mapstruct.Mapper;

@Mapper
public interface PersonMapper {

    Person from(PersonDTO personDTO);

    PersonDTO to(Person person);
}
