package com.michellebalducci.WebAPIChallenge.controller;

import com.michellebalducci.WebAPIChallenge.entity.Customer;
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
        List<CustomerRewardsPointsDTO> listOfCustomerRewardsPointsDTO= new ArrayList<>();
        Map<UUID,List<Order>>sortedCustomerList =sortOrdersByCustomerId(listOrders);




git
        CustomerRewardsPointsDTO newCustomerRewardsPointsDTO = new CustomerRewardsPointsDTO();
        for (Order order: listOrders) {

            int totalPointsEarned = calculateTotalPointsPerCustomer(listOrders);
            int janRewardsPoints= calculatePointsJanuary(listOrders);
            int februaryRewardsPoints = calculatePointsFebruary(listOrders);
            int marchRewardsPoints = calculatePointsMarch(listOrders);

            newCustomerRewardsPointsDTO.setTotalPointsPerCustomer(totalPointsEarned);
            newCustomerRewardsPointsDTO.setCustomerPointsEarnedJan(janRewardsPoints);
            newCustomerRewardsPointsDTO.setCustomerPointsEarnedFeb(februaryRewardsPoints);
            newCustomerRewardsPointsDTO.setCustomerPointsEarnedMar(marchRewardsPoints);


            listOfCustomerRewardsPointsDTO.add(newCustomerRewardsPointsDTO);
        }


        return ResponseEntity.status(HttpStatus.OK).body(listOfCustomerRewardsPointsDTO);

    }
}
