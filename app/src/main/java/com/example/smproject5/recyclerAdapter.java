package com.example.smproject5;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.MyViewHolder>{
    private ArrayList<Donut> donutList;

    public recyclerAdapter(ArrayList<Donut> x)
    {
        this.donutList = x;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        private TextView donutName;
        private TextView donutPrice;
        private Button button;


        public MyViewHolder(final View view)
        {
            super(view);
            donutName = view.findViewById(R.id.name);
            donutPrice = view.findViewById(R.id.price);
            button = view.findViewById(R.id.addButton);
        }
    }

    @NonNull
    @Override
    public recyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View donutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items,parent,false);
        return new MyViewHolder(donutView);
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerAdapter.MyViewHolder holder, int position) {
        String n = donutList.get(position).getFlavor()+donutList.get(position).getType();
        holder.donutName.setText(n);
        holder.donutPrice.setText(""+donutList.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return donutList.size();
    }

    public static class donutHolder extends RecyclerView.ViewHolder {
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
             */
            parentLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(itemView.getContext(), ItemSelectedActivity.class);
                    intent.putExtra("ITEM", name.getText());
                    itemView.getContext().startActivity(intent);
                }
            });
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
                    alert.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(itemView.getContext(),
                                    name.getText().toString() + " added.", Toast.LENGTH_LONG).show();
                        }
                        //handle the "NO" click
                    }).setNegativeButton("no", new DialogInterface.OnClickListener() {
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



        /*

        super(itemView);
            name = itemView.findViewById(R.id.name);
            dprice = itemView.findViewById(R.id.price);
           // im_item = itemView.findViewById(R.id.im_item);
            ab = itemView.findViewById(R.id.addButton);
            parentLayout = itemView.findViewById(R.id.rowLayout);
            setAddButtonOnClick(itemView); //register the onClicklistener for the button on each row.

            parentLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(itemView.getContext(), ItemSelectedActivity.class);
                    intent.putExtra("ITEM", name.getText());
                    itemView.getContext().startActivity(intent);
                }
            });



        private void setAddButtonOnClick(@NonNull View itemView) {
            ab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder alert = new AlertDialog.Builder(itemView.getContext());
                    alert.setTitle("Add to order");
                    alert.setMessage(name.getText().toString());
                    //handle the "YES" click
                    alert.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(itemView.getContext(),
                                    name.getText().toString() + " added.", Toast.LENGTH_LONG).show();
                        }
                        //handle the "NO" click
                    }).setNegativeButton("no", new DialogInterface.OnClickListener() {
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






         public static class donutHolder extends RecyclerView.ViewHolder
    {
        private TextView name,dprice;
        private Button ab;
        View rootView;
        int position;
        Donut donut;
       // private ConstraintLayout parentLayout;
        public donutHolder(@NonNull View itemView)
        {
         super(itemView);
         rootView = itemView;
         name = itemView.findViewById(R.id.name);
         dprice = itemView.findViewById(R.id.price);
         itemView.setOnClickListener(new View.OnClickListener(){

             @Override
             public void onClick(View view) {
                 Log.d("demo","onCLick: item clicked "+position+"donut" +donut.getFlavor());
                 name.setText(""+position);
             }
         });

         itemView.findViewById(R.id.addButton).setOnClickListener(new View.OnClickListener(){

             @Override
             public void onClick(View view) {
                 Log.d("demo","onCLick: item clicked "+donut.getFlavor());
                 System.out.println(position);
                // dprice.setText(""+positon);
             }
         });
        */




