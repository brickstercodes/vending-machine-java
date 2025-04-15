package com.vendingmachine.interfaces;

public interface Payment {
    /**
     * Process a payment for the given amount
     * 
     * @param amount The amount to be paid
     * @return true if payment is successful, false otherwise
     */
    boolean pay(double amount);
}