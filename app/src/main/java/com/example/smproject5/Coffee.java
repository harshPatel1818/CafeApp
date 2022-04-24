package com.example.smproject5;

import java.util.HashSet;
import java.util.Set;

//TODO: Fix weird price error
/**
 * Contains information about a single coffee.
 * stores the size and toppings of the coffee.
 * @author Aaron Browne
 */
public class Coffee extends MenuItem implements Customizable {
	private final int SHORT  = 1;
	private final int TALL   = 2;
	private final int GRANDE = 3;
	private final int VENTI  = 4;

	private final double DEFAULT_COST = 1.69;
	private final double INCREASE_PER_SIZE = 0.4;
	private final double INCREASE_PER_ADDON = 0.3;

	private Set<Topping> addons;
	private int size;

	/**
	 * Sets up the list of toppings and initializes the size and price.
	 */
	public Coffee() {
		this.size = SHORT;
		this.price = DEFAULT_COST;
		this.addons = new HashSet<Topping>();
		this.quantity = 1;
	}

	/**
	 * Adds a topping to the coffee.
	 */
	public boolean add(Object obj) {
		Topping t = (Topping) obj;
		addons.add(t);
		updatePrice();
		return true;
	}

	/**
	 * Removes a topping from the coffee.
	 */
	public boolean remove(Object obj) {
		Topping t = (Topping) obj;
		addons.remove(t);
		updatePrice();
		return true;
	}

	/**
	 * Adds another coffee's quantity to the current one if they have the same size and addons.
	 * @param c The other coffee.
	 */
	public void addCoffee(Coffee c) {
		if(equals(c)) quantity += c.getQuantity();
		updatePrice();
	}

	/**
	 * Changes the size of the coffee.
	 * @param newSize The new size of the coffee.
	 */
	public void changeSize(int newSize) {
		if(newSize < SHORT || newSize > VENTI) return;
		size = newSize;
		updatePrice();
	}

	/**
	 * Updates the price of the coffee based on it's size and toppings.
	 */
	private void updatePrice() {
		double newPrice = DEFAULT_COST;
		newPrice += (size - SHORT) * INCREASE_PER_SIZE;
		newPrice += addons.size() * INCREASE_PER_ADDON;
		price = newPrice * quantity;
	}

	/**
	 * Returns the size of the coffee.
	 * @return The size of the coffee.
	 */
	public int getSize() { return size; }

	/**
	 * Sets the amount of coffees when the user picks a different option from the drop down menu.
	 * @param newQuantity The new amount of coffees.
	 */
	public void setQuantity(int newQuantity) {
		quantity = newQuantity;
	}

	/**
	 * Returns the addons of the coffee as a set.
	 * @return The addons of the coffee.
	 */
	public Set<Topping> getAddons() { return addons; }

	/**
	 * Determines if two coffee objects are equal,
	 * that is if they are the same size and if they have the same toppings
	 * @param c The coffe to compare against.
	 * @return True if the coffees are equal, false otherwise.
	 */
	public boolean equals(Coffee c) {
		return size == c.getSize() && addons.equals(c.getAddons());
	}

	/**
	 * Returns a string representation of the coffee.
	 */
	@Override
	public String toString() {
		String result = "";
		switch(size) {
		case SHORT:
			result += "Short ";
			break;
		case TALL:
			result += "Tall ";
			break;
		case GRANDE:
			result += "Grande ";
			break;
		case VENTI:
			result += "Venti ";
			break;
		}

		result += "Coffee, [";
		for(Topping i : addons) {
			result += i + ", ";
		}

		if(addons.isEmpty()) result += "black";

		result += "] (" + quantity + ")";
		return result;
	}
}
