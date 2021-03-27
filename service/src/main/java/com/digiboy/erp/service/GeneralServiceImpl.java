package com.digiboy.erp.service;

import com.digiboy.erp.api.GeneralService;
import com.digiboy.erp.dto.DTOBase;
import com.digiboy.erp.mapper.EntityMapper;
import com.digiboy.erp.to.base.EntityBase;
import org.slf4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class GeneralServiceImpl<T extends EntityBase, DT extends DTOBase> implements GeneralService<DT> {

    private final Logger logger;

    public GeneralServiceImpl(Logger logger) {
        this.logger = logger;
    }

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

    @Override
    public List<DT> findAll() {
        return getRepository().findAll()
                .stream().map(mapper()::from)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<DT> findById(Long id) {
        return getRepository().findById(id).map(mapper()::from);
    }
}
