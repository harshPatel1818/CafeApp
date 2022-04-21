package com.example.smproject5;

import android.content.ClipData;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smproject5.databinding.CoffeeLayoutBinding;
import com.example.smproject5.databinding.DonutLayoutBinding;

public class OrderDonuts extends Fragment {
    private ArrayList<Donut> donutList;
    private RecyclerView recyclerView;
    private DonutLayoutBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = DonutLayoutBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = binding.recyclerView;
        donutList = new ArrayList<>();
        setDonut();
        setAdapter();
    }

    private void setAdapter() {
        recyclerAdapter adapter = new recyclerAdapter(donutList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    public void setDonut()
    {
        donutList.add(new Donut("Cake Donut","Choco",1));
        donutList.add(new Donut("Cake Donut","Strw",2));
        donutList.add(new Donut("Cake Donut","Choco",3));
        donutList.add(new Donut("Cake Donut","Straw",4));
        donutList.add(new Donut("Cake Donut","Choco",5));
        donutList.add(new Donut("Cake Donut","SS",6));
        donutList.add(new Donut("Cake Donut","ChoCcsco",7));

    }
}
