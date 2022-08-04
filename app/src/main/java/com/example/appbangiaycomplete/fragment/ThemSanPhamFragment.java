package com.example.appbangiaycomplete.fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.appbangiaycomplete.R;

public class ThemSanPhamFragment extends Fragment  {
//    private TextView tvNname ;
//    private Button btnAddProduct;
    private View mView ;
    public ThemSanPhamFragment() {

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
   mView =  inflater.inflate(R.layout.sua_san_pham, container, false);


      return mView ;
    }
}