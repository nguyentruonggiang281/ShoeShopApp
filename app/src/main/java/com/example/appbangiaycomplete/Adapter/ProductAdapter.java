package com.example.appbangiaycomplete.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbangiaycomplete.Activity.EditProduct;
import com.example.appbangiaycomplete.ProductAdmin;
import com.example.appbangiaycomplete.R;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.OderViewHolder> implements Filterable {
    public ArrayList<ProductAdmin> mListOderProductAdmin;
    public ArrayList<ProductAdmin> mListOderProductAdminOld;
    private Context mContext;
//    public Product oderProduct;

    //
    public void setData(ArrayList<ProductAdmin> list) {
        this.mListOderProductAdmin = list;
        notifyDataSetChanged();
    }

    public ProductAdapter(Context context, ArrayList<ProductAdmin> mListOderProductAdmin) {
        this.mContext = context;
        this.mListOderProductAdmin = mListOderProductAdmin;
        this.mListOderProductAdminOld = mListOderProductAdmin;
    }


    //


    @NonNull
    @Override
    public OderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.quan_li_san_pham_custom,
                parent, false);
        return new OderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OderViewHolder holder, int position) {
       ProductAdmin oderProductAdmin = mListOderProductAdmin.get(position);
        if (oderProductAdmin == null) {
            return;
        }

        Bitmap bitmap = BitmapFactory.decodeByteArray(oderProductAdmin.getImageProduct().get(0).getImageResource(), 0, oderProductAdmin.getImageProduct().get(0).getImageResource().length);
        holder.imgProduct.setImageBitmap(bitmap);
//        holder.imgProduct.setImageResource(oderProductAdmin.getImageProduct().get(0).getImageResource());
        holder.tvTxtProductName.setText(oderProductAdmin.getProductName());
        holder.tvTxtId.setText(oderProductAdmin.getIdProc());
        holder.tvTxtBrand.setText(oderProductAdmin.getBrand());
        holder.tvOderTxtPrice.setText(oderProductAdmin.getPrice() + "");
        holder.tvTxtSize.setText(oderProductAdmin.getSize() + "");
        holder.tvTxtColor.setText(oderProductAdmin.getColor());
        holder.tvOderTxtAmount.setText(oderProductAdmin.getAmount() + "");
        holder.tvTxtDescription.setText(oderProductAdmin.getDescription());
        //
        //
        holder.layoutCustomItem.setOnClickListener(new View.OnClickListener() {
            @Override
            //bắt sự kiện click item chuyển đến trang editProduct.java
            public void onClick(View view) {

                onClickGoToEditOderProduct(oderProductAdmin);
            }

            private void onClickGoToEditOderProduct(ProductAdmin oderProductAdmin) {
                Intent intent = new Intent(mContext, EditProduct.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("object_product", oderProductAdmin);
                intent.putExtras(bundle);
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        if (mListOderProductAdmin != null) {
            return mListOderProductAdmin.size();
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
        private TextView tvTxtId;


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
            tvTxtDescription = itemView.findViewById(R.id.tv_oder_txt_des);
            tvTxtId = itemView.findViewById(R.id.tv_txt_id);

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
                    mListOderProductAdmin = mListOderProductAdminOld;
                } else {
                    ArrayList<ProductAdmin> productAdmins = new ArrayList<>();
                    for (ProductAdmin pro : mListOderProductAdmin) {
                        if (pro.getProductName().toLowerCase().contains(strSearch.toLowerCase())) {
                            productAdmins.add(pro);
                        }

                    }
                    mListOderProductAdmin = productAdmins;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = mListOderProductAdmin;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mListOderProductAdmin = (ArrayList<ProductAdmin>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

}
