package com.digiboy.erp.mapper;

import com.digiboy.erp.dto.DTOBase;
import com.digiboy.erp.to.base.TEntity;

public interface EntityMapper<T extends TEntity, DT extends DTOBase> {

    /**
     * to entity
     */
    T to(DT dto);

    /**
     * from entity
     */
    DT from(T entity);
}
