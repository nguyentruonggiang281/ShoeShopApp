package com.example.appbangiaycomplete.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbangiaycomplete.Activity.EditOderProduct;
import com.example.appbangiaycomplete.MyInterface.IonClickInterface;
import com.example.appbangiaycomplete.Product;
import com.example.appbangiaycomplete.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class OderAdapter extends RecyclerView.Adapter<OderAdapter.OderViewHolder> implements Filterable {
    public List<Product> mListOderProduct;
    public List<Product> mListOderProductOld;
    private Context mContext;
    public Product oderProduct;

    //
    public void setData(List<Product> list) {
        this.mListOderProduct = list;
        notifyDataSetChanged();
    }

    public OderAdapter(Context context, List<Product> mListOderProduct) {
        this.mContext = context;
        this.mListOderProduct = mListOderProduct;
        this.mListOderProductOld = mListOderProduct;
    }


    //


    @NonNull
    @Override
    public OderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chi_tiet_don_hang_custom,
                parent, false);
        return new OderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OderViewHolder holder, int position) {
        oderProduct = mListOderProduct.get(position);
        if (oderProduct == null) {
            return;
        }
        holder.imgProduct.setImageResource(oderProduct.getImageProduct());
        holder.tvTxtProductName.setText(oderProduct.getProductName());
        holder.tvTxtBrand.setText(oderProduct.getBrand());
        holder.tvOderTxtPrice.setText(oderProduct.getPrice() + "");
        holder.tvTxtSize.setText(oderProduct.getSize() + "");
        holder.tvTxtColor.setText(oderProduct.getColor());
        holder.tvOderTxtAmount.setText(oderProduct.getAmount() + "");
        holder.tvTxtDescription.setText(oderProduct.getDescription());
        //

        //
        holder.layoutCustomItem.setOnClickListener(new View.OnClickListener() {
            @Override
            //bắt sự kiện click item chuyển đến trang editProduct.java
            public void onClick(View view) {
                onClickGoToEditOderProduct(oderProduct);
            }

            private void onClickGoToEditOderProduct(Product oderProduct) {
                Intent intent = new Intent(mContext, EditOderProduct.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("object_oder_product", oderProduct);
                intent.putExtras(bundle);
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        if (mListOderProduct != null) {
            return mListOderProduct.size();
        }
        return 0;
    }


    public class OderViewHolder extends RecyclerView.ViewHolder {
        private RelativeLayout layoutCustomItem;
        private ImageView imgProduct;
        private TextView tvTxtProductName;
        private TextView tvTxtBrand;
        private TextView tvOderTxtPrice;
        private CheckBox checkBox;
        private TextView tvTxtSize;
        private TextView tvTxtColor;
        private TextView tvOderTxtAmount;
        private TextView tvTxtDescription;


        public OderViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProduct = itemView.findViewById(R.id.img_oder_product);
            tvTxtProductName = itemView.findViewById(R.id.tv_txt_name_product);
            tvTxtBrand = itemView.findViewById(R.id.tv_txt_brand);
            tvOderTxtPrice = itemView.findViewById(R.id.tv_oder_txt_price);
            tvTxtSize = itemView.findViewById(R.id.tv_txt_size);
            tvTxtColor = itemView.findViewById(R.id.tv_txt_color);
            tvOderTxtAmount = itemView.findViewById(R.id.tv_oder_txt_amount);
            tvTxtDescription = itemView.findViewById(R.id.tv_oder_txt_des);
            layoutCustomItem = itemView.findViewById(R.id.chi_tiet_don_hang_custom);
//chuc năng xóa
//            itemView.setOnLongClickListener(new View.OnLongClickListener() {
//    @Override
//    public boolean onLongClick(View view) {
//        if(ionClickInterface!=null){
//            int pos = getAbsoluteAdapterPosition();
//            if ( pos != RecyclerView.NO_POSITION){
//                ionClickInterface.onItemLongClick(pos);
//            }
//        }
//        return true ;
//    }
//});


//
        }


    }

    //tìm kiếm
    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String strSearch = charSequence.toString();
                if (strSearch.isEmpty()) {
                    mListOderProduct = mListOderProductOld;
                } else {
                    List<Product> products = new ArrayList<>();
                    for (Product pro : mListOderProduct) {
                        if (pro.getProductName().toLowerCase().contains(strSearch.toLowerCase())) {
                            products.add(pro);
                        }

                    }
                    mListOderProduct = products;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = mListOderProduct;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mListOderProduct = (List<Product>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

}
