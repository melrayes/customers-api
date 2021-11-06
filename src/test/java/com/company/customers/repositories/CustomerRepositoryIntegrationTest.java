package com.company.customers.repositories;

import com.company.customers.IntegrationTestBase;
import com.company.customers.model.entities.ContactState;
import com.company.customers.model.entities.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerRepositoryIntegrationTest extends IntegrationTestBase {

    @Test
    void testCreateCustomerWithValidPhoneNumber() {
        Customer customer = seedCustomerWithValidPhoneNumber();
        Assertions.assertNotNull(customer.getContact().getCountry());
        Assertions.assertEquals(ContactState.VALID, customer.getContact().getState());
    }

    @Test
    void testCreateCustomerWithNotValidPhoneNumber() {
        Customer customer = seedCustomerWithNotValidPhoneNumber();
        Assertions.assertNull(customer.getContact().getCountry());
        Assertions.assertEquals(ContactState.NOT_VALID, customer.getContact().getState());
    }

}