package com.company.customers.services.listener;

import com.company.customers.model.entities.Country;
import com.company.customers.model.entities.Customer;
import com.company.customers.services.CountryService;
import com.company.customers.utils.BeanUtil;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Objects;

public class CustomerListener {

    @PreUpdate
    @PrePersist
    public void postPersist(Customer customer) {
        if (Objects.isNull(customer.getContact())) {
            return;
        }
        Country country = BeanUtil.getBean(CountryService.class).findByPhoneNumber(customer.getContact().getPhone());
        customer.getContact().setCountry(country);
    }
}