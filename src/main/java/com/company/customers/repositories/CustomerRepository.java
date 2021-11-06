package com.company.customers.repositories;

import com.company.customers.model.entities.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Page<Customer> findByContactCountryNameIgnoreCaseContaining(String countryName, Pageable pageable);

    Page<Customer> findByContactCountryIsNotNull(Pageable pageable);

    Page<Customer> findByContactCountryIsNull(Pageable pageable);
}


