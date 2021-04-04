package com.digiboy.erp.to.base;

import javax.persistence.*;

@MappedSuperclass
public class EntityBase implements TEntity {

    @Id
    @GeneratedValue(generator = "SEQUENCE_GENERATOR", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Version
    private Long version;

    @Column(name = "state", length = 40)
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
