package com.digiboy.erp.mapper;

import com.digiboy.erp.dto.PersonDTO;
import com.digiboy.erp.to.Person;
import org.mapstruct.Mapper;

@Mapper
public interface PersonMapper extends EntityMapper<Person, PersonDTO> {
}
