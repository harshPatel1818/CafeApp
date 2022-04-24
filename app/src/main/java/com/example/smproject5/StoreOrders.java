package com.example.smproject5;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Stores all the orders previously made.
 * @author Aaron Browne, Harshkumar Patel
 */
public class StoreOrders implements Customizable, Serializable {
	private ArrayList<Order> orders;

	/**
	 * Sets up the database.
	 */
	public StoreOrders() {
		orders = new ArrayList<Order>();
	}

	/**
	 * Adds an order to the database.
	 */
	public boolean add(Object order) {
		Order ord = (Order) order;
		orders.add(ord);
		return true;
	}

	/**
	 * Removes an order from the database.
	 */
	public boolean remove(Object order) {
		Order ord = (Order) order;
		orders.remove(ord);
		return false;
	}

	/**
	 * Returns the list of orders.
	 * @return The list of orders.
	 */
	public ArrayList<Order> getList() {
		return orders;
	}
}
