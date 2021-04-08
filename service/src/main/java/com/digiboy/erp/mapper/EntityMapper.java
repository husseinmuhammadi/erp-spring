package com.digiboy.erp.mapper;

import com.digiboy.erp.dto.DTOBase;
import com.digiboy.erp.to.base.TEntity;

public interface EntityMapper<T extends TEntity, DT extends DTOBase> {

    /**
     * to entity
     */
    T map(DT dto);

    /**
     * from entity
     */
    DT map(T entity);
}
