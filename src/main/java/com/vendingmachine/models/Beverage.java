package com.vendingmachine.models;

public class Beverage extends AbstractProduct {
    private double volume;
    private boolean isCarbonated;

    public Beverage(String name, double price, double volume, boolean isCarbonated) {
        super(name, price);
        this.volume = volume;
        this.isCarbonated = isCarbonated;
    }

    public double getVolume() {
        return volume;
    }

    public boolean isCarbonated() {
        return isCarbonated;
    }

    @Override
    public void displayProductInfo() {
        System.out.println("Beverage: " + getName());
        System.out.println("Price: $" + getPrice());
        System.out.println("Volume: " + volume + "ml");
        System.out.println("Carbonated: " + (isCarbonated ? "Yes" : "No"));
    }
}