package com.example.smproject5;

/**
 * Parent class for all menu items.
 * Contains the price variable.
 * @author Aaron Browne
 */
public class MenuItem {
	protected double price;

	/**
	 * Returns the price of the item.
	 * @return The price of the item.
	 */
	public double itemPrice() {
		return price;
	}

	/**
	 * Returns a string representation of the item.
	 */
	@Override
	public String toString() {
		return "Menu Item";
	}
}
