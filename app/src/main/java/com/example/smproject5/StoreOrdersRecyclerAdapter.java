package com.example.smproject5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StoreOrdersRecyclerAdapter extends RecyclerView.Adapter<StoreOrdersRecyclerAdapter.OrderHolder> {
    private ArrayList<Order> orderList;
    private ViewStoreOrders vso;

    public StoreOrdersRecyclerAdapter(ArrayList<Order> list, ViewStoreOrders main) {
        orderList = list;
        vso = main;
    }

    @NonNull
    @Override
    public StoreOrdersRecyclerAdapter.OrderHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View ordersView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items,
                parent,false);
        return new OrderHolder(ordersView);
    }

    @Override
    public void onBindViewHolder(@NonNull StoreOrdersRecyclerAdapter.OrderHolder holder, int position) {
        String orderString = orderList.get(position).toString();
        holder.string.setText(orderString);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class OrderHolder extends RecyclerView.ViewHolder {
        private TextView string;
        private Button button;

        public OrderHolder(@NonNull View itemView) {
            super(itemView);

            string = itemView.findViewById(R.id.name);
            button = itemView.findViewById(R.id.addButton);
        }
    }
}
