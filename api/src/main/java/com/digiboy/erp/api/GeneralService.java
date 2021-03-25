package com.digiboy.erp.api;

import com.digiboy.erp.dto.DTOBase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GeneralService<T extends DTOBase> {

    Page<T> findAll(Pageable pageable);

//    List<T> findAll();

    T save(T dto);

    void remove(Long id);
}
