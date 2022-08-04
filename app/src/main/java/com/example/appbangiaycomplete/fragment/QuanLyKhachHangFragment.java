package com.example.appbangiaycomplete.fragment;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbangiaycomplete.Activity.MainActivity;
import com.example.appbangiaycomplete.Adapter.OderAdapter;
import com.example.appbangiaycomplete.Adapter.UserAdapter;
import com.example.appbangiaycomplete.Product;
import com.example.appbangiaycomplete.R;
import com.example.appbangiaycomplete.User;

import java.util.ArrayList;
import java.util.List;

public class QuanLyKhachHangFragment extends Fragment {
    private RecyclerView rcvUser;
    private UserAdapter userAdapter;
    private List<User> mListUser;
    private View mview;
    private MainActivity mMainActivity;
    public QuanLyKhachHangFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mview = inflater.inflate(R.layout.quan_ly_khach_hang, container, false);
        //mapping
        rcvUser = mview.findViewById(R.id.rcv_user);

        mMainActivity = (MainActivity) getActivity();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mMainActivity);
        rcvUser.setLayoutManager(linearLayoutManager);

        userAdapter = new UserAdapter(mMainActivity, getListUser());
        mListUser = getListUser();
        userAdapter.setData(mListUser);
        rcvUser.setAdapter(userAdapter);

//
        // hiển thị danh sách theo chiều dọc
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(mMainActivity,
                DividerItemDecoration.VERTICAL);
        rcvUser.addItemDecoration(itemDecoration);
        //
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            // direction
            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAbsoluteAdapterPosition();
                mListUser.remove(position);
                userAdapter.notifyDataSetChanged();

            }
        });
        itemTouchHelper.attachToRecyclerView(rcvUser);


        return mview;
    }

    private List<User> getListUser() {
        List<User> listUser = new ArrayList<>();
        listUser.add(new User(R.drawable.img_cat_02, "Lê Chí Hiếu ", "13456@gmail.com"));
        listUser.add(new User(R.drawable.img_cat_03, "Nguyễn Văn A", "134567@gmail.com"));
        listUser.add(new User(R.drawable.img_cat_04, "Nguyễn Văn B ", "1345678@gmail.com"));
        listUser.add(new User(R.drawable.img_cat_05, "Nguyễn Văn C ", "13456789@gmail.com"));
        listUser.add(new User(R.drawable.img_cat_05, "Nguyễn Văn C ", "13456789@gmail.com"));
        listUser.add(new User(R.drawable.img_cat_05, "Nguyễn Văn C ", "13456789@gmail.com"));
        listUser.add(new User(R.drawable.img_cat_05, "Nguyễn Văn C ", "13456789@gmail.com"));
        listUser.add(new User(R.drawable.img_cat_05, "Nguyễn Văn C ", "13456789@gmail.com"));
        listUser.add(new User(R.drawable.img_cat_05, "Nguyễn Văn C ", "13456789@gmail.com"));
        listUser.add(new User(R.drawable.img_cat_05, "Nguyễn Văn C ", "13456789@gmail.com"));
        listUser.add(new User(R.drawable.img_cat_05, "Nguyễn Văn C ", "13456789@gmail.com"));


        return listUser;
    }


}
