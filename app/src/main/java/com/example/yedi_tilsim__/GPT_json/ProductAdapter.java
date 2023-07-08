package com.example.yedi_tilsim__.GPT_json;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.example.yedi_tilsim__.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private List<Product> productList = new ArrayList<>();
    private final Context mContext;

    public ProductAdapter(Context mContext, List<Product> productList) {
        this.mContext = mContext;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = productList.get(position);

        holder.textViewName.setText(product.getName());
        holder.textViewDescription.setText(product.getDescription());
        holder.textViewPrice.setText(String.valueOf(product.getPrice()));
        holder.textViewQuantity.setText(String.valueOf(product.getQuantity()));
        Glide.with((mContext)).load(productList.get(position).getProductImage().getImageUrl()).into(holder.imageViewProduct);


        // Load the image using Glide
//        if (product.getProductImage() != null && product.getProductImage().getImageUrl() != null && !product.getProductImage().getImageUrl().isEmpty()) {
//            String imageUrl = product.getProductImage().getImageUrl();
//            Glide.with(holder.itemView.getContext())
//                    .load(imageUrl)
//                    .apply(RequestOptions.placeholderOf(R.drawable.pizza_2)) // Show a placeholder while loading
//                    .transition(DrawableTransitionOptions.withCrossFade())
//                    .into(holder.imageViewProduct);
//            holder.imageViewProduct.setVisibility(View.VISIBLE); // Show the ImageView
//        } else {
//            holder.imageViewProduct.setVisibility(View.GONE); // Hide the ImageView
//        }

        // Load the image using Glide
//        if (product.getProductImage() != null) {
//            String imageUrl = product.getProductImage().getImageUrl();
//            Glide.with(holder.itemView.getContext())
//                    .load(imageUrl)
//                    .apply(RequestOptions.placeholderOf(R.drawable.arzan_tm)) // Show a placeholder while loading
//                    .transition(DrawableTransitionOptions.withCrossFade())
//                    .into(holder.imageViewProduct);
//        } else {
//            // Handle case when image is not available
//            Glide.with(holder.itemView.getContext())
//                    .load(R.drawable.pizza_2)
//                    .into(holder.imageViewProduct);
//        }
    }


    @Override
    public int getItemCount() {
        return productList.size();
    }

    static class ProductViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewProduct;
        TextView textViewName;
        TextView textViewDescription;
        TextView textViewPrice;
        TextView textViewQuantity;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewProduct = itemView.findViewById(R.id.imageViewProduct);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewDescription = itemView.findViewById(R.id.textViewDescription);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            textViewQuantity = itemView.findViewById(R.id.textViewQuantity);
        }
    }
}