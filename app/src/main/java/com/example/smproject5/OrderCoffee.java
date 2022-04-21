package com.example.smproject5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.smproject5.databinding.CoffeeLayoutBinding;
import com.example.smproject5.databinding.MainLayoutBinding;

import java.text.DecimalFormat;

public class OrderCoffee extends Fragment {
    private CoffeeLayoutBinding binding;
    private Coffee coffee;
    int amount;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = CoffeeLayoutBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        coffee = new Coffee();
        amount = 1;
        updatePrice();

        binding.creamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = ((CheckBox) view).isChecked();
                if(checked) coffee.add(Topping.CREAM);
                else coffee.remove(Topping.CREAM);
                updatePrice();
            }
        });

        binding.milkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = ((CheckBox) view).isChecked();
                if(checked) coffee.add(Topping.MILK);
                else coffee.remove(Topping.MILK);
                updatePrice();
            }
        });

        binding.caramelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = ((CheckBox) view).isChecked();
                if(checked) coffee.add(Topping.CARAMEL);
                else coffee.remove(Topping.CARAMEL);
                updatePrice();
            }
        });

        binding.syrupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = ((CheckBox) view).isChecked();
                if(checked) coffee.add(Topping.SYRUP);
                else coffee.remove(Topping.SYRUP);
                updatePrice();
            }
        });

        binding.whippedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = ((CheckBox) view).isChecked();
                if(checked) coffee.add(Topping.WHIPPED_CREAM);
                else coffee.remove(Topping.WHIPPED_CREAM);
                updatePrice();
            }
        });
    }

    private void updatePrice() {
        DecimalFormat df = new DecimalFormat("###,##0.00");
        binding.priceText.setText(df.format(coffee.itemPrice() * amount));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
