package com.michellebalducci.WebAPIChallenge.controller;

import com.sun.istack.NotNull;

import java.util.Objects;
import java.util.UUID;

public class CustomerRewardsPointsDTO {
    @NotNull
    private String lastName;
    @NotNull
    private String firstName;
    @NotNull
    private UUID customerId;
    @NotNull
    private int totalPointsPerCustomer;
    @NotNull
    private int customerPointsEarnedJan;
    @NotNull
    private int customerPointsEarnedFeb;
    @NotNull
    private int customerPointsEarnedMar;

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

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public int getTotalPointsPerCustomer() {
        return totalPointsPerCustomer;
    }

    public void setTotalPointsPerCustomer(int totalPointsPerCustomer) {
        this.totalPointsPerCustomer = totalPointsPerCustomer;
    }

    public int getCustomerPointsEarnedJan() {
        return customerPointsEarnedJan;
    }

    public void setCustomerPointsEarnedJan(int customerPointsEarnedJan) {
        this.customerPointsEarnedJan = customerPointsEarnedJan;
    }

    public int getCustomerPointsEarnedFeb() {
        return customerPointsEarnedFeb;
    }

    public void setCustomerPointsEarnedFeb(int customerPointsEarnedFeb) {
        this.customerPointsEarnedFeb = customerPointsEarnedFeb;
    }

    public int getCustomerPointsEarnedMar() {
        return customerPointsEarnedMar;
    }

    public void setCustomerPointsEarnedMar(int customerPointsEarnedMar) {
        this.customerPointsEarnedMar = customerPointsEarnedMar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerRewardsPointsDTO that = (CustomerRewardsPointsDTO) o;
        return totalPointsPerCustomer == that.totalPointsPerCustomer && customerPointsEarnedJan == that.customerPointsEarnedJan && customerPointsEarnedFeb == that.customerPointsEarnedFeb && customerPointsEarnedMar == that.customerPointsEarnedMar && Objects.equals(lastName, that.lastName) && Objects.equals(firstName, that.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, totalPointsPerCustomer, customerPointsEarnedJan, customerPointsEarnedFeb, customerPointsEarnedMar);
    }
}
