package com.example.appbangiaycomplete.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
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
    SearchView searchView;

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
        listOder.add(new Order("Lê Chí Hiếu | 0394366113", "id10", "2", "200"
                , "4/4, đường số 4,quận 4 ,HCM", "đang vận chuyển"));

        listOder.add(new Order("Lê Chí Hiếu  | 0394366113", "id10", "2", "200"
                , "4/4, đường số 4,quận 4 ,HCM", "đang vận chuyển"));
        listOder.add(new Order("Lê Chí Hiếu | 0394366113", "id10", "2", "200"
                , "4/4, đường số 4,quận 4 ,HCM", "đang vận chuyển"));
        listOder.add(new Order("Lê Chí Hiếu | 0394366113", "id10", "2", "200"
                , "4/4, đường số 4,quận 4 ,HCM", "đang vận chuyển"));
        listOder.add(new Order("Lê Chí Hiếu | 0394366113", "id10", "2", "200"
                , "4/4, đường số 4,quận 4 ,HCM", "đang vận chuyển"));
        listOder.add(new Order("Lê Chí Hiếu | 0394366113", "id10", "2", "200"
                , "4/4, đường số 40000000000000000000000000000000000000000000000000000000000000000000000000000000000000,quận 4 ,HCM", "đang vận chuyển"));
        listOder.add(new Order("Lê Chí | 0394366113", "id10", "2", "200"
                , "4/4, đường số 4,quận 4 ,HCM", "đang vận chuyển"));

        return listOder;

    }

    // chuyển qyua màn hình edit
    private void onClickGoToEditOderProduct(Order order) {
        Intent intent = new Intent(QuanLySanPham.this, EditProduct.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_oder_product", order);
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
//    public void Cancel(final int position) {
//        Toast.makeText(this, "   thoát ", Toast.LENGTH_SHORT).show();
//        mListOrder.remove(position);
//        productAdapter.notifyDataSetChanged();
//
//
//    }
//
//    public void Comfirm(final int position) {
//
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                productAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                productAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }

}
