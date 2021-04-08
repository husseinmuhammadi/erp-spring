package com.digiboy.erp.mapper;

import com.digiboy.erp.dto.PayStubItemDTO;
import com.digiboy.erp.to.DeductionPayStubItem;
import org.mapstruct.Mapper;

@Mapper
public interface PayStubItemMapper extends EntityMapper<DeductionPayStubItem, PayStubItemDTO> {
}
