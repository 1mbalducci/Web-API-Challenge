package com.michellebalducci.WebAPIChallenge.controller;

import com.michellebalducci.WebAPIChallenge.entity.Order;
import com.michellebalducci.WebAPIChallenge.repository.CustomerRepository;
import com.michellebalducci.WebAPIChallenge.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

@Controller
@CrossOrigin(origins = "http://localhost:4200/", allowCredentials = "true")
@RequestMapping
public class CustomerRewardsPointsController {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    OrderRepository orderRepository;

    public CustomerRewardsPointsController(CustomerRepository customerRepository, OrderRepository orderRepository) {
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
    }

    @GetMapping("/rewards/allCustomers")
    public ResponseEntity<List<Order>> loadRewardsAllCustomers() {
        List<Order> listOrders = orderRepository.findAll();
        Order order = new Order();


        return ResponseEntity.status(HttpStatus.OK).body(listOrders);

    }
}
