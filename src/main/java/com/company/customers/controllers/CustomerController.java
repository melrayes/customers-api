package com.company.customers.controllers;

import com.company.customers.model.dtos.CustomerDTO;
import com.company.customers.model.dtos.CustomerResponseDTO;
import com.company.customers.model.entities.ContactState;
import com.company.customers.model.entities.Customer;
import com.company.customers.services.CustomerService;
import com.company.customers.utils.DTOTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/customers")
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private DTOTransformer dtoTransformer;

    @GetMapping
    public ResponseEntity<CustomerResponseDTO> findPaginated(@RequestParam(name = "page", defaultValue = "0") int page,
                                                             @RequestParam(name = "size", defaultValue = "10") int size,
                                                             @RequestParam(name = "contactCountryName", required = false) String contactCountryName,
                                                             @RequestParam(name = "contactState", required = false) String contactState) {

        ContactState contactStateValue = ContactState.fromName(contactState);
        Page<Customer> customerPages = null;

        if (Objects.isNull(contactCountryName) && Objects.isNull(contactStateValue)) {
            customerPages = customerService.listCustomers(page, size);
        } else if (Objects.nonNull(contactCountryName)) {
            customerPages = customerService.listCustomers(page, size, contactCountryName);
        } else if (Objects.nonNull(contactStateValue)) {
            customerPages = customerService.listCustomers(page, size, contactStateValue);
        }

        if (customerPages != null) {
            CustomerResponseDTO responseDTO = new CustomerResponseDTO(customerPages.getNumber(),
                    customerPages.getSize(), customerPages.getTotalElements());
            responseDTO.setContent(dtoTransformer.transform(customerPages.getContent(), CustomerDTO.class));
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}