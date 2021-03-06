package com.example.smproject5;

/**
 * Contains information about a single donut.
 * @author Harshkumar Patel
 */
public class Donut extends MenuItem
{
    private final double YEAST_DONUT_PRICE = 1.59;
    private final double CAKE_DONUT_PRICE = 1.79;
    private final double DONUT_HOLE_PRICE = 0.39;

    private String type;
    private String flavor;
    private int image;

    /**
     * Creates a donut with the values given.
     * @param t Donut Type
     * @param f The flavor
     * @param q The quantity
     */
    public Donut(String t, String f, int q) {
        this.type = t;
        this.quantity = q;
        this.flavor = f;
        if(type.equals("Yeast Donut")) {
            price = YEAST_DONUT_PRICE;
        } else if(type.equals("Cake Donut")) {
            price = CAKE_DONUT_PRICE;
        } else {
            price = DONUT_HOLE_PRICE;
        }
    }

    /**
     * Creates a donut with the values given and an image int.
     * @param t Donut Type
     * @param f The flavor
     * @param q The quantity
     * @param m The image
     */
    public Donut(String t, String f, int q, int m) {
        this.type = t;
        this.quantity = q;
        this.flavor = f;
        this.image = m;
        if(type.equals("Yeast Donut")) {
            price = YEAST_DONUT_PRICE;
        } else if(type.equals("Cake Donut")) {
            price = CAKE_DONUT_PRICE;
        } else {
            price = DONUT_HOLE_PRICE;
        }
    }

    /**
     * Adds another donut's quantity to the current one if they have the same type and flavor.
     * @param d The other donut.
     */
    public void addDonuts(Donut d) {
        if(equals(d)) {
            quantity += d.getQuantity();
        }
        if(type.equals("Yeast Donut")) {
            price = YEAST_DONUT_PRICE;
        } else if(type.equals("Cake Donut")) {
            price = CAKE_DONUT_PRICE;
        } else {
            price = DONUT_HOLE_PRICE;
        }
    }

    /**
     * Returns the type of donut.
     * @return The type of donut.
     */
    public String getType() {
        return type;
    }

    /**
     * Returns the flavor of the donut.
     * @return The flavor of the donut.
     */
    public String getFlavor() {
        return flavor;
    }

    /**
     * Returns a string representation of the donut(s).
     */
    @Override
    public String toString() {
        String output = this.flavor + " " + this.type + " (" + this.quantity + ")";
        return output;
    }

    /**
     * Returns the image int.
     * @return The image int.
     */
    public int getImage()
    {
        return this.image;
    }

    /**
     * Determines if two donuts have the same type and flavor.
     * @param d The donut to compare against.
     * @return True if the donuts are equal and false otherwise.
     */
    public boolean equals(Donut d) {
        return this.type.equals(d.getType()) && this.flavor.equals(d.getFlavor());
    }
}
