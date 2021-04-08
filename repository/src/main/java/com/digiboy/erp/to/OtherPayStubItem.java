package com.digiboy.erp.to;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("O")
public class OtherPayStubItem extends PayStubItem {
}
