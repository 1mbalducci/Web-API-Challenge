package com.michellebalducci.WebAPIChallenge.service;

import com.michellebalducci.WebAPIChallenge.entity.Customer;
import com.michellebalducci.WebAPIChallenge.entity.Order;
import com.michellebalducci.WebAPIChallenge.repository.CustomerRepository;
import com.michellebalducci.WebAPIChallenge.repository.OrderRepository;
import com.sun.istack.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class RewardsImpl implements RewardsService{
    //The below is currently not working
    //private static final Logger LOG = LoggerFactory.getLogger(RewardsImpl.class);
    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;

    public RewardsImpl(CustomerRepository customerRepository, OrderRepository orderRepository) {
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
    }


    @Override
    public Optional<Customer> getByIdCustomer(@NotNull UUID id) {
        return customerRepository.findById(id);
        }


    @Override
    public Optional<Order> getByIdOrder(@NotNull UUID id) {
        return orderRepository.findById(id);
    }

    @Override
    public List<Customer> findByName(@NotNull String firstName, @NotNull String lastName) {
        String customerFirstName= firstName;
        String customerLastName= lastName;
        return customerRepository.findBy(customerFirstName, customerLastName);
    }

    public  void setPointsEarnedForOrder(double totalAmount){
        int pointsEarnedForOrder=0;
        if (totalAmount>100){
            pointsEarnedForOrder+= ((totalAmount-100)*2)+50;
        }
        if (totalAmount>50 && totalAmount<=100){
            pointsEarnedForOrder+= (totalAmount-50)*1;
        }

        pointsEarnedForOrder= pointsEarnedForOrder;
    }



    public static void calculateTotalPoints(ArrayList<Order> orders){
        int totalPointsEarned=0;
        for (Order order: orders) {
//            totalPointsEarned+= order.getPointsEarnedForOrder();
        }
    };

    public static void calculatePointsPerMonth(ArrayList<Order> orders) {

    };


}
