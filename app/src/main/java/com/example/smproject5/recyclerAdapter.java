package com.example.smproject5;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.donutHolder> {
    private ArrayList<Donut> donutList;
    private OrderDonuts od;

    public recyclerAdapter(ArrayList<Donut> x, OrderDonuts main)
    {
        donutList = x;
        od = main;
    }

    @NonNull
    @Override
    public donutHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View donutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items,
                parent,false);
        return new donutHolder(donutView);
    }

    @Override
    public void onBindViewHolder(@NonNull donutHolder holder, int position) {
        String name = donutList.get(position).getFlavor()+donutList.get(position).getType();
        String price = "$" + donutList.get(position).getPrice();
        holder.name.setText(name);
        holder.price.setText(price);
    }

    @Override
    public int getItemCount() {
        return donutList.size();
    }

    public class donutHolder extends RecyclerView.ViewHolder {
        private TextView name, price;
        //private ImageView im_item;
        private Button button;
        private ConstraintLayout parentLayout; //this is the row layout

        public donutHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
            //im_item = itemView.findViewById(R.id.im_item);
            button = itemView.findViewById(R.id.addButton);
            parentLayout = itemView.findViewById(R.id.rowLayout);
            setAddButtonOnClick(itemView); //register the onClicklistener for the button on each row.

            /* set onClickListener for the row layout,
             * clicking on a row will navigate to another Activity
             *
            parentLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(itemView.getContext(), ItemSelectedActivity.class);
                    intent.putExtra("ITEM", name.getText());
                    itemView.getContext().startActivity(intent);
                }
            }); */
        }

        private void addDonut(String donutName) {
            for(Donut e : donutList) {
                skdjsk
            }
        }

        /**
         * Set the onClickListener for the button on each row.
         * Clicking on the button will create an AlertDialog with the options of YES/NO.
         * @param itemView
         */
        private void setAddButtonOnClick(@NonNull View itemView) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder alert = new AlertDialog.Builder(itemView.getContext());
                    alert.setTitle("Add to order");
                    alert.setMessage(name.getText().toString());
                    //handle the "YES" click
                    alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Toast.makeText(itemView.getContext(),
                                    name.getText().toString() + " added.", Toast.LENGTH_LONG).show();
                        }
                        //handle the "NO" click
                    }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(itemView.getContext(),
                                    name.getText().toString() + " not added.", Toast.LENGTH_LONG).show();
                        }
                    });
                    AlertDialog dialog = alert.create();
                    dialog.show();
                }
            });
        }
    }
}
