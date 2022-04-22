package com.example.smproject5;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DonutSelectedActivity extends AppCompatActivity
{
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_selected);
        button = findViewById(R.id.btn1);
        Intent intent = getIntent();
        button.setText(intent.getStringExtra("ITEM"));
    }
}
