package com.example.smproject5;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.smproject5.databinding.BasketLayoutBinding;

import java.text.DecimalFormat;

//TODO: Write comments for this class
//TODO: Be able to delete an item from the order

public class Basket extends Fragment {

    private BasketLayoutBinding binding;
    MainActivity ma;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = BasketLayoutBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        populateList();

        binding.placeOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ma.getList().isEmpty()){
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
                    alertDialogBuilder.setCancelable(true);
                    alertDialogBuilder.setTitle("Error!");
                    alertDialogBuilder.setMessage("Cannot place an empty order");

                    alertDialogBuilder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });

                    alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
                    alertDialogBuilder.show();

                }else {
                    placeOrder();
                }
            }
        });
      /*
       binding.orderList.setOnLongClickListener(new AdapterView.OnItemLongClickListener(){

           @Override
           public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
               removeItem(i);
               return false;
           }
       });
       */
    }

    private void removeItem(int i) {
        ma.getList().remove(i);
        populateList();
    }

    private void populateList() {
        ma = (MainActivity) getActivity();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(),R.layout.listview_template, ma.getList());
        ListView listView = binding.orderList;
        listView.setAdapter(adapter);

        DecimalFormat df = new DecimalFormat("$ ###,##0.00");
        Order o = ma.getOrder();
        binding.subtotal.setText(df.format(o.orderPrice()));
        binding.tax.setText(df.format(o.getTax()));
        binding.total.setText(df.format(o.getTotal()));
    }

    private void placeOrder() {
        ma.placeOrder();
        populateList();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}