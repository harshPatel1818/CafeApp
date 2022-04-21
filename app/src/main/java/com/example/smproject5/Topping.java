package com.example.smproject5;

/**
 * Contains information about the coffee toppings.
 * @author Aaron Browne
 */
public enum Topping {
	CREAM("Cream"), SYRUP("Syrup"), MILK("Milk"), CARAMEL("Caramel"), WHIPPED_CREAM("Whipped Cream");

	String string;

	/**
	 * Initalizes the topping.
	 * @param string The string that is returned in the toString function.
	 */
	private Topping(String string) {
		this.string = string;
	}

	/**
	 * Returns the name of the topping.
	 */
	@Override
	public String toString() {
		return string;
	}
}
