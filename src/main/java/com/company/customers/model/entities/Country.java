package com.company.customers.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "countries")
public class Country {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String phoneRegex;

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

    public String getPhoneRegex() {
        return phoneRegex;
    }

    public void setPhoneRegex(String phoneRegex) {
        this.phoneRegex = phoneRegex;
    }
}