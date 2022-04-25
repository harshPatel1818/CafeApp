package com.example.smproject5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//TODO: We should have separate images for each donut

/**
 *Controls all the functions of the recycler view for ordering donut window.
 * @author Aaron Browne, Harshkumar Patel
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.DonutHolder> {
    private ArrayList<Donut> donutList;
    private OrderDonuts od;


    private final int TYPE_WORD_ONE = 2;
    private final int TYPE_WORD_TWO = 1;


    /**
     * Constructor that makes a new adapter with the given parameters.
     * @param x Arraylist of type Donut
     * @param main object of type OrderDonuts
     */

    public RecyclerAdapter(ArrayList<Donut> x, OrderDonuts main)
    {
        donutList = x;
        od = main;
    }

    /**
     * Sets up the format for list items using the list_items xml file.
     * @param parent The parent.
     * @param viewType The view type.
     * @return The DonutHolder object.
     */
    @NonNull
    @Override
    public DonutHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View donutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items,
                parent,false);
        return new DonutHolder(donutView);
    }

    /**
     * Sets the name and price of the donut in each list item.
     * @param holder The donut holder.
     * @param position The index of the list item in recycler view.
     */
    @Override
    public void onBindViewHolder(@NonNull DonutHolder holder, int position) {
        String name = donutList.get(position).getFlavor() + donutList.get(position).getType();
        String price = "$" + donutList.get(position).itemPrice();
        holder.name.setText(name);
        holder.price.setText(price);
        holder.imageView2.setImageResource(donutList.get(position).getImage());
    }

    /**
     * This method takes a donut name as a parameter and adds that donut the current order.
     * @param donutName String name of the donut.
     */
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

    /**
     * This method returns the number of donuts in the list items.
     * @return int number of donuts in the list.
     */
    @Override
    public int getItemCount() {
        return donutList.size();
    }

    /**
     * Helper class that controls the add button functionality in the view.
     * @author Harshkumar Patel
     */
    public class DonutHolder extends RecyclerView.ViewHolder {
        private TextView name, price;
        private ImageView imageView2;
        private Button button;
        private ConstraintLayout parentLayout; //this is the row layout

        /**
         * Constructor which makes a new DonutHolder given View as a parameter.
         * @param itemView View
         */
        public DonutHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
            button = itemView.findViewById(R.id.addButton);
            imageView2 = itemView.findViewById(R.id.imageView2);
            parentLayout = itemView.findViewById(R.id.rowLayout);
            setAddButtonOnClick(itemView); //register the onClicklistener for the button on each row.
        }

        /**
         * Set the onClickListener for the button on each row.
         * Clicking on the button will create an Toast that will notify the user that the donut has been added to the order.
         * @param itemView View
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
