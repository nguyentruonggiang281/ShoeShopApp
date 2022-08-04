package com.example.appbangiaycomplete.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbangiaycomplete.Activity.MainActivity;

public class QuanLyDonHangFragment extends Fragment {
    private RecyclerView rcvOder;
    private View mview;
    private MainActivity mMainActivity;
    Button btnAddProduct, btnEditProduct, btnDeleteProduct;


    public QuanLyDonHangFragment() {

    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        mview = inflater.inflate(R.layout.sua_san_pham, container, false);
//        rcvOder = mview.findViewById(R.id.rcv_oder);
//        mMainActivity = (MainActivity) getActivity();
//
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mMainActivity);
//        rcvOder.setLayoutManager(linearLayoutManager);
//
//        OderAdapter oderAdapter = new OderAdapter(mMainActivity, getListOderProduct());
//        rcvOder.setAdapter(oderAdapter);
//
//        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(mMainActivity,
//                DividerItemDecoration.VERTICAL);
//        rcvOder.addItemDecoration(itemDecoration);
//
//        init(mview);
//        btnEditProduct.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Fragment addProductFragment = new ThemSanPhamFragment();
//                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
//                fragmentTransaction.replace(R.id.chi_tiet_don_hang, addProductFragment);
//              fragmentTransaction.commit();
//            }
//        });
        // thêm sản phẩm
//        btnAddProduct.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getActivity(), "", Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(mMainActivity, AddProduct.class));
//            }
//        });
        //
        return mview;
    }

//    private void init(View view ) {
//        btnAddProduct = (Button) view.findViewById(R.id.them_don_hang);
//        btnEditProduct = (Button) view.findViewById(R.id.sua_don_hang);
//    }

//    private List<Product> getListOderProduct() {
//        List<Product> listOderProduct = new ArrayList<>();
//        listOderProduct.add(new Product(R.drawable.img_giay, "adidas", "adidas",
//                200, 2, "hàng chính hãng ", 32, "trắng "));

//        return listOderProduct;
//    }
}
