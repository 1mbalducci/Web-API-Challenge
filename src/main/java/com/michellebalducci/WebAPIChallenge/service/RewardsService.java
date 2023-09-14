package com.michellebalducci.WebAPIChallenge.service;

import com.michellebalducci.WebAPIChallenge.controller.CustomerRewardsPointsDTO;
import com.michellebalducci.WebAPIChallenge.entity.Customer;
import com.michellebalducci.WebAPIChallenge.entity.Order;
import com.sun.istack.NotNull;
import org.springframework.data.jpa.repository.Query;

import java.util.*;

public interface RewardsService {

    Customer getCustomerById(UUID id);
    Order getByIdOrder(UUID id);
    List<Order> findAllOrders();
    Map<UUID,List<Order>> sortOrdersByCustomerId (List <Order> orders);
    List <CustomerRewardsPointsDTO> createCustomerRewardsPointsDTO (Map<UUID, List<Order>> sortedCustomer);



}
