package com.example.appbangiaycomplete.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.appbangiaycomplete.Adapter.OderAdapter;
import com.example.appbangiaycomplete.Adapter.ProductAdapter;
import com.example.appbangiaycomplete.Product;
import com.example.appbangiaycomplete.Product02;
import com.example.appbangiaycomplete.R;

import java.util.ArrayList;
import java.util.List;

public class QuanLySanPham extends AppCompatActivity {
    RecyclerView rcvProduct;
    Button btnAddProduct, btnDeleteProduct;

    ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quan_ly_san_pham);
        //ánh xạ
        rcvProduct = findViewById(R.id.rcv_productt);
        btnAddProduct = findViewById(R.id.add_product);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(QuanLySanPham.this);
        rcvProduct.setLayoutManager(linearLayoutManager);

        productAdapter = new ProductAdapter(QuanLySanPham.this, getListProduct());
        rcvProduct.setAdapter(productAdapter);
//  ngăn cách  bằng 1 đường gạch giữa các item trên list
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(QuanLySanPham.this,
                DividerItemDecoration.VERTICAL);
        rcvProduct.addItemDecoration(itemDecoration);
        // sư  kiên them
        btnAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(QuanLySanPham.this, "đã  chọn thêm sản phẩm ", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(QuanLySanPham.this, AddProduct.class));
            }
        });
    }

    // them sp vào list
    private List<Product02> getListProduct() {
        List<Product02> listProduct = new ArrayList<>();
        listProduct.add(new Product02(R.drawable.img_shoes_04, "Vans", 200, 2));
        listProduct.add(new Product02(R.drawable.img_shoes_04, "Vans", 200, 2));
        listProduct.add(new Product02(R.drawable.img_shoes_04, "Vans", 200, 2));
        listProduct.add(new Product02(R.drawable.img_shoes_04, "Vans", 200, 2));
        listProduct.add(new Product02(R.drawable.img_shoes_04, "Vans", 200, 2));
        listProduct.add(new Product02(R.drawable.img_shoes_04, "Vans", 200, 2));


        return listProduct;

    }

    // chuyển qyua màn hình edit
    private void onClickGoToEditOderProduct(Product product) {
        Intent intent = new Intent(QuanLySanPham.this, EditProduct.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_oder_product", product);
        QuanLySanPham.this.startActivity(intent);

    }

}