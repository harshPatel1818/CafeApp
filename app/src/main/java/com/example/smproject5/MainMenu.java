package com.example.smproject5;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.smproject5.databinding.MainLayoutBinding;

/**
 * Controls all the functions of the Coffee ordering window.
 * @author Aaron Browne, Harshkumar Patel
 */
public class MainMenu extends Fragment {

    private MainLayoutBinding binding;

    /**
     * Sets up the binding.
     * @param inflater The inflater.
     * @param container The container.
     * @param savedInstanceState The saved instance state.
     * @return The binding root.
     */
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = MainLayoutBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    /**
     * Sets up the listeners for the buttons.
     * @param view The view.
     * @param savedInstanceState The saved instance state.
     */
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.basketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(MainMenu.this)
                        .navigate(R.id.action_to_basket);
            }
        });

        binding.donutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(MainMenu.this)
                        .navigate(R.id.action_to_donut);
            }
        });

        binding.coffeeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(MainMenu.this)
                        .navigate(R.id.action_to_coffee);
            }
        });

        binding.ordersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ViewStoreOrders.class);
                intent.putExtra("orders", ((MainActivity) getActivity()).storeOrders);
                startActivity(intent);
            }
        });
    }

    /**
     * Cleans up the binding after the window is cold.
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}