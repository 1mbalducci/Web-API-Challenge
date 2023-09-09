package com.michellebalducci.WebAPIChallenge.entity;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID customerId;
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

    public UUID getCustomerID() {
        return customerId;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(lastName, customer.lastName) && Objects.equals(firstName, customer.firstName) && Objects.equals(orders, customer.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, orders);
    }
}
