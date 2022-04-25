package com.example.smproject5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;


//TODO: Assign a icon for the app

/**
 * Controls all the functions of the Store order window.
 * @author Harshkumar Patel, Aaron Browne
 */
public class ViewStoreOrders extends AppCompatActivity {
    RecyclerView list;
    StoreOrders orders;

    /**
     * Sets up the layout given the parameter.
     * @param savedInstanceState The saved instance state.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_store_orders);
        list = findViewById(R.id.ordersView);
        Intent intent = getIntent();
        orders = (StoreOrders) intent.getSerializableExtra("orders");
        setAdapter();
    }

    /**
     * Initializes the adapter.
     */
    private void setAdapter() {
        StoreOrdersRecyclerAdapter adapter = new StoreOrdersRecyclerAdapter(orders.getList(), this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        list.setLayoutManager(layoutManager);
        list.setItemAnimator(new DefaultItemAnimator());
        list.setAdapter(adapter);
    }

    /**
     * This method removes the order from the list given the index number.
     * @param i index number of the order that needs to be removed.
     */
    public void removeOrder(int i) {
        orders.remove(i);
        setAdapter();
    }
}