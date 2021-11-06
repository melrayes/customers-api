package com.company.customers.services;

import com.company.customers.model.entities.ContactState;
import com.company.customers.model.entities.Customer;
import com.company.customers.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Page<Customer> listCustomers(int page, int size) {
        return customerRepository.findAll(PageRequest.of(page, size));
    }

    public Page<Customer> listCustomers(int page, int size, String countryName) {
        return customerRepository.findByContactCountryNameIgnoreCaseContaining(countryName, PageRequest.of(page, size));
    }

    public Page<Customer> listCustomers(int page, int size, ContactState state) {
        if (ContactState.VALID.equals(state)) {
            return customerRepository.findByContactCountryIsNotNull(PageRequest.of(page, size));
        } else if (ContactState.NOT_VALID.equals(state)) {
            return customerRepository.findByContactCountryIsNull(PageRequest.of(page, size));
        } else {
            throw new IllegalArgumentException("Not Valid Contact State");
        }
    }
}