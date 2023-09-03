package com.michellebalducci.WebAPIChallenge.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name= "orders_table")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int order_id;
    @Column
    private int customerId;
    @Column
    private double totalAmount;
    @Column
    private Date dateOfOrder;
    @Column
    private int PointsEarnedForOrder;

    public Order(){};

    public Order(int customerId, double totalAmount, Date dateOfOrder) {
        this.customerId = customerId;
        this.totalAmount = totalAmount;
        this.dateOfOrder = dateOfOrder;
    }

        public static void CalculatePointsPerOrder(double totalAmount){

        };


    public int getCustomerId() {
        return customerId;
    }


    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(Date dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

    public int getPointsEarnedForOrder() {
        return PointsEarnedForOrder;
    }

    public void setPointsEarnedForOrder(int pointsEarnedForOrder) {
        PointsEarnedForOrder = pointsEarnedForOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return customerId == order.customerId && Double.compare(order.totalAmount, totalAmount) == 0 && PointsEarnedForOrder == order.PointsEarnedForOrder && Objects.equals(dateOfOrder, order.dateOfOrder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, totalAmount, dateOfOrder, PointsEarnedForOrder);
    }
}
