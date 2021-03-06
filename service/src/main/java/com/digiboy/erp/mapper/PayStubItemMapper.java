package com.digiboy.erp.mapper;

import com.digiboy.erp.dto.*;
import com.digiboy.erp.exception.MappingException;
import com.digiboy.erp.to.*;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(uses = {PayStubMapper.class})
public interface PayStubItemMapper extends EntityMapper<PayStubItem, PayStubItemDTO> {

    DeductionPayStubItem map(DeductionPayStubItemDTO deductionPayStubItemDTO);

    DeductionPayStubItemDTO map(DeductionPayStubItem deductionPayStubItem);

    EarningPayStubItem map(EarningPayStubItemDTO earningPayStubItemDTO);

    EarningPayStubItemDTO map(EarningPayStubItem earningPayStubItem);

    LoanPayStubItem map(LoanPayStubItemDTO loanPayStubItemDTO);

    LoanPayStubItemDTO map(LoanPayStubItem loanPayStubItem);

    OtherPayStubItem map(OtherPayStubItemDTO otherPayStubItemDTO);

    OtherPayStubItemDTO map(OtherPayStubItem otherPayStubItem);

    default PayStubItemDTO map(PayStubItem payStubItem) {
        if (payStubItem instanceof DeductionPayStubItem) {
            return this.map((DeductionPayStubItem) payStubItem);
        } else if (payStubItem instanceof EarningPayStubItem) {
            return this.map((EarningPayStubItem) payStubItem);
        } else {
            throw new MappingException("Error in mapping from PayStubItem to PayStubItemDTO");
        }
    }

    @InheritInverseConfiguration
    default PayStubItem map(PayStubItemDTO payStubItemDTO) {
        if (payStubItemDTO instanceof DeductionPayStubItemDTO) {
            return this.map((DeductionPayStubItemDTO) payStubItemDTO);
        } else if (payStubItemDTO instanceof EarningPayStubItemDTO) {
            return this.map((EarningPayStubItemDTO) payStubItemDTO);
        } else {
            throw new MappingException("Error in mapping from PayStubItemDTO to PayStubItem");
        }
    }
}
