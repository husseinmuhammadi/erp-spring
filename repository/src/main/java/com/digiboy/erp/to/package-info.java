@AnyMetaDef(
        name = "XXX",
        idType = "long", metaType = "string",
        metaValues = {
                @MetaValue(targetEntity = Person.class, value = "P"),
                @MetaValue(targetEntity = Product.class, value = "PR"),
                @MetaValue(targetEntity = Company.class, value = "C")
//                    @MetaValue(targetEntity = Task.class, value = "T"),
//                    @MetaValue(targetEntity = OrganizationChart.class, value = "O"),
        }
)
package com.digiboy.erp.to;

import org.hibernate.annotations.AnyMetaDef;
import org.hibernate.annotations.MetaValue;