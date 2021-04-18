package com.digiboy.erp.api;

import com.digiboy.erp.dto.PayStubDTO;

import java.util.List;

public interface PayStubService extends GeneralService<PayStubDTO> {
    List<String> findAllHeadings();
    PayStubDTO findByPayDate();
}
