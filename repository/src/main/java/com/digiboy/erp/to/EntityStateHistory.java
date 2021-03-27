package com.digiboy.erp.to;

import com.digiboy.erp.to.base.EntityBase;
import com.digiboy.erp.to.base.FSM;
import org.hibernate.annotations.Any;
import org.hibernate.annotations.AnyMetaDef;
import org.hibernate.annotations.MetaValue;

import javax.persistence.*;

@Entity
@Table(name = "entity_state_history")
@SequenceGenerator(name = "SEQUENCE_GENERATOR", sequenceName = "entity_state_history_seq")
public class EntityStateHistory extends EntityBase {

    @Column
    private String state;

    @Any(metaColumn = @Column(name = "entity_type"))
    @AnyMetaDef(
            idType = "long", metaType = "string",
            metaValues = {
                    @MetaValue(targetEntity = Person.class, value = "P"),
                    @MetaValue(targetEntity = Product.class, value = "PR"),
                    @MetaValue(targetEntity = Company.class, value = "C")
//                    @MetaValue(targetEntity = Task.class, value = "T"),
//                    @MetaValue(targetEntity = OrganizationChart.class, value = "O"),
            }
    )
    @JoinColumn(name = "entity_id")
    private FSM entity;

    @Override
    public String getState() {
        return state;
    }

    @Override
    public void setState(String state) {
        this.state = state;
    }

    public FSM getEntity() {
        return entity;
    }

    public void setEntity(FSM entity) {
        this.entity = entity;
    }
}
