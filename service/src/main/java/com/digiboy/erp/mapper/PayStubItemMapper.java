package com.digiboy.erp.mapper;

import com.digiboy.erp.dto.*;
import com.digiboy.erp.to.*;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper
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
        } else if (payStubItem instanceof OtherPayStubItem) {
            return this.map((OtherPayStubItem) payStubItem);
        } else {
            return this.map((LoanPayStubItem) payStubItem);
        }
    }

    @InheritInverseConfiguration
    default PayStubItem map(PayStubItemDTO payStubItemDTO) {
        if (payStubItemDTO instanceof DeductionPayStubItemDTO) {
            return this.map((DeductionPayStubItemDTO) payStubItemDTO);
        } else if (payStubItemDTO instanceof EarningPayStubItemDTO) {
            return this.map((EarningPayStubItemDTO) payStubItemDTO);
        } else if (payStubItemDTO instanceof OtherPayStubItemDTO) {
            return this.map((OtherPayStubItemDTO) payStubItemDTO);
        } else {
            return this.map((LoanPayStubItemDTO) payStubItemDTO);
        }
    }
}
