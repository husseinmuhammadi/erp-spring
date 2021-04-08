package com.digiboy.erp.to;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("L")
public class LoanPayStubItem extends PayStubItem {
}
