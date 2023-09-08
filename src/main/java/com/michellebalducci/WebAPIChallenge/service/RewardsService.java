package com.michellebalducci.WebAPIChallenge.service;

import com.michellebalducci.WebAPIChallenge.entity.Order;

import java.util.ArrayList;

public interface RewardsService {

    public static void calculateTotalPoints(ArrayList<Order> orders){
        int totalPointsEarned=0;
        for (Order order: orders) {
            totalPointsEarned+= order.getPointsEarnedForOrder();
        }
    };

    public static void calculatePointsPerMonth(ArrayList<Order> orders) {

    };

}
