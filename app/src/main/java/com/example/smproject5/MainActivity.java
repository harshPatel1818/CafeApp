package com.example.smproject5;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.smproject5.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

/**
 * Controls the functions of the main activity.
 * This includes the main screen, the screens to order Donut and Coffee, and the current order screen.
 * @author Aaron Browne, Harshkumar Patel
 */
public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    private Order order;
    public StoreOrders storeOrders;

    /**
     * Sets up the activity when it is created.
     * @param savedInstanceState The saved instance state.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this,
                R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        order = new Order();
        storeOrders = new StoreOrders();
    }

    /**
     * Inflates the menu inflater and returns true.
     * @param menu The menu to inflate.
     * @return true
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * Handles when an options item is selected.
     * @param item A menu item.
     * @return Whether or not it was a success.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Supports the program when a user navigates up.
     * @return Whether or not it was a success.
     */
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this,
                R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    /**
     * Adds a coffee to the current order.
     * @param coffee The coffee to add.
     */
    public void addCoffee(Coffee coffee) {
        boolean added = false;
        for(com.example.smproject5.MenuItem i : order.getList()) {
            try {
                Coffee c = (Coffee) i;
                if(coffee.equals(c)) {
                    c.addCoffee(coffee);
                    order.updatePrice();
                    added = true;
                }
            } catch(Exception e) {}
        }
        if(!added) order.add(coffee);
    }

    /**
     * Add a donut to the current order.
     * @param donut The donut to add.
     */
    public void addDonut(Donut donut) {
        boolean added = false;
        for(com.example.smproject5.MenuItem i : order.getList()) {
            try {
                Donut d = (Donut) i;
                if(donut.equals(d)) {
                    d.addDonuts(donut);
                    order.updatePrice();
                    added = true;
                }
            } catch(Exception e) {}
        }
        if(!added) order.add(donut);
    }

    /**
     * Returns the list of orders as a list of strings.
     * @return The list of strings.
     */
    public ArrayList<String> getList() {
        ArrayList<com.example.smproject5.MenuItem> itemList = order.getList();
        ArrayList<String> realList = new ArrayList<>();
        for(com.example.smproject5.MenuItem item : itemList) {
            realList.add(item.toString());
        }
        return realList;
    }

    /**
     * Returns the order object.
     * @return The order object.
     */
    public Order getOrder() {
        return order;
    }

    /**
     * Adds the current to the list of store order when the user presses the place order button.
     */
    public void placeOrder() {
        storeOrders.add(order);
        order = new Order();
    }
}
