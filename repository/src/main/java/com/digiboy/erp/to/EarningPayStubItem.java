package com.digiboy.erp.to;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("E")
public class EarningPayStubItem extends PayStubItem {
}
