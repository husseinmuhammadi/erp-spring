package com.digiboy.erp.to;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "X", sequenceName = "SEQ_PERSON")
public class Person {

    @Id
    @GeneratedValue(generator = "X",strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
