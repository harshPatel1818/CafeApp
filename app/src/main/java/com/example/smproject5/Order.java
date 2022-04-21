package com.example.smproject5;

import java.util.ArrayList;

/**
 * Contains information about a single Order.
 * Stores the list of items and the price.
 * @author Aaron Browne, Harshkumar Patel
 */
public class Order implements Customizable{
	private double TAX_RATE = 0.06625;
	private ArrayList<MenuItem> items;

	private double price;
	private double tax;
	private double total;

	/**
	 * Initializes the order.
	 */
	public Order() {
		price = 0;
		items = new ArrayList<MenuItem>();
	}

	/**
	 * Adds an item to the order.
	 */
	public boolean add(Object obj) {
		MenuItem mi = (MenuItem) obj;
		items.add(mi);
		changePrice(mi.itemPrice());
		return true;
	}

	/**
	 * Removes an item from the order.
	 */
	public boolean remove(Object obj) {
		String toBeRemoved = (String) obj;
		for(MenuItem item : items) {
			if(item.toString().equals(toBeRemoved)) {
				changePrice(item.itemPrice() * -1);
				items.remove(item);
				break;
			}
		}
		return false;
	}

	/**
	 * Adds an amount of money to the sub-total and updates the tax and total.
	 * @param amount The amount to add (negative number to remove)
	 */
	public void changePrice(double amount) {
		price += amount;
		tax = price * TAX_RATE;
		total = price + tax;
	}

	/**
	 * Returns the list of items in the order as an ArrayList.
	 * @return The list of items in the order.
	 */
	public ArrayList<MenuItem> getList() {
		return items;
	}

	/**
	 * Returns the price of the order.
	 * @return The price of the order.
	 */
	public double orderPrice() {
		return price;
	}

	/**
	 * Returns the tax amount.
	 * @return The tax amount.
	 */
	public double getTax() {
		return tax;
	}

	/**
	 * Returns the total cost.
	 * @return The total cost.
	 */
	public double getTotal() {
		return total;
	}
}
