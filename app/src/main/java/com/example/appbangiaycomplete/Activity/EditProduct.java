package com.example.appbangiaycomplete.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appbangiaycomplete.Order;
import com.example.appbangiaycomplete.Product;
import com.example.appbangiaycomplete.Product02;
import com.example.appbangiaycomplete.R;

public class EditProduct extends AppCompatActivity {
    private EditText edtUserName, edtIdProduct, edtAmount, edtTotalCost, edtAddress, edtState;
//    private Button btnConfirm, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sua_sp);
        // function transmission
        Bundle bundle = getIntent().getExtras();
        if (bundle == null) {
            return;
        }
        // data transmission from ProductAdapter
        Order order = (Order) bundle.get("object_product");
        edtUserName = findViewById(R.id.ten_sp);
        edtUserName.setText(order.getUserName());
        edtIdProduct = findViewById(R.id.hang);
        edtIdProduct.setText(order.getIdProdDetails());
        edtAmount = findViewById(R.id.gia);
        edtAmount.setText(order.getAmountOrder() + "");
        edtTotalCost = findViewById(R.id.size);
        edtTotalCost.setText(order.getTotalCost() + "");
        edtAddress = findViewById(R.id.mau);
        edtAddress.setText(order.getDelivery());
        edtState = findViewById(R.id.so_luong);
        edtState.setText(order.getState() + "");

    }
}