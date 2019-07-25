package com.oocl.packagebooking.modle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class PackageOrder {
    @Id
    @GeneratedValue
    private Long id;
    private String orderNumber;
    private String userName;
    private String phoneNumber;
    private Date orderTime;
    private Double weight;

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getWeight() {
        return weight;
    }

    public PackageOrder() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Long getId() {
        return id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public String getUserName() {
        return userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public PackageOrder(String orderNumber, String userName, String phoneNumber, Date orderTime, Double weight) {
        this.orderNumber = orderNumber;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.orderTime = orderTime;
        this.weight = weight;
    }
}
