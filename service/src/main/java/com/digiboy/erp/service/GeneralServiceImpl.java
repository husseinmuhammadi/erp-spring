package com.digiboy.erp.service;

import com.digiboy.erp.api.GeneralService;
import com.digiboy.erp.dto.DTOBase;
import com.digiboy.erp.mapper.EntityMapper;
import com.digiboy.erp.to.base.EntityBase;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public abstract class GeneralServiceImpl<T extends EntityBase, DT extends DTOBase> implements GeneralService<DT> {

    EntityMapper<T, DT> mapper;

}
