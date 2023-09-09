package com.michellebalducci.WebAPIChallenge.service;

import com.michellebalducci.WebAPIChallenge.entity.Customer;
import com.michellebalducci.WebAPIChallenge.entity.Order;
import com.sun.istack.NotNull;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RewardsService {

    Optional<Customer> getByIdCustomer(UUID id);
    Optional <Order> getByIdOrder(UUID id);

//    List<Customer> findByName(@NotNull String firstName, @NotNull String lastName);


}
