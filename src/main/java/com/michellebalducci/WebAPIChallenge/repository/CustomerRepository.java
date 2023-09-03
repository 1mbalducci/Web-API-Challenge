package com.michellebalducci.WebAPIChallenge.repository;

import com.michellebalducci.WebAPIChallenge.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
