package com.vendingmachine.interfaces;

public interface VendingOperations {
    void selectProduct(String productId);
    void dispenseProduct();
    void processPayment(double amount);
    void refund();
}