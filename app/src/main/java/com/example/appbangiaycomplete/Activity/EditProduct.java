package com.example.appbangiaycomplete.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.appbangiaycomplete.ProductAdmin;
import com.example.appbangiaycomplete.R;

public class EditProduct extends AppCompatActivity {
    private EditText edtNameProduct, edtBrand, edtPrice, edtSize, edtColor, edtAmount, edtDescription, edtId;
    private ImageView imgProduct;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sua_san_pham);
        Bundle bundle = getIntent().getExtras();
        if (bundle == null) {
            return;
        }
        ProductAdmin oderProductAdmin = (ProductAdmin) bundle.get("object_product");

        edtNameProduct = findViewById(R.id.edt_name_product);
        edtNameProduct.setText(oderProductAdmin.getProductName());

        edtId = findViewById(R.id.edt_id);
        edtId.setText(oderProductAdmin.getIdProc());

        edtBrand = findViewById(R.id.edt_brand);
        edtBrand.setText(oderProductAdmin.getBrand());

        edtPrice = findViewById(R.id.edt_price);
        edtPrice.setText(oderProductAdmin.getPrice()+"");

        edtSize = findViewById(R.id.edt_size);
        edtSize.setText(oderProductAdmin.getSize()+"");

        edtColor = findViewById(R.id.edt_color);
        edtColor.setText(oderProductAdmin.getColor());

        edtAmount = findViewById(R.id.edt_amount);
        edtAmount.setText(oderProductAdmin.getAmount()+"");

        edtDescription = findViewById(R.id.edt_description);
        edtDescription.setText(oderProductAdmin.getDescription());


//
        btnSave = findViewById(R.id.btn_product_save);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(EditProduct.this, "đã lưu ", Toast.LENGTH_SHORT).show();

            }
        });

    }
}