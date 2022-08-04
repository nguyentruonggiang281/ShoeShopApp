package com.example.appbangiaycomplete.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.appbangiaycomplete.Activity.EditOderProduct;
import com.example.appbangiaycomplete.Activity.EditProduct;
import com.example.appbangiaycomplete.Product02;
import com.example.appbangiaycomplete.R;

import java.io.Serializable;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    //

    //
    private List<Product02> mListProduct;
    private Context mContext;
    Product02 product02;

    public ProductAdapter(Context context, List<Product02> mListProduct) {
        this.mListProduct = mListProduct;
        this.mContext = context;
    }


    @NonNull
    @Override
    public ProductAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.quan_ly_san_pham_custom, parent, false);


        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product02 product = mListProduct.get(position);
        if (product == null) {
            return;
        }
        holder.imgProduct.setImageResource(product.getImg());
        holder.tvNameProduct.setText(product.getName());
        holder.tvPrice.setText(product.getPrice() + "");
        holder.tvAmount.setText(product.getAmount() + "");
        //
        holder.layoutCustomItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                oncLickGoToEditProduct(product02);
            }

            private void oncLickGoToEditProduct(Product02 product02) {
                Intent intent = new Intent(mContext, EditProduct.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("object_product", product02);
                intent.putExtras(bundle);
                mContext.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        if (mListProduct != null) {
            return mListProduct.size();
        }
        return 0;
    }


    public class ProductViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgProduct;
        private TextView tvNameProduct;
        private TextView tvPrice;
        private TextView tvAmount;
        private CheckBox cbCheckBox;
        private RelativeLayout layoutCustomItem;

        public ProductViewHolder(View itemView) {
            super(itemView);
            imgProduct = itemView.findViewById(R.id.image_product);
            tvNameProduct = itemView.findViewById(R.id.name_product);
            tvPrice = itemView.findViewById(R.id.tv_price);
            tvAmount = itemView.findViewById(R.id.so_luong);
            cbCheckBox = itemView.findViewById(R.id.cb_checkBox);
            layoutCustomItem = itemView.findViewById(R.id.quan_ly_san_pham_custom);

        }
    }
}
