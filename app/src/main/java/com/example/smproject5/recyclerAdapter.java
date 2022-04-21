package com.example.smproject5;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.MyViewHolder>{
    private ArrayList<Donut> donutList;

    public recyclerAdapter(ArrayList<Donut> x)
    {
        this.donutList = x;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        private TextView donutName;

        public MyViewHolder(final View view)
        {
            super(view);
            donutName = view.findViewById(R.id.textView2);

        }
    }

    @NonNull
    @Override
    public recyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View donutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items,parent,false);
        return new MyViewHolder(donutView);
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerAdapter.MyViewHolder holder, int position) {
        String n = donutList.get(position).toString();
        holder.donutName.setText(n);
    }

    @Override
    public int getItemCount() {
        return donutList.size();
    }
}
