package com.digiboy.erp.service;

import com.digiboy.erp.api.GeneralService;
import com.digiboy.erp.dto.CompanyDTO;
import com.digiboy.erp.dto.DTOBase;
import com.digiboy.erp.mapper.EntityMapper;
import com.digiboy.erp.to.base.EntityBase;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class GeneralServiceImpl<T extends EntityBase, DT extends DTOBase> implements GeneralService<DT> {

    abstract JpaRepository<T, Long> getRepository();

    abstract EntityMapper<T, DT> mapper();

    @Override
    public Page<DT> findAll(Pageable pageable) {
        return getRepository().findAll(pageable).map(mapper()::from);
    }

    @Override
    public DT save(DT dto) {
        return mapper().from(getRepository().save(mapper().to(dto)));
    }

    @Override
    public void remove(Long id) {
        getRepository().deleteById(id);
    }
}
