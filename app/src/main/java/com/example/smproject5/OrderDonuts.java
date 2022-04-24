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

/**
 * Controls all the functions of the Donut ordering window.
 * @author Aaron Browne, Harshkumar Patel
 */
public class OrderDonuts extends Fragment {
    private ArrayList<Donut> donutList;
    private RecyclerView recyclerView;
    private DonutLayoutBinding binding;

    /**
     * Sets up the layout binding object.
     * @param inflater  The inflater.
     * @param container The container.
     * @param savedInstanceState The saved instance state.
     * @return The root of binding.
     */
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = DonutLayoutBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    /**
     * Sets up recycler view by loading it with donuts and sets up adapter
     * @param view The view.
     * @param savedInstanceState The saved instance state.
     */
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = binding.recyclerView;
        donutList = new ArrayList<>();
        setDonut();
        setAdapter();
    }

    /**
     * initializes the adapter and sets up the recycler view.
     * this method is used in onViewCreated().
     */
    private void setAdapter() {
        RecyclerAdapter adapter = new RecyclerAdapter(donutList, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    /**
     * this method adds different type of donuts to the arraylist, and this method is used to set up recycler view.
     */
    private void setDonut()
    {
        donutList.add(new Donut("Cake Donut","Glazed ",1));
        donutList.add(new Donut("Donut Hole","Glazed ",1));
        donutList.add(new Donut("Yeast Donut","Glazed ",1));
        donutList.add(new Donut("Yeast Donut","Boston Cream ",1));
        donutList.add(new Donut("Cake Donut","Sprinkled ",1));
        donutList.add(new Donut("Cake Donut","Boston Cream ",1));
        donutList.add(new Donut("Yeast Donut","Sprinkled ",1));
        donutList.add(new Donut("Cake Donut","Chocolate ",1));
        donutList.add(new Donut("Donut Hole","Sprinkled ",1));
        donutList.add(new Donut("Yeast Donut","Chocolate ",1));
        donutList.add(new Donut("Donut Hole","Strawberry ",1));
        donutList.add(new Donut("Donut Hole","Chocolate ",1));
    }

    /**
     * This method takes a Donut type and add that donut that will be added to the current order.
     * @param d Donut that needs to be added to the order.
     */
    public void addDonut(Donut d) {
        MainActivity main = (MainActivity) getActivity();
        main.addDonut(d);
    }
}
