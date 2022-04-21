package com.example.smproject5;

import android.content.ClipData;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class OrderDonuts extends AppCompatActivity {
    private ArrayList<Donut> donutList;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        donutList = new ArrayList<>();
    }
}
