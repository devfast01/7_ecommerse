package com.example.yedi_tilsim__.volley;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yedi_tilsim__.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductAdapter_v extends RecyclerView.Adapter<ProductAdapter_v.ViewHolder> {
    private List<Product_volley> productList;
    private Context context;

    public ProductAdapter_v(List<Product_volley> productList, Context context) {
        this.productList = productList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.volley_item_product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product_volley product = productList.get(position);

             if (product == null) {
            // Here I'm using Picasso library to load the image from URL, make sure to add the Picasso dependency to your build.gradle file
            Picasso.get().load(product.getProductImages().get(0).getImgUrl()).into(holder.ivProductImage);

            return;
        }
        holder.tvProductName.setText(product.getName());
        holder.tvProductDescription.setText(product.getDescription());
        holder.tvProductPrice.setText(String.valueOf(product.getPrice()));

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvProductName;
        TextView tvProductDescription;
        TextView tvProductPrice;
        ImageView ivProductImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvProductName = itemView.findViewById(R.id.tv_product_name);
            tvProductDescription = itemView.findViewById(R.id.tv_product_description);
            tvProductPrice = itemView.findViewById(R.id.tv_product_price);
            ivProductImage = itemView.findViewById(R.id.iv_product_image);
        }
    }
}