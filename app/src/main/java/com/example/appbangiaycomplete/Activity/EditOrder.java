package com.example.appbangiaycomplete.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appbangiaycomplete.Order;
import com.example.appbangiaycomplete.R;

public class EditOrder extends AppCompatActivity {
    private EditText edtUserName, edtIdProduct, edtAmount, edtTotalCost, edtAddress, edtState;
Button btnSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sua_don_hang);

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
        edtAddress = findViewById(R.id.noi_dung);
        edtAddress.setText(order.getDelivery()+"");
        edtState = findViewById(R.id.so_luong);
        edtState.setText(order.getState());
//
        btnSave = findViewById(R.id.btn_order_save);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(EditOrder.this, "đã lưu ", Toast.LENGTH_SHORT).show();

            }
        });
    }

}