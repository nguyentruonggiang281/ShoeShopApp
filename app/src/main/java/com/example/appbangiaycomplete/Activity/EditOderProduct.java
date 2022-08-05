package com.example.appbangiaycomplete.Activity;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appbangiaycomplete.Product;
import com.example.appbangiaycomplete.R;

public class EditOderProduct extends AppCompatActivity {
    private EditText edtNameProduct, edtBrand, edtPrice, edtSize, edtColor, edtAmount, edtDescription;
    private ImageView imgProduct;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sua_san_pham_02);
        Bundle bundle = getIntent().getExtras();
        if (bundle == null) {
            return;
        }
        Product oderProduct = (Product) bundle.get("object_oder_product");
        edtNameProduct = findViewById(R.id.ten_sp);
        edtNameProduct.setText(oderProduct.getProductName());
        edtBrand = findViewById(R.id.hang);
        edtBrand.setText(oderProduct.getBrand());
        edtPrice = findViewById(R.id.gia);
        edtPrice.setText(oderProduct.getPrice() + "");
        edtSize = findViewById(R.id.size);
        edtSize.setText(oderProduct.getSize() + "");
        edtColor = findViewById(R.id.mau);
        edtColor.setText(oderProduct.getColor());
        edtAmount = findViewById(R.id.so_luong);
        edtAmount.setText(oderProduct.getAmount() + "");
        edtDescription = findViewById(R.id.noi_dung);
        edtDescription.setText(oderProduct.getDescription());

//
        btnSave= findViewById(R.id.btn_save);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(EditOderProduct.this, "đã lưu ", Toast.LENGTH_SHORT).show();

            }
        });

    }
}