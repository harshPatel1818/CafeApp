package com.example.smproject5;

public class MenuItem
{
    protected double price;
    protected int quantity;

    /**
     * Returns the price of the item.
     * @return The price of the item.
     */
    public double itemPrice() {
        return price * quantity;
    }

    //TODO: Get rid of this function if we don't use it
    public String unitPrice()
    {
        return ""+price;
    }

    /**
     * Returns the amount of this kind of coffee.
     * @return the amount of this kind of coffee.
     */
    public int getQuantity() { return quantity; }

    /**
     * Returns a string representation of the item.
     */
    @Override
    public String toString() {
        return "Menu Item";
    }
}


