package com.digiboy.erp.to;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("D")
public class DeductionPayStubItem extends PayStubItem {
}
