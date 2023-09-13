package com.michellebalducci.WebAPIChallenge.controller;

import com.michellebalducci.WebAPIChallenge.entity.Customer;
import com.michellebalducci.WebAPIChallenge.entity.Order;
import com.michellebalducci.WebAPIChallenge.repository.CustomerRepository;
import com.michellebalducci.WebAPIChallenge.repository.OrderRepository;
import com.michellebalducci.WebAPIChallenge.service.RewardsService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.http.HttpResponse;
import java.util.*;
import java.util.stream.Collectors;

import static com.michellebalducci.WebAPIChallenge.service.RewardsImpl.*;


@Controller
@RequestMapping
public class CustomerRewardsPointsController {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    OrderRepository orderRepository;
    RewardsService rewardsService;

    public CustomerRewardsPointsController(CustomerRepository customerRepository, OrderRepository orderRepository,RewardsService rewardsService) {
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
        this.rewardsService= rewardsService;
    }

    @GetMapping("/rewards/allCustomers")
    public ResponseEntity<List<CustomerRewardsPointsDTO>> loadRewardsAllCustomers() {
        List<Order> listOrders = orderRepository.findAll();
        List<Customer> listCustomers = customerRepository.findAll();

        CustomerRewardsPointsDTO newCustomerRewardsPointsDTO = new CustomerRewardsPointsDTO();
        Map<UUID, List<Order>> sortedCustomerList = rewardsService.sortOrdersByCustomerId(listOrders);
        List<CustomerRewardsPointsDTO> listOfCustomerRewardsPointsDTO =rewardsService.createCustomerRewardsPointsDTO(sortedCustomerList);
        return ResponseEntity.status(HttpStatus.OK).body(listOfCustomerRewardsPointsDTO);

    }


}
