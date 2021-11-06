package com.company.customers;

import com.company.customers.model.entities.Contact;
import com.company.customers.model.entities.Customer;
import com.company.customers.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
public class IntegrationTestBase {
    @Autowired
    protected CustomerRepository customerRepository;

    List<String> customerNames = Arrays.asList("Dan", "Joy", "Thomas", "Martin", "George", "Jeff", "David");

    List<String> validPhoneNumber = Arrays.asList("(212) 698054317", "(212) 698054317", "(258) 847651504", "(258) 847602609");

    List<String> notValidPhoneNumbers = Arrays.asList("(212) 6007989253", "(258) 84330678235", "(258) 042423566", "(256) 7503O6263");

    @Test
    void contextLoads() {
    }

    private String generateRandomName() {
        Random rand = new Random();
        return customerNames.get(rand.nextInt(customerNames.size())) + " " + customerNames.get(rand.nextInt(customerNames.size()));
    }

    protected Customer seedCustomerWithNotValidPhoneNumber() {
        Customer customer = new Customer();
        customer.setName(generateRandomName());
        customer.setContact(new Contact());
        Random rand = new Random();
        customer.getContact().setPhone(notValidPhoneNumbers.get(rand.nextInt(notValidPhoneNumbers.size())));
        return customerRepository.save(customer);
    }

    protected Customer seedCustomerWithValidPhoneNumber() {
        Customer customer = new Customer();
        customer.setName(generateRandomName());
        customer.setContact(new Contact());
        Random rand = new Random();
        customer.getContact().setPhone(validPhoneNumber.get(rand.nextInt(validPhoneNumber.size())));
        return customerRepository.save(customer);
    }
}