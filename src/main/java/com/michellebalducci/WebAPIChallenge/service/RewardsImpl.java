package com.michellebalducci.WebAPIChallenge.service;

import com.michellebalducci.WebAPIChallenge.entity.Order;

import java.util.ArrayList;

public class RewardsImpl implements RewardsService{

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
