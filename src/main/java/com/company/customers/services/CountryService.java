package com.company.customers.services;

import com.company.customers.model.entities.Country;
import com.company.customers.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public Country findByPhoneNumber(String phone) {
        return countryRepository.findByPhone(phone);
    }
}