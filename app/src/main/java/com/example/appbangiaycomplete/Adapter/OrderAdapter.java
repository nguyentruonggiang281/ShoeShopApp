package com.example.appbangiaycomplete.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbangiaycomplete.Activity.EditOrder;
import com.example.appbangiaycomplete.Order;
import com.example.appbangiaycomplete.R;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ProductViewHolder> implements Filterable {

    private List<Order> mListProduct;
    private List<Order> mListOderProductOld;
    private Context mContext;
    View view;
    private OnItemClickListener listener;


    // interface bắt sự kien
    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener clickListener) {
        listener = clickListener;


    }


    //    public void setData(List<Order> list) {
//        this.mListProduct = list;
//        notifyDataSetChanged();
//    }
    public OrderAdapter(Context context, List<Order> mListProduct) {
        this.mListProduct = mListProduct;
        this.mContext = context;
        this.mListOderProductOld = mListProduct;

    }
//
//    @Override
//    public int getCount() {
//        return mListProduct.size();
//    }
//
//    @Override
//    public Object getItem(int i) {
//        return null;
//    }
//
//    @Override
//    public long getItemId(int i) {
//        return 0;
//    }
//
//    @Override
//    public View getView(final int position, View v, ViewGroup viewGroup) {
//        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//       View  view   = inflater.inflate(layout , null);
//        imgUser = view.findViewById(R.id.image_product);
//        tvUserName = view.findViewById(R.id.tv_user_name);
//        tvIdProduct = view.findViewById(R.id.tvTxt_id_product);
//        tvAmount = view.findViewById(R.id.tvTxt_amount);
//        tvTotalCost = view.findViewById(R.id.tvTxt_total_cost);
//        tvAddress = view.findViewById(R.id.tvTxt_address);
//        tvState = view.findViewById(R.id.tvTxt_state);
//        btnConfirm = view.findViewById(R.id.btn_confirm);
//        btnCancel = view.findViewById(R.id.btn_cancel);
//        layoutCustomItem = view.findViewById(R.id.quan_ly_san_pham_custom);
//        final Order order = mListProduct.get(position);
////
//        tvUserName.setText(order.getUserName());
//        tvIdProduct.setText(order.getIdProdDetails());
//        tvAmount.setText(order.getAmountOrder() + "");
//        tvTotalCost.setText(order.getTotalCost() + "");
//        tvAddress.setText(order.getDelivery());
//        tvState.setText(order.getState());
//        btnCancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mContext.Cancel(position);
//            }
//        });
//        return view;
//    }

    //


    //    public ProductAdapter pro(ProductAdapter adapter) {
//        this.adapter = adapter;
//        return this;
//    }
//    public void setData(List<Order> list) {
//        this.mListProduct = list;
//        notifyDataSetChanged();
//    }

    //    public ProductAdapter(QuanLySanPham context, List<Order> mListProduct) {
//        this.mListProduct = mListProduct;
//        this.mContext = context;
//    }
//
    @NonNull
    @Override
    public OrderAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.quan_li_don_hang_custom, parent, false);

        return new ProductViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Order oder = mListProduct.get(position);
        if (oder == null) {
            return;
        }
        holder.tvUserName.setText(oder.getUserName());
        holder.tvIdProduct.setText(oder.getIdProdDetails());
        holder.tvAmount.setText(oder.getAmountOrder() + "");
        holder.tvTotalCost.setText(oder.getTotalCost() + "");
        holder.tvAddress.setText(oder.getDelivery());
        holder.tvState.setText(oder.getState());
//
//    event  button cancel
//        holder.btnCancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                adapter.notifyDataSetChanged();
//            }
//        });
//
//        Order order = mListProduct.get(position);
//        String s = order.getIdProdDetails();
//    event  button confirm
//        holder.btnConfirm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//            }
//        });

        //


        //
        holder.layoutCustomItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                oncLickGoToEditProduct(oder);
            }

            private void oncLickGoToEditProduct(Order order) {
                Intent intent = new Intent(mContext, EditOrder.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("object_product", order);
                intent.putExtras(bundle);
                mContext.startActivity(intent);

            }
        });
//dấu ngoac â
    }

    //
    @Override
    public int getItemCount() {
        if (mListProduct != null) {
            return mListProduct.size();
        }
        return 0;
    }


    public class ProductViewHolder extends RecyclerView.ViewHolder {
        private TextView tvUserName;
        private TextView tvIdProduct;
        private TextView tvAmount;
        private TextView tvTotalCost;
        private TextView tvAddress;
        private TextView tvState;
        private Button btnConfirm, btnCancel;
        private CircleImageView imgUser;
        private RelativeLayout layoutCustomItem;

        private OrderAdapter adapter;

        public ProductViewHolder(View itemView, OnItemClickListener listener) {
            super(itemView);
            imgUser = itemView.findViewById(R.id.image_product);
            tvUserName = itemView.findViewById(R.id.tv_user_name);
            tvIdProduct = itemView.findViewById(R.id.tvTxt_id_product);
            tvAmount = itemView.findViewById(R.id.tvTxt_amount);
            tvTotalCost = itemView.findViewById(R.id.tvTxt_total_cost);
            tvAddress = itemView.findViewById(R.id.tvTxt_address);
            tvState = itemView.findViewById(R.id.tvTxt_state);
            btnConfirm = itemView.findViewById(R.id.btn_confirm);
            btnCancel = itemView.findViewById(R.id.btn_cancel);
            layoutCustomItem = itemView.findViewById(R.id.quan_ly_san_pham_custom);
//test 02
//            itemView.findViewById(R.id.btn_cancel).setOnClickListener(view1 -> {
//                adapter.mListProduct.remove(getAbsoluteAdapterPosition());
//                adapter.notifyItemRemoved(getAbsoluteAdapterPosition());
//            });
            btnCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(getAdapterPosition());
                }
            });
        }

    }

    //test 1
//    public ProductAdapter productAdapter(ProductAdapter adapter) {
//        this.adapter = adapter;
//        return this;
//    }
//
//
//        //event  button confirm
//        btnCancel.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            Toast.makeText(QuanLySanPham.this, "đã chọn ", Toast.LENGTH_SHORT).show();
//        }
//    });
//    //event  button confirm
//        btnConfirm.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            Toast.makeText(QuanLySanPham.this, "đã chọn ", Toast.LENGTH_SHORT).show();
//
//        }
//    });
//    class ProductViewHolder extends RecyclerView.ViewHolder {
//        Button btnCancel;
//        private ProductAdapter adapter;
//
//        public DemoProductViewHolder(@NonNull View itemView) {
//            super(itemView);
//            itemView.findViewById(R.id.btn_cancel).setOnClickListener(view1 -> {
//                adapter.mListProduct.remove(getAbsoluteAdapterPosition());
//                adapter.notifyItemRemoved(getAbsoluteAdapterPosition());
//            });
//
//        }
//
//        public ProductViewHolder oder(ProductAdapter adapter) {
//            this.adapter = adapter;
//            return this;
//        }
    // function search
    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String strSearch = charSequence.toString();
                if (strSearch.isEmpty()) {
                    mListProduct = mListOderProductOld;
                } else {
                    List<Order> products = new ArrayList<>();
                    for (Order oder  : mListProduct) {
                        if (oder.getUserName().toLowerCase().contains(strSearch.toLowerCase())) {
                            products.add(oder);
                        }

                    }
                    mListProduct = products;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = mListProduct;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mListProduct = (List<Order>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }
}



