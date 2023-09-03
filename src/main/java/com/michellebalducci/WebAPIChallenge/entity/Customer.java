package com.michellebalducci.WebAPIChallenge.entity;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name="customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerID;
    @Column
    private  String lastName;
    @Column
    private String firstName;
    @Column
    ArrayList<Order> orders;
    @Column
    private int totalPointsEarned;
    @Column
    private int pointsEarnedJan;
    @Column
    private int pointsEarnedFeb;
    @Column
    private int pointsEarnedMar;

    public Customer(){};

    public Customer(String lastName, String firstName, ArrayList<Order> orders) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.orders = orders;
    }

    public Customer(String lastName, String firstName, ArrayList<Order> orders,
                    int totalPointsEarned, int pointsEarnedJan, int pointsEarnedFeb,
                    int pointsEarnedMar) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.orders = orders;
        this.totalPointsEarned = totalPointsEarned;
        this.pointsEarnedJan = pointsEarnedJan;
        this.pointsEarnedFeb = pointsEarnedFeb;
        this.pointsEarnedMar = pointsEarnedMar;
    }

    public static void CalculateTotalPoints(ArrayList<Order> orders){};

    public static void CalculatePointsPerMonth(ArrayList<Order> orders){};


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getCustomerID() {
        return customerID;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public int getTotalPointsEarned() {
        return totalPointsEarned;
    }

    public void setTotalPointsEarned(int totalPointsEarned) {
        this.totalPointsEarned = totalPointsEarned;
    }

    public int getPointsEarnedJan() {
        return pointsEarnedJan;
    }

    public void setPointsEarnedJan(int pointsEarnedJan) {
        this.pointsEarnedJan = pointsEarnedJan;
    }

    public int getPointsEarnedFeb() {
        return pointsEarnedFeb;
    }

    public void setPointsEarnedFeb(int pointsEarnedFeb) {
        this.pointsEarnedFeb = pointsEarnedFeb;
    }

    public int getPointsEarnedMar() {
        return pointsEarnedMar;
    }

    public void setPointsEarnedMar(int pointsEarnedMar) {
        this.pointsEarnedMar = pointsEarnedMar;
    }
}
