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
                    alertDialogBuilder.setTitle(R.string.error);
                    alertDialogBuilder.setMessage(R.string.empty_order);

                    alertDialogBuilder.setPositiveButton(R.string.ok,
                            new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
                    alertDialogBuilder.show();

                } else {
                    placeOrder();
                }
            }
        });
// Create a message handling object as an anonymous class.
        AdapterView.OnItemClickListener messageClickedHandler = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
                alert.setTitle(R.string.remove_item);
                alert.setMessage(R.string.remove_from_order);
                //handle the "YES" click
                alert.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        removeItem(position);
                        Toast.makeText(getContext(), R.string.remove_success,
                                Toast.LENGTH_LONG).show();
                    }
                    //handle the "NO" click
                }).setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(), R.string.not_removed, Toast.LENGTH_LONG).show();
                    }
                });
                AlertDialog dialog = alert.create();
                dialog.show();
            }
        };

        binding.orderList.setOnItemClickListener(messageClickedHandler);
    }

    private void removeItem(int i) {
        ma.getOrder().remove(i);
        populateList();
    }

    private void populateList() {
        ma = (MainActivity) getActivity();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(),R.layout.listview_template, ma.getList());
        ListView listView = binding.orderList;
        listView.setAdapter(adapter);

        DecimalFormat df = new DecimalFormat("$###,##0.00");
        Order o = ma.getOrder();
        binding.subtotal.setText(df.format(o.orderPrice()));
        binding.tax.setText(df.format(o.getTax()));
        binding.total.setText(df.format(o.getTotal()));
    }

    private void placeOrder() {
        ma.placeOrder();
        populateList();
        Toast.makeText(getContext(), R.string.order_success, Toast.LENGTH_LONG).show();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}