package com.michellebalducci.WebAPIChallenge.controller;

import com.michellebalducci.WebAPIChallenge.entity.Customer;
import com.michellebalducci.WebAPIChallenge.entity.Order;
import com.michellebalducci.WebAPIChallenge.repository.CustomerRepository;
import com.michellebalducci.WebAPIChallenge.repository.OrderRepository;
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
import static java.lang.StringUTF16.compareTo;
import static java.util.Objects.compare;

@Controller
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
    public ResponseEntity<List<CustomerRewardsPointsDTO>> loadRewardsAllCustomers() {
        List<Order> listOrders = orderRepository.findAll();
        List<Customer> listCustomers = customerRepository.findAll();
        List<CustomerRewardsPointsDTO> listOfCustomerRewardsPointsDTO = new ArrayList<>();
        CustomerRewardsPointsDTO newCustomerRewardsPointsDTO = new CustomerRewardsPointsDTO();
        Map<UUID, List<Order>> sortedCustomerList = sortOrdersByCustomerId(listOrders);







            listOfCustomerRewardsPointsDTO.add(newCustomerRewardsPointsDTO);
        }


        return ResponseEntity.status(HttpStatus.OK).body(listOfCustomerRewardsPointsDTO);

    }


}
