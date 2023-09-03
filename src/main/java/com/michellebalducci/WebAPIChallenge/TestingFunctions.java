package com.michellebalducci.WebAPIChallenge;

import com.michellebalducci.WebAPIChallenge.entity.Customer;
import com.michellebalducci.WebAPIChallenge.entity.Order;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import static com.michellebalducci.WebAPIChallenge.entity.Customer.CalculatePointsPerMonth;
import static com.michellebalducci.WebAPIChallenge.entity.Order.CalculatePointsPerOrder;

public class TestingFunctions {
    public static void main (String[] args){


        Customer c1= new Customer("Bobby", "Sally");

        Order order1= new Order(c1.getCustomerID(), 500.00, "01-02-2022");
        Order order2= new Order(c1.getCustomerID(), 55.00, "01-03-2022");
        ArrayList<Order> arrOrders =new ArrayList<>();

        char[] chars= order1.getDateOfOrder().toCharArray();
        System.out.println(chars[1]);
        CalculatePointsPerOrder(order1.getTotalAmount());
        System.out.println(order1.getPointsEarnedForOrder());

        CalculatePointsPerOrder(order2.getTotalAmount());
        System.out.println(order2.getPointsEarnedForOrder());

        arrOrders.add(order1);
        arrOrders.add(order2);

        c1.setOrders(arrOrders);
        CalculatePointsPerMonth(c1.getOrders());
        System.out.println(c1.getPointsEarnedJan());
    }
}
