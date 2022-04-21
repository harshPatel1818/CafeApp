package com.example.smproject5;

/**
 * Requires children to have an add and remove function.
 * @author Aaron Browne
 */
public interface Customizable {
	/**
	 * Adds an object to something.
	 * @param obj The object to add.
	 * @return True if the add was successful, false if not.
	 */
	boolean    add(Object obj);

	/**
	 * Removes an object from something.
	 * @param obj The object to remove.
	 * @return True if the remove was successful, false if not.
	 */
	boolean remove(Object obj);
}
