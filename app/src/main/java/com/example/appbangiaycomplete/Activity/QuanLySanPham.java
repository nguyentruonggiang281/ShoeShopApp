package com.example.appbangiaycomplete.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.appbangiaycomplete.Adapter.OderAdapter;
import com.example.appbangiaycomplete.Adapter.ProductAdapter;
import com.example.appbangiaycomplete.Order;
import com.example.appbangiaycomplete.Product;
import com.example.appbangiaycomplete.Product02;
import com.example.appbangiaycomplete.R;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class QuanLySanPham extends AppCompatActivity {
    public List<Order> mListOrder;

    RecyclerView rcvProduct;
    ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quan_ly_san_pham);
        //mapping
        rcvProduct = findViewById(R.id.rcv_productt);
//        btnAddProduct = findViewById(R.id.add_product);
//        btnConfirm = findViewById(R.id.btn_confirm);
//        Intent intent = getIntent();
//        id_productDetail= intent.getIntExtra("id_productDetail", 0);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(QuanLySanPham.this);
        rcvProduct.setLayoutManager(linearLayoutManager);

        productAdapter = new ProductAdapter(QuanLySanPham.this, getListProduct());
        mListOrder = getListProduct();
//        productAdapter.setData(mListOrder);
        rcvProduct.setAdapter(productAdapter);
        productAdapter.setOnItemClickListener(new ProductAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                mListOrder.remove(position);
                productAdapter.notifyItemRemoved(position);
            }
        });

        //  ngăn cách  bằng 1 đường gạch giữa các item trên list
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(QuanLySanPham.this,
                DividerItemDecoration.VERTICAL);
        rcvProduct.addItemDecoration(itemDecoration);
        // sư  kiên them
//        btnAddProduct.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(QuanLySanPham.this, "đã  chọn thêm sản phẩm ", Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(QuanLySanPham.this, AddProduct.class));
//            }
//        });

    }


    // them sp vào list
    private List<Order> getListProduct() {
        List<Order> listOder = new ArrayList<>();
        listOder.add(new Order("Lê Chí Hiếu  ", "id10", "2", "200"
                , "4/4, đường số 4,quận 4 ,HCM", "đang vận chuyển"));
        listOder.add(new Order("Lê Chí Hiếu  ", "id10", "2", "200"
                , "4/4, đường số 4,quận 4 ,HCM", "đang vận chuyển"));
        listOder.add(new Order("Lê Chí Hiếu  ", "id10", "2", "200"
                , "4/4, đường số 4,quận 4 ,HCM", "đang vận chuyển"));
        listOder.add(new Order("Lê Chí Hiếu  ", "id10", "2", "200"
                , "4/4, đường số 4,quận 4 ,HCM", "đang vận chuyển"));
        listOder.add(new Order("Lê Chí Hiếu  ", "id10", "2", "200"
                , "4/4, đường số 4,quận 4 ,HCM", "đang vận chuyển"));
        listOder.add(new Order("Lê Chí Hiếu  ", "id10", "2", "200"
                , "4/4, đường số 4,quận 4 ,HCM", "đang vận chuyển"));
        listOder.add(new Order("Lê Chí Hiếu  ", "id10", "2", "200"
                , "4/4, đường số 4,quận 4 ,HCM", "đang vận chuyển"));

        return listOder;

    }

    // chuyển qyua màn hình edit
    private void onClickGoToEditOderProduct(Order oder) {
        Intent intent = new Intent(QuanLySanPham.this, EditProduct.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_oder_product", oder);
        QuanLySanPham.this.startActivity(intent);
    }

    //
//    public void delete(final String idProdDetails) {
//        Dialog dialog = new Dialog(this);
//        dialog.setContentView(R.layout.dialog_delete_order);
//        dialog.setCanceledOnTouchOutside(false);
//        Button btnYes = findViewById(R.id.btn_yes_delete);
//        Button btnNo = findViewById(R.id.btn_no_delete);
//        btnYes.setOnClickListener(new View.OnClickListener() {
//            // mở lại activity
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(QuanLySanPham.this, QuanLySanPham.class);
//                intent.putExtra("id_productDetail", idProdDetails);
//                startActivity(intent);
//            }
//        });
//        btnNo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dialog.cancel();
//            }
//        });
//        dialog.show();
//    }
    public void Cancel(final int position) {
        Toast.makeText(this, "   thoát ", Toast.LENGTH_SHORT).show();
        mListOrder.remove(position);
        productAdapter.notifyDataSetChanged();


    }

    public void Comfirm(final int position) {

    }
}