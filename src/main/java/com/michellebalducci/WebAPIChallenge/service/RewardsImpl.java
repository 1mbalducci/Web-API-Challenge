package com.michellebalducci.WebAPIChallenge.service;

import com.michellebalducci.WebAPIChallenge.entity.Customer;
import com.michellebalducci.WebAPIChallenge.entity.Order;
import com.michellebalducci.WebAPIChallenge.repository.CustomerRepository;
import com.michellebalducci.WebAPIChallenge.repository.OrderRepository;
import com.sun.istack.NotNull;
import org.aspectj.weaver.ast.Or;

import java.util.*;

public class RewardsImpl implements RewardsService {
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
    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

//    @Override
//    public List<Customer> findByName(@NotNull String firstName, @NotNull String lastName) {
//        String customerFirstName= firstName;
//        String customerLastName= lastName;
//        return customerRepository.findBy(customerFirstName, customerLastName);


    public static Map<UUID,List<Order>> sortOrdersByCustomerId (List <Order> orders){
        Map<UUID, List<Order>> sortedlistCustomers = new HashMap<>();
        for (Order order : orders) {
            if (!sortedlistCustomers.containsKey(order.getCustomerId())) {
                sortedlistCustomers.put(order.getCustomerId(), new ArrayList<>());
            }
            sortedlistCustomers.get(order.getCustomerId()).add(order);
        }
        return sortedlistCustomers;
    };

    public static int pointsEarnedForOrder(double totalAmount) {
        int pointsEarnedForOrder = 0;
        if (totalAmount > 100) {
            pointsEarnedForOrder += ((totalAmount - 100) * 2) + 50;
        }
        if (totalAmount > 50 && totalAmount <= 100) {
            pointsEarnedForOrder += (totalAmount - 50) * 1;
        }
        return pointsEarnedForOrder;
    }



    public static int calculateTotalPointsPerCustomer(List<Order> orders) {
        int totalPointsEarned = 0;
        for (Order order : orders) {
//            if (order.getCustomerId() == customer.getCustomerID()) {
                totalPointsEarned += pointsEarnedForOrder(order.getTotalAmount());
//            }

        }
        return totalPointsEarned;
    }

    public static int calculatePointsJanuary(List<Order> orders) {
        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();
        startDate.set(2022, Calendar.JANUARY, 1);
        endDate.set(2022, Calendar.FEBRUARY, 1);
        int customerPointsEarnedJan = 0;
        for (Order order : orders) {
            if (order.getDateOfOrder().before(endDate) && order.getDateOfOrder().after(startDate)
                    || order.getDateOfOrder().equals(startDate)) {
                customerPointsEarnedJan += pointsEarnedForOrder(order.getTotalAmount());
            }

        }
        return customerPointsEarnedJan;

    }

    ;

    public static int calculatePointsFebruary(List<Order> orders) {
        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();
        startDate.set(2022, Calendar.FEBRUARY, 1);
        endDate.set(2022, Calendar.MARCH, 1);
        int customerPointsEarnedFeb = 0;
        for (Order order : orders) {
            if (order.getDateOfOrder().before(endDate) && order.getDateOfOrder().after(startDate)
                    || order.getDateOfOrder().equals(startDate)) {
                customerPointsEarnedFeb += pointsEarnedForOrder(order.getTotalAmount());
            }
        }
        return customerPointsEarnedFeb;
    };

    public static int calculatePointsMarch(List<Order> orders) {
        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();
        startDate.set(2022, Calendar.MARCH, 1);
        endDate.set(2022, Calendar.FEBRUARY, 1);
        int customerPointsEarnedFeb = 0;
        for (Order order : orders) {
            if (order.getDateOfOrder().before(endDate) && order.getDateOfOrder().after(startDate)
                    || order.getDateOfOrder().equals(startDate)) {
                customerPointsEarnedFeb += pointsEarnedForOrder(order.getTotalAmount());
            }

        }
        return customerPointsEarnedFeb;


    }
}
