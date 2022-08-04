package com.example.appbangiaycomplete.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbangiaycomplete.Activity.MainActivity;
import com.example.appbangiaycomplete.Adapter.ProductAdapter;
import com.example.appbangiaycomplete.Product;
import com.example.appbangiaycomplete.Product02;
import com.example.appbangiaycomplete.R;

import java.util.ArrayList;
import java.util.List;

public class QuanLySanPhamFragment extends Fragment {
   private RecyclerView rcvProduct;
    private View mview;
    private MainActivity mainActivity;
    private ProductAdapter productAdapter;
    Button btnAddProduct, btnEditProduct, btnDeleteProduct;
//lang nghe gọi activity
//private static EditText edittext;
//
//    QuanLySanPhamListener activityCallback;
//    public interface QuanLySanPhamListener {
//        public void onButtonClick(int fontsize, String text);
//    }
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        try {
//            activityCallback = (QuanLySanPhamListener) context;
//        } catch (ClassCastException e) {
//            throw new ClassCastException(context.toString()
//                    + " You must implement FirstFragmentListener");
//        }
//    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // co View mới dudocj anh xa trong fragment
//        View view = inflater.inflate(R.layout.quan_ly_san_pham, container, false);
//        mainActivity = (MainActivity) getActivity();
//        rcvProduct = view.findViewById(R.id.rcv_product);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mainActivity);
//        rcvProduct.setLayoutManager(linearLayoutManager);
//
//        ProductAdapter productAdapter = new ProductAdapter(getListProduct());
//        rcvProduct.setAdapter(productAdapter);
//
//        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(
//                mainActivity, DividerItemDecoration.VERTICAL);
//        rcvProduct.addItemDecoration(itemDecoration);
        //chuc nang xoa


        //
//        init(view);
//        btnAddProduct.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getActivity(), "", Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(mainActivity, Test01.class));
//                Fragment addProductFragment = new ThemSanPhamFragment();
//                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
//                fragmentTransaction.replace(R.id.quan_ly_san_pham, addProductFragment);
//                fragmentTransaction.commit();
//            }
//        });
        return mview;

    }

//    private List<Product02> getListProduct() {
//        List<Product02> listProduct = new ArrayList<>();
//        listProduct.add(new Product02(R.drawable.img_shoes_04, "Vans", 200, 2 ));
//        listProduct.add(new Product02(R.drawable.img_shoes_04, "Vans", 200, 2 ));
//        listProduct.add(new Product02(R.drawable.img_shoes_04, "Vans", 200, 2 ));
//        listProduct.add(new Product02(R.drawable.img_shoes_04, "Vans", 200, 2 ));
//        listProduct.add(new Product02(R.drawable.img_shoes_04, "Vans", 200, 2 ));
//
//
//        return listProduct;
//    }

    //anh xa
//    private void init(View view) {
//        btnAddProduct =  view.findViewById(R.id.btn_add_product);
//        btnEditProduct =  view.findViewById(R.id.btn_edit_product);
//        btnDeleteProduct =  view.findViewById(R.id.btn_delete_product);
//
//
//    }

//    private void buttonClicked(View view) {
//        activityCallback.onButtonClick(20,edittext.getText().toString());
//    }
}
