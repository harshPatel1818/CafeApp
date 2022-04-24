package com.example.smproject5;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smproject5.databinding.DonutLayoutBinding;

//TODO: Write comments for this class
//TODO: We need three more donut flavors
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
        RecyclerAdapter adapter = new RecyclerAdapter(donutList, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setDonut()
    {
        donutList.add(new Donut("Cake Donut","Glazed ",1));
        donutList.add(new Donut("Donut Hole","Glazed ",1));
        donutList.add(new Donut("Yeast Donut","Glazed ",1));
        donutList.add(new Donut("Yeast Donut","Boston Cream ",1));
        donutList.add(new Donut("Donut Hole","Sprinkled ",1));
        donutList.add(new Donut("Cake Donut","Straw ",1));
        donutList.add(new Donut("Cake Donut","Choco ",1));
        donutList.add(new Donut("Cake Donut","SS ",1));
        donutList.add(new Donut("Cake Donut","ChoCcsco ",1));
    }

    public void addDonut(Donut d) {
        MainActivity main = (MainActivity) getActivity();
        main.addDonut(d);
    }
}
