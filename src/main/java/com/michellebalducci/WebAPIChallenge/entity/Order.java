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
    private static int pointsEarnedForOrder;

    public Order(){};

    public Order(int customerId, double totalAmount, Date dateOfOrder) {
        this.customerId = customerId;
        this.totalAmount = totalAmount;
        this.dateOfOrder = dateOfOrder;
    }

        public static void CalculatePointsPerOrder(double totalAmount){
                if (totalAmount>100){
                    pointsEarnedForOrder+= ((totalAmount-100)*2)+50;
                }
                if (totalAmount>50 && totalAmount<=100){
                    pointsEarnedForOrder+= (totalAmount-50)*1;
                }
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
        return pointsEarnedForOrder;
    }

    public void setPointsEarnedForOrder(int pointsEarnedForOrder) {
        pointsEarnedForOrder = pointsEarnedForOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return customerId == order.customerId && Double.compare(order.totalAmount, totalAmount) == 0 && pointsEarnedForOrder == order.pointsEarnedForOrder && Objects.equals(dateOfOrder, order.dateOfOrder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, totalAmount, dateOfOrder, pointsEarnedForOrder);
    }
}