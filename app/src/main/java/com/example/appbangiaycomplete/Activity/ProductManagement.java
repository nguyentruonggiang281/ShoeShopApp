package com.example.appbangiaycomplete.Activity;

import android.app.AlertDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbangiaycomplete.Adapter.ProductAdapter;
import com.example.appbangiaycomplete.Image;
import com.example.appbangiaycomplete.ProductAdmin;
import com.example.appbangiaycomplete.R;
import com.example.appbangiaycomplete.database.DataBase;
import com.example.appbangiaycomplete.database.DataOfUser;

import java.util.ArrayList;
import java.util.List;


public class ProductManagement extends AppCompatActivity {
    private RecyclerView rcvOder;
    public static ProductAdapter productAdapter;
    public static ArrayList<ProductAdmin> mListProductAdmin;
    private Button btnAddProduct, btnEditProduct, btnDeleteProduct;
    private EditText edtSearch;
    private ImageButton imgBtnSearch;
    SearchView searchView;
    DataBase dataBase;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.quan_li_san_pham);
//ánh xạ
        Toolbar toolbar = findViewById(R.id.toolbar_search);
        setSupportActionBar(toolbar);
        dataBase = new DataBase(this, "shopgiay.sqlite", null, 1);

        Toast.makeText(this, getDatabasePath("shopgiay.sqlite").getPath(), Toast.LENGTH_LONG).show();

        rcvOder = findViewById(R.id.rcv_oder);
//        edtSearch = findViewById(R.id.edt_search);
//        imgBtnSearch = findViewById(R.id.imgBtn_search);
        btnAddProduct = findViewById(R.id.them_don_hang);
//        btnEditProduct = findViewById(R.id.sua_don_hang);
//        btnDeleteProduct = findViewById(R.id.xoa_don_hang);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ProductManagement.this);
        rcvOder.setLayoutManager(linearLayoutManager);

        productAdapter = new ProductAdapter(this, getListOderProduct());
        mListProductAdmin = getListOderProduct();
        productAdapter.setData(mListProductAdmin);
        rcvOder.setAdapter(productAdapter);
//        oderAdapter = new OderAdapter(QuanLyDonHang02.this, getListOderProduct());
//        rcvOder.setAdapter(oderAdapter);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(ProductManagement.this,
                DividerItemDecoration.VERTICAL);
        rcvOder.addItemDecoration(itemDecoration);

// vuốt phải , trái delete item
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            // direction
            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAbsoluteAdapterPosition();
                AlertDialog.Builder dialog = new AlertDialog.Builder(ProductManagement.this);
                dialog.setTitle("Thông báo");
                dialog.setCancelable(false);
                dialog.setMessage("Bạn có chắc muốn xóa");
                dialog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        productAdapter.notifyDataSetChanged();
                    }
                });

                dialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mListProductAdmin.remove(position);
                        productAdapter.notifyDataSetChanged();
                    }
                });

                dialog.show();

            }
        });
        itemTouchHelper.attachToRecyclerView(rcvOder);

//        tìm kiếm
//        edtSearch.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });

        //bat sư kiên thêm sản phẩm
        btnAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ProductManagement.this, "đã  chọn thêm sản phẩm ", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ProductManagement.this, AddProduct.class));
            }
        });


    }


    private ArrayList<ProductAdmin> getListOderProduct() {
//        List<ProductAdmin> listOderProductAdmin = new ArrayList<>();
//        ArrayList<Image> listImg = new ArrayList<>();
//        listImg.a
//        listOderProductAdmin.add(new ProductAdmin("p10", R.drawable.img_shoes_03, "Puma", "Puma", 100, 3, "chính hãng", 32, "trắng"));
//        listOderProductAdmin.add(new ProductAdmin("V10", R.drawable.img_shoes_05, "Vans", "Vans", 200, 4, "rep 1:1", 23, "đen"));
//        listOderProductAdmin.add(new ProductAdmin("p10", R.drawable.img_shoes_04, "jordan", "Puma", 100, 3, "chính hãng", 32, "trắng"));
//        listOderProductAdmin.add(new ProductAdmin("p10", R.drawable.img_shoes_04, "pamu là dày déo gì+", "Puma", 100, 3, "chính àdfdfdfdf", 32, "trắng"));
//        listOderProductAdmin.add(new ProductAdmin("p10", R.drawable.img_shoes_04, "convert", "convert", 100, 3, "thông tin chi tiết", 32, "trắng"));
//        listOderProductAdmin.add(new ProductAdmin("p10", R.drawable.img_shoes_03, "bitis", "bitis", 100, 3, "chính hãng", 32, "trắng"));
//        listOderProductAdmin.add(new ProductAdmin("p10", R.drawable.img_shoes_03, "adidas", "adidas", 100, 3, "chính hãng", 32, "trắng"));
        //list img defaul
        ArrayList<Image> listImage = new ArrayList<Image>();

        ArrayList<ProductAdmin> products = new ArrayList<>();
        Cursor data = dataBase.getData("SELECT p.idprod, p.nameProd,p.brand,p.price,pd.quantity,p.desc, pd.size,pd.color FROM Product p JOIN ProductDetails pd ON p.idProd = pd.idProd");
        if (data != null) {
            if (data.moveToFirst()) {
                do {
                    Cursor dataImg = dataBase.getData("SELECT img FROM LinkImg_Prod WHERE idProd = '"+data.getString(0)+"'");
                    if (dataImg != null) {
                        if (dataImg.moveToFirst()) {
                            do {
                                listImage.add(new Image(dataImg.getBlob(0)));
                            } while (dataImg.moveToNext());
                        }
                    }
                    products.add(new ProductAdmin(data.getString(0), listImage, data.getString(1), data.getString(2),Integer.parseInt(data.getString(3)),Integer.parseInt(data.getString(4)), data.getString(5), Integer.parseInt(data.getString(6)),data.getString(7) ));
                    listImage = new ArrayList<Image>();
                } while (data.moveToNext());
            }
        }
        return products;
    }

    //  chuyển sang màn hình edit khi click vào item
//    private void onClickGoToEditOderProduct(Product product) {
//        Intent intent = new Intent(QuanLyDonHang02.this, EditOderProduct.class);
//        Bundle bundle = new Bundle();
//        bundle.putSerializable("object_oder_product", product);
//        QuanLyDonHang02.this.startActivity(intent);
//
//    }
    // chuyển qyua màn hình edit
    private void onClickGoToEditProduct(ProductAdmin productAdmin) {
        Intent intent = new Intent(ProductManagement.this, EditOrder.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_product", productAdmin);
        ProductManagement.this.startActivity(intent);
    }
    @Override
    // chức năng tìm kiếm
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

    //
    @Override
    public void onBackPressed() {
        if (!searchView.isIconified()) {
            searchView.setIconified(true);
            return;
        }
        super.onBackPressed();
    }
//chuc năng xóa
//@Override
//public void onItemLongClick(int poistion) {
//    mListProduct.remove(poistion);
//    oderAdapter.notifyItemRemoved(poistion);
//}


}
