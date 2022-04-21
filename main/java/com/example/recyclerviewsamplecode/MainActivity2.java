package com.example.recyclerviewsamplecode;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

/**
 * This is an example of an Activity where a RecyclerView is used.
 * @author Lily Chang
 */
public class MainActivity extends AppCompatActivity {
    //Declare an instance of ArrayList to hold the items to be display with the RecyclerView
    private ArrayList<Item> items = new ArrayList<>();
    /* All the images associated with the menu items are stored in the res/drawable folder
     *  Each image are accessed with the resourse ID, which is an integer.
     *  We need an array of integers to hold the resource IDs. Make sure the index of a given
     *  ID is consistent with the index of the associated menu item in the ArrayList.
     *  An image resource could also be an URI.
     */
    private int [] itemImages = {R.drawable.apple, R.drawable.banana, R.drawable.grapes,
            R.drawable.mango, R.drawable.orange, R.drawable.peach, R.drawable.pineapple,
            R.drawable.strawberry};

    /**
     * Get the references of all instances of Views defined in the layout file, set up the list of
     * items to be display in the RecyclerView.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rcview = findViewById(R.id.rcView_menu);
        setupMenuItems(); //add the list of items to the ArrayList
        ItemsAdapter adapter = new ItemsAdapter(this, items); //create the adapter
        rcview.setAdapter(adapter); //bind the list of items to the RecyclerView
        //use the LinearLayout for the RecyclerView
        rcview.setLayoutManager(new LinearLayoutManager(this));
    }

    /**
     * Helper method to set up the data (the Model of the MVC).
     */
    private void setupMenuItems() {
        /*
         * Item names are defined in a String array under res/string.xml.
         * Your item names might come from other places, such as an external file, or the database
         * from the backend.
         */
        String [] itemNames = getResources().getStringArray(R.array.itemNames);
        /* Add the items to the ArrayList.
         * Note that I use hardcoded prices for demo purpose. This should be replace by other
         * data sources.
         */
        for (int i = 0; i < itemNames.length; i++) {
            items.add(new Item(itemNames[i], itemImages[i], "$1.39"));
        }
    }
}