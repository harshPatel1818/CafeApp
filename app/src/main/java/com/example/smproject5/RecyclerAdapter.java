package com.example.smproject5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//TODO: Write Comments for this class
//TODO: We should have separate images for each donut
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.DonutHolder> {
    private ArrayList<Donut> donutList;
    private OrderDonuts od;

    private final int TYPE_WORD_ONE = 2;
    private final int TYPE_WORD_TWO = 1;

    public RecyclerAdapter(ArrayList<Donut> x, OrderDonuts main)
    {
        donutList = x;
        od = main;
    }

    @NonNull
    @Override
    public DonutHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View donutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items,
                parent,false);
        return new DonutHolder(donutView);
    }

    @Override
    public void onBindViewHolder(@NonNull DonutHolder holder, int position) {
        String name = donutList.get(position).getFlavor() + donutList.get(position).getType();
        String price = "$" + donutList.get(position).itemPrice();
        holder.name.setText(name);
        holder.price.setText(price);
    }

    private void addDonut(String donutName) {
        String[] nameWords = donutName.split(" ");
        int n = nameWords.length;
        String flavorName = nameWords[0];
        String typeName = nameWords[n-TYPE_WORD_ONE] + " " + nameWords[n-TYPE_WORD_TWO];
        for(int i = 1; i < n-2; i++) {
            flavorName += " " + nameWords[i];
        }
        Donut newDonut = new Donut(typeName, flavorName, 1);
        od.addDonut(newDonut);
    }

    @Override
    public int getItemCount() {
        return donutList.size();
    }

    public class DonutHolder extends RecyclerView.ViewHolder {
        private TextView name, price;
        //private ImageView im_item;
        private Button button;
        private ConstraintLayout parentLayout; //this is the row layout

        public DonutHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
            button = itemView.findViewById(R.id.addButton);
            parentLayout = itemView.findViewById(R.id.rowLayout);
            setAddButtonOnClick(itemView); //register the onClicklistener for the button on each row.
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
                    addDonut(name.getText().toString());
                    Toast.makeText(itemView.getContext(), R.string.donut_added,
                            Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
