package com.digiboy.erp.mapper;

import com.digiboy.erp.dto.DTOBase;
import com.digiboy.erp.to.base.EntityBase;

public interface EntityMapper<T extends EntityBase, DT extends DTOBase> {

    /**
     * to entity
     */
    T to(DT dto);

    /**
     * from entity
     */
    DT from(T entity);
}
