package com.example.appbangiaycomplete.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.appbangiaycomplete.Activity.MainActivity;
import com.example.appbangiaycomplete.Activity.QuanLyDonHang02;
import com.example.appbangiaycomplete.Activity.QuanLySanPham;
import com.example.appbangiaycomplete.R;

public class HomeFragment extends Fragment {
    ViewFlipper viewFlipper;
    TextView textView;
    MainActivity mMainActivity;
ImageButton imgBtnMyProduct, imgBtnProduct;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.home_fragment, container, false);
mMainActivity= (MainActivity) getActivity();
init(view);
//sự kiện click vào img sản phẩm của toi
        imgBtnMyProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "đã chọn ", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(mMainActivity, QuanLyDonHang02.class));
            }
        });
        //sự kiện click vào sản phảm
        imgBtnProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "đã chọn ", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(mMainActivity, QuanLySanPham.class));
            }
        });

        return view;
    }

    private void init(View view) {

        imgBtnMyProduct = view.findViewById(R.id.imgBtn_my_product);
        imgBtnProduct= view .findViewById(R.id.imgBtn_oder);



    }


}