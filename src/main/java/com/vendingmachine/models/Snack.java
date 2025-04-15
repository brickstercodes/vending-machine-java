package com.vendingmachine.models;

public class Snack extends AbstractProduct {
    private String type;
    private int calories;

    public Snack(String name, double price, String type, int calories) {
        super(name, price);
        this.type = type;
        this.calories = calories;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    @Override
    public String toString() {
        return "Snack{" +
                "name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", type='" + type + '\'' +
                ", calories=" + calories +
                '}';
    }

    @Override
    public void displayProductInfo() {
        System.out.println("Snack: " + getName());
        System.out.println("Price: $" + getPrice());
        System.out.println("Type: " + type);
        System.out.println("Calories: " + calories);
    }
}