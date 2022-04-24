package com.example.smproject5;

import java.io.Serializable;

/**
 * Parent class for all menu items.
 * Contains the price variable.
 * @author Aaron Browne
 */
public class MenuItem implements Serializable {
    protected double price;
    protected int quantity;

    /**
     * Returns the price of the item.
     * @return The price of the item.
     */
    public double itemPrice() {
        return price * quantity;
    }

    /**
     * Returns the amount of this kind of coffee.
     * @return the amount of this kind of coffee.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Returns a string representation of the item.
     */
    @Override
    public String toString() {
        return "Menu Item";
    }
}


