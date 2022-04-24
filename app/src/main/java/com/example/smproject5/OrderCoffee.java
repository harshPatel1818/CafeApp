package com.example.smproject5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.smproject5.databinding.CoffeeLayoutBinding;
import com.example.smproject5.databinding.MainLayoutBinding;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

//TODO: We need to break up that onViewCreated function. We'll get points off if it's more than 40 lines long.
/**
 * Controls all the functions of the Coffee ordering window.
 * @author Aaron Browne, Harshkumar Patel
 */
public class OrderCoffee extends Fragment {
    private CoffeeLayoutBinding binding;
    private Coffee coffee;

    private final int SHORT  = 1;
    private final int TALL   = 2;
    private final int GRANDE = 3;
    private final int VENTI  = 4;

    /**
     * Sets up the layout binding object.
     * @param inflater The inflater.
     * @param container The container.
     * @param savedInstanceState The saved instance state.
     * @return The root of binding.
     */
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
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
        updatePrice();

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.coffee_sizes, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.sizeBox.setAdapter(adapter);

        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        ArrayAdapter<Integer> ad = new ArrayAdapter(getContext(),
                android.R.layout.simple_spinner_item, numbers);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.quantityBox.setAdapter(ad);

        binding.creamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boxChecked(Topping.CREAM, ((CheckBox) view).isChecked());
            }
        });

        binding.milkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boxChecked(Topping.MILK, ((CheckBox) view).isChecked());
            }
        });

        binding.caramelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boxChecked(Topping.CARAMEL, ((CheckBox) view).isChecked());
            }
        });

        binding.syrupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boxChecked(Topping.SYRUP, ((CheckBox) view).isChecked());
            }
        });

        binding.whippedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boxChecked(Topping.WHIPPED_CREAM, ((CheckBox) view).isChecked());
            }
        });

        binding.submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity mm = (MainActivity) getActivity();
                mm.addCoffee(coffee);
                Toast.makeText(getContext(), R.string.add_success,
                        Toast.LENGTH_LONG).show();
            }
        });

        binding.sizeBox.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {
                sizeChange((String) parent.getItemAtPosition(pos));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        binding.quantityBox.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {
                quantityChanged((int) parent.getItemAtPosition(pos));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    /**
     * Adds or removes a topping from the coffee when a checkbox is checked or unchecked.
     * @param t The topping to add/remove.
     * @param checked Whether the box is checked or not.
     */
    private void boxChecked(Topping t, boolean checked) {
        if(checked) coffee.add(t);
        else coffee.remove(t);
        updatePrice();
    }

    /**
     * Updates the quantity variable when the user changes the quantity in the GUI.
     */
    public void quantityChanged(int newQuantity) {
        coffee.setQuantity(newQuantity);
        updatePrice();
    }

    /**
     * Updates the current coffee object when the size of the coffee is changed.
     */
    private void sizeChange(@NonNull String newSize) {
        int newSizeNumber = 0;
        switch(newSize) {
            case "Short":
                newSizeNumber = SHORT;
                break;
            case "Tall":
                newSizeNumber = TALL;
                break;
            case "Grande":
                newSizeNumber = GRANDE;
                break;
            case "Venti":
                newSizeNumber = VENTI;
        }

        coffee.changeSize(newSizeNumber);
        updatePrice();
    }

    /**
     * Updates the price in the price text box.
     */
    private void updatePrice() {
        DecimalFormat df = new DecimalFormat("###,##0.00");
        binding.priceText.setText(df.format(coffee.itemPrice()));
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
