package com.example.smproject5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.smproject5.databinding.CoffeeLayoutBinding;
import com.example.smproject5.databinding.MainLayoutBinding;

import java.text.DecimalFormat;

/**
 * Controls all the functions of the Coffee ordering window.
 * @author Aaron Browne, Harshkumar Patel
 */
public class OrderCoffee extends Fragment {
    //TODO: Be able to change the size of coffees
    //TODO: Be able to change the amount of coffees
    private CoffeeLayoutBinding binding;
    private Coffee coffee;
    int amount;

    /**
     * Sets up the layout binding object.
     * @param inflater The inflater.
     * @param container The container.
     * @param savedInstanceState The saved instance state.
     * @return The root of binding.
     */
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = CoffeeLayoutBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    /**
     * Initializes the values and sets up the listeners.
     * @param view The view.
     * @param savedInstanceState The saved instance state.
     */
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        coffee = new Coffee();
        amount = 1;
        updatePrice();

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.coffee_sizes, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.sizeBox.setAdapter(adapter);

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

        binding.submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity mm = (MainActivity) getActivity();
                mm.addCoffee(coffee, amount);
                Toast.makeText(getContext(), "@string/add_success", Toast.LENGTH_LONG).show();
            }
        });
    }

    /**
     * Updates the price in the price text box.
     */
    private void updatePrice() {
        DecimalFormat df = new DecimalFormat("###,##0.00");
        binding.priceText.setText(df.format(coffee.itemPrice() * amount));
    }

    /**
     * Cleans up the data after the fragment has been exited.
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
