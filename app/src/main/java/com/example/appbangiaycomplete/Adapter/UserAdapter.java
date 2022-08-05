package com.example.appbangiaycomplete.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbangiaycomplete.R;
import com.example.appbangiaycomplete.User;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder>implements Filterable {
    private List<User> mListUser;
    private List<User> mListUserOld;

    private Context mContext;
    private User user;
    public void setData(List<User> list) {
        this.mListUser = list;
        notifyDataSetChanged();
    }
    public UserAdapter(Context context, List<User> mListUser) {
      this.mContext = context;
        this.mListUser = mListUser;
        this.mListUserOld= mListUser;

    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.khach_hang_custom, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = mListUser.get(position);
        if (user == null) {
            return;
        }
        holder.imgUser.setImageResource(user.getImage());
        holder.tvName.setText(user.getName());
        holder.tvAddress.setText(user.getAddress());
    }

    @Override
    public int getItemCount() {
        if (mListUser != null) {
            return mListUser.size();
        }
        return 0;
    }


//mapping
    public class UserViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView imgUser;
        private TextView tvName;
        private TextView tvAddress;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            imgUser = itemView.findViewById(R.id.img_user);
            tvName = itemView.findViewById(R.id.tv_name);
            tvAddress = itemView.findViewById(R.id.tv_address);


        }
    }
    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String strSearch = charSequence.toString();
                if (strSearch.isEmpty()) {
                    mListUser = mListUserOld;
                } else {
                    List<User> products = new ArrayList<>();
                    for (User pro : mListUser) {
                        if (pro.getName().toLowerCase().contains(strSearch.toLowerCase())){
                            products.add(pro);
                        }

                    }
                    mListUser = products;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = mListUser;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mListUser = (List<User>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

}
