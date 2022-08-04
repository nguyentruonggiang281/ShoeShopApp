package com.example.appbangiaycomplete.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.appbangiaycomplete.Product;
import com.example.appbangiaycomplete.Product02;
import com.example.appbangiaycomplete.R;

public class EditProduct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sua_sp);
        Bundle bundle = getIntent().getExtras();
        if (bundle ==null){
            return;
        }
        Product02 Product02 = (Product02) bundle.get("object_product");

    }
}