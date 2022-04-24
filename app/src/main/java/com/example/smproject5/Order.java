package com.example.smproject5;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Contains information about a single Order.
 * Stores the list of items and the price.
 * @author Aaron Browne, Harshkumar Patel
 */
public class Order implements Customizable, Serializable {
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
		updatePrice();
		return true;
	}

	/**
	 * Removes an item from the order.
	 */
	public boolean remove(Object obj) {
		String toBeRemoved = (String) obj;
		for(MenuItem item : items) {
			if(item.toString().equals(toBeRemoved)) {
				items.remove(item);
				break;
			}
		}
		updatePrice();
		return false;
	}

	/**
	 * Updates the price of the order.
	 */
	public void updatePrice() {
		price = 0;
		for(MenuItem i : items) {
			price += i.itemPrice();
		}
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

	/**
	 * Returns a string representation of the Order.
	 * @param number The order number.
	 * @return A string representation of the Order.
	 */
	public String toString(int number) {
		DecimalFormat df = new DecimalFormat("###,##0.00");
		String result = "Order #" + number + ":\n";
		for(MenuItem i : items) {
			result += i.toString() + " $" + df.format(i.itemPrice()) + "\n";
		}
		result += "Subtotal: $" + df.format(price) + "\n";
		result += "Tax: $" + df.format(tax) + "\n";
		result += "Total: $" + df.format(total) + "\n";
		return result;
	}
}
