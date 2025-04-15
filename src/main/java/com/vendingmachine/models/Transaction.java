package com.vendingmachine.models;

import com.vendingmachine.interfaces.Payment;
import com.vendingmachine.exceptions.InsufficientFundsException;

public class Transaction {
    private String productId;
    private int quantity;
    private double totalAmount;
    private boolean paymentStatus;

    public Transaction(String productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
        this.totalAmount = 0.0;
        this.paymentStatus = false;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public boolean isPaymentStatus() {
        return paymentStatus;
    }

    public void calculateTotalAmount(double pricePerUnit) {
        this.totalAmount = pricePerUnit * quantity;
    }

    public void processPayment(Payment paymentMethod) throws InsufficientFundsException {
        if (paymentMethod.pay(totalAmount)) {
            paymentStatus = true;
        } else {
            throw new InsufficientFundsException("Insufficient funds for the transaction.");
        }
    }
}