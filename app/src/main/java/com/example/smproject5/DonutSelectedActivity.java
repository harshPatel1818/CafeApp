package com.example.smproject5;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

//TODO: Delete this file if we don't use it. If we do use it, comment it.
public class DonutSelectedActivity extends AppCompatActivity
{
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_item_selected);
        //button = findViewById(R.id.btn1);
        Intent intent = getIntent();
        button.setText(intent.getStringExtra("ITEM"));
    }
}
