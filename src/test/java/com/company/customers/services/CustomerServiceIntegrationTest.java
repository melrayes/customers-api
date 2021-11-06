package com.company.customers.services;

import com.company.customers.IntegrationTestBase;
import com.company.customers.model.entities.ContactState;
import com.company.customers.model.entities.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

public class CustomerServiceIntegrationTest extends IntegrationTestBase {

    @Autowired
    private CustomerService customerService;

    @Test
    void testFilteringWithCountryName() {
        seedCustomerWithNotValidPhoneNumber();
        seedCustomerWithNotValidPhoneNumber();
        seedCustomerWithNotValidPhoneNumber();
        Customer customer1 = seedCustomerWithValidPhoneNumber();
        Customer customer2 = seedCustomerWithValidPhoneNumber();
        Customer customer3 = seedCustomerWithValidPhoneNumber();

        Page<Customer> result = customerService.listCustomers(0, 10, customer1.getContact().getCountry().getName());
        Assertions.assertTrue(result.getTotalElements() > 0);

        result = customerService.listCustomers(0, 10, customer2.getContact().getCountry().getName());
        Assertions.assertTrue(result.getTotalElements() > 0);

        result = customerService.listCustomers(0, 10, customer3.getContact().getCountry().getName());
        Assertions.assertTrue(result.getTotalElements() > 0);
    }

    @Test
    void testFilteringWithContactState() {
        seedCustomerWithNotValidPhoneNumber();
        seedCustomerWithNotValidPhoneNumber();
        seedCustomerWithNotValidPhoneNumber();
        seedCustomerWithNotValidPhoneNumber();

        seedCustomerWithValidPhoneNumber();
        seedCustomerWithValidPhoneNumber();
        seedCustomerWithValidPhoneNumber();

        Page<Customer> result = customerService.listCustomers(0, 10, ContactState.VALID);
        Assertions.assertEquals(3, result.getTotalElements());

        result = customerService.listCustomers(0, 10, ContactState.NOT_VALID);
        Assertions.assertEquals(4, result.getTotalElements());
    }
}