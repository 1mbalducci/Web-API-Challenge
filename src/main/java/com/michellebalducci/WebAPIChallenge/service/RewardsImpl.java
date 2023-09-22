package com.michellebalducci.WebAPIChallenge.service;

import com.michellebalducci.WebAPIChallenge.controller.CustomerRewardsPointsDTO;
import com.michellebalducci.WebAPIChallenge.entity.Customer;
import com.michellebalducci.WebAPIChallenge.entity.Order;
import com.michellebalducci.WebAPIChallenge.repository.CustomerRepository;
import com.michellebalducci.WebAPIChallenge.repository.OrderRepository;
import com.sun.istack.NotNull;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RewardsImpl implements RewardsService {
    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;


    public RewardsImpl(CustomerRepository customerRepository, OrderRepository orderRepository) {
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public Customer getCustomerById(@NotNull UUID id) {
        Optional<Customer> optionalCustomer=customerRepository.findById(id);
        Customer customerEntity= optionalCustomer.get();
        return customerEntity;
    }

    @Override
    public  Order getByIdOrder(@NotNull UUID id) {
        Optional<Order> optionalOrder=orderRepository.findById(id);
        Order orderEntity= optionalOrder.get();
        return orderEntity;
    }

    @Override
    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public  Map<UUID,List<Order>> sortOrdersByCustomerId (List <Order> orders){
        Map<UUID, List<Order>> sortedlistCustomers = new HashMap<>();
        for (Order order : orders) {
            if (!sortedlistCustomers.containsKey(order.getCustomerId())) {
                sortedlistCustomers.put(order.getCustomerId(), new ArrayList<>());
            }
            sortedlistCustomers.get(order.getCustomerId()).add(order);
        }
        return sortedlistCustomers;
    };

    public int pointsEarnedForOrder(double totalAmount) {
        int pointsEarnedForOrder = 0;
        if (totalAmount > 100) {
            pointsEarnedForOrder += ((totalAmount - 100) * 2) + 50;
        }
        if (totalAmount > 50 && totalAmount <= 100) {
            pointsEarnedForOrder += (totalAmount - 50) * 1;
        }
        return pointsEarnedForOrder;
    }

    public int calculateTotalPointsPerCustomer(Order order) {
        int totalPointsEarned = 0;
                totalPointsEarned += pointsEarnedForOrder(order.getTotalAmount());
        return totalPointsEarned;
    }

    public int calculatePointsJanuary(Order order) {
        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();
        startDate.set(2023, Calendar.JANUARY, 1,0,0,0);
        endDate.set(2023, Calendar.FEBRUARY, 1,0,0,0);
        int customerPointsEarnedJan = 0;
            if (order.getDateOfOrder().before(endDate) && order.getDateOfOrder().after(startDate)
                    || order.getDateOfOrder().equals(startDate)) {
                customerPointsEarnedJan = pointsEarnedForOrder(order.getTotalAmount());
            }
        return customerPointsEarnedJan;

    }
    public int calculatePointsFebruary(Order order) {
        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();
        startDate.set(2023, Calendar.FEBRUARY, 1,0,0,0);
        endDate.set(2023, Calendar.MARCH, 1,0,0,0);
      int customerPointsEarnedFeb = 0;
            if (order.getDateOfOrder().before(endDate) && order.getDateOfOrder().after(startDate)
                    || order.getDateOfOrder().equals(startDate)) {
                customerPointsEarnedFeb= pointsEarnedForOrder(order.getTotalAmount());
            }
        return customerPointsEarnedFeb;
    };

    public int calculatePointsMarch(Order order) {
        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();
        startDate.set(2023, Calendar.MARCH, 1,0,0,0);
        endDate.set(2023, Calendar.APRIL, 1,0,0,0);
        int customerPointsEarnedFeb = 0;
            if (order.getDateOfOrder().before(endDate) && order.getDateOfOrder().after(startDate)
                    || order.getDateOfOrder().equals(startDate)) {
                customerPointsEarnedFeb = pointsEarnedForOrder(order.getTotalAmount());
            }
        return customerPointsEarnedFeb;
    }


    public Map<String , Integer> sortOrdersByMonth(Map<UUID, List<Order>> sortedCustomer ){
        Map<String, Integer> sortedByMonth= new HashMap<>();
        //finds customer ID
        //goes through each order in the array of orders
        //checks the month of the order
        //caluclate the points of the order
        //if that month does not exist as a key, add the key
        //if the key exists add the value to the value stored
        return sortedByMonth;
    }
    @Override
    public  List <CustomerRewardsPointsDTO> createCustomerRewardsPointsDTO (Map<UUID, List<Order>> sortedCustomer){
        int totalPointsEarned = 0;
        int janRewardsPoints = 0;
        int februaryRewardsPoints = 0;
        int marchRewardsPoints = 0;
        List <CustomerRewardsPointsDTO> listOfCustomerDTO= new ArrayList<>();
        for (UUID key : sortedCustomer.keySet()){
            CustomerRewardsPointsDTO newDTO = new CustomerRewardsPointsDTO();
            for (Order order : sortedCustomer.get(key)) {
                if (newDTO.getFirstName()==null) {
                    Customer customer = getCustomerById(order.getCustomerId());;
                    String firstName = customer.getFirstName();
                    newDTO.setFirstName(firstName);
                }
                if (newDTO.getLastName()==null) {
                    Customer customer = getCustomerById(order.getCustomerId());
                    String lastName = customer.getLastName();
                    newDTO.setLastName(lastName);
                }
                if (newDTO.getCustomerId()==null) {
                    newDTO.setCustomerId(order.getCustomerId());
                }
                totalPointsEarned += pointsEarnedForOrder(order.getTotalAmount());
                janRewardsPoints += calculatePointsJanuary(order);
                februaryRewardsPoints += calculatePointsFebruary(order);
                marchRewardsPoints += calculatePointsMarch(order);
            }
            newDTO.setTotalPointsPerCustomer(totalPointsEarned);
            newDTO.setCustomerPointsEarnedJan(janRewardsPoints);
            newDTO.setCustomerPointsEarnedFeb(februaryRewardsPoints);
            newDTO.setCustomerPointsEarnedMar(marchRewardsPoints);
            listOfCustomerDTO.add(newDTO);
        }
        return listOfCustomerDTO;
    }
}
