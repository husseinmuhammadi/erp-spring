package com.digiboy.erp.to.base;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.io.Serializable;

@MappedSuperclass
public class AbstractEntityBase<T extends Serializable> {

    @Id
    private T id;

    @Version
    private Long version;


    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
