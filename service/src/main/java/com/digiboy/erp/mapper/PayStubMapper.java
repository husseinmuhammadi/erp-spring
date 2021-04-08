package com.digiboy.erp.mapper;

import com.digiboy.erp.dto.PayStubDTO;
import com.digiboy.erp.to.PayStub;
import org.mapstruct.Mapper;

@Mapper
public interface PayStubMapper extends EntityMapper<PayStub, PayStubDTO> {
}
