package com.company.customers.model.entities;

import com.company.customers.services.listener.CustomerListener;

import javax.persistence.*;

@Entity
@Table(name = "customers")
@EntityListeners(CustomerListener.class)
public class Customer {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "phone", column = @Column(name = "contact_phone")),
            @AttributeOverride(name = "country", column = @Column(name = "contact_country"))
    })
    private Contact contact;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
