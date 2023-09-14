package com.michellebalducci.WebAPIChallenge.repository;

import com.michellebalducci.WebAPIChallenge.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> { }
