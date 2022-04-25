package com.example.smproject5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

//TODO: Write comments for this class
//TODO: Assign a icon for the app
//TODO: make sure there are no hardcode text errors in xml files
//TODO: make sure spinner is used
public class ViewStoreOrders extends AppCompatActivity {
    RecyclerView list;
    StoreOrders orders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_store_orders);
        list = findViewById(R.id.ordersView);
        Intent intent = getIntent();
        orders = (StoreOrders) intent.getSerializableExtra("orders");
        setAdapter();
    }

    private void setAdapter() {
        StoreOrdersRecyclerAdapter adapter = new StoreOrdersRecyclerAdapter(orders.getList(), this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        list.setLayoutManager(layoutManager);
        list.setItemAnimator(new DefaultItemAnimator());
        list.setAdapter(adapter);
    }
}