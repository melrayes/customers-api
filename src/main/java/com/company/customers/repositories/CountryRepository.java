package com.company.customers.repositories;

import com.company.customers.model.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

    @Query(value = "select c.* from countries c where :phone ~ c.phone_regex", nativeQuery = true)
    Country findByPhone(@Param("phone") String phone);
}