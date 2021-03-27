package com.digiboy.erp.to;

import com.digiboy.erp.to.base.EntityBase;

import javax.persistence.*;

@Entity
@Table(name = "account")
@SequenceGenerator(name = "SEQUENCE_GENERATOR", sequenceName = "account_seq")
public class Account extends EntityBase {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username")
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
