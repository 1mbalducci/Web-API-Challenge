package com.michellebalducci.WebAPIChallenge.entity;

import javax.persistence.*;
import java.text.SimpleDateFormat;
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
//    @OneToMany
    ArrayList<Order> orders;


    public Customer(){};
    public Customer(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }
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

    }






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


}
