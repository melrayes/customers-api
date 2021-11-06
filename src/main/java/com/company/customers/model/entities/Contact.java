package com.company.customers.model.entities;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class Contact {
    private String phone;

    @ManyToOne
    private Country country;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public ContactState getState() {
        return getCountry() != null ? ContactState.VALID : ContactState.NOT_VALID;
    }
}
