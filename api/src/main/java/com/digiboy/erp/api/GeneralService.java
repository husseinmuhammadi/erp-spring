package com.digiboy.erp.api;

import com.digiboy.erp.dto.DTOBase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GeneralService<T extends DTOBase> {
    Page<T> findAll(Pageable pageable);

    T save(T dto);
}
