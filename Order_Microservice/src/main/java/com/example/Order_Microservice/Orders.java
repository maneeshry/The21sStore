package com.example.Order_Microservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;


    @Entity
    public class Orders {
        @Id
        private int orderId;

        private int customerId;
        private String productName;
        private double amount;
        private Date deliveryDate;
        private String deliveryAddress;
        private String status;

        public Orders() {
        }

        public Orders(String status,int orderId, int customerId, String productName, double amount, Date deliveryDate, String deliveryAddress) {
            this.orderId = orderId;
            this.customerId = customerId;
            this.productName = productName;
            this.amount = amount;
            this.deliveryDate = deliveryDate;
            this.deliveryAddress = deliveryAddress;
            this.status = status;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public int getOrderId() {
            return orderId;
        }

        public void setOrderId(int orderId) {
            this.orderId = orderId;
        }

        public int getCustomerId() {
            return customerId;
        }

        public void setCustomerId(int customerId) {
            this.customerId = customerId;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public Date getDeliveryDate() {
            return deliveryDate;
        }

        public void setDeliveryDate(Date deliveryDate) {
            this.deliveryDate = deliveryDate;
        }

        public String getDeliveryAddress() {
            return deliveryAddress;
        }

        public void setDeliveryAddress(String deliveryAddress) {
            this.deliveryAddress = deliveryAddress;
        }
    }
