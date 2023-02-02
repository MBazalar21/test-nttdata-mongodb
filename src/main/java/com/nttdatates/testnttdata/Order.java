package com.nttdatates.testnttdata;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;

public class Order {
    @Id
    private String orderNumber;
    private String status;
    private Date date;
    private String customer;
    private double taxesAmounts;
    private double totalTaxes;
    private double totalAmount;
    private List<OrderItem> orderItems;


    public Order(String orderNumber, String status, Date date, String customer, double taxesAmounts, double totalTaxes, double totalAmount, List<OrderItem> orderItems) {
        this.orderNumber = orderNumber;
        this.status = status;
        this.date = date;
        this.customer = customer;
        this.taxesAmounts = taxesAmounts;
        this.totalTaxes = totalTaxes;
        this.totalAmount = totalAmount;
        this.orderItems = orderItems;
    }

    public String getOrderNumber() {
        return this.orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCustomer() {
        return this.customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public double getTaxesAmounts() {
        return this.taxesAmounts;
    }

    public void setTaxesAmounts(double taxesAmounts) {
        this.taxesAmounts = taxesAmounts;
    }

    public double getTotalTaxes() {
        return this.totalTaxes;
    }

    public void setTotalTaxes(double totalTaxes) {
        this.totalTaxes = totalTaxes;
    }

    public double getTotalAmount() {
        return this.totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<OrderItem> getOrderItems() {
        return this.orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}