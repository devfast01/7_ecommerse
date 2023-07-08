package com.example.yedi_tilsim__.simpleJson;


import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.example.yedi_tilsim__.R;

import java.util.ArrayList;

public class RecyclerViewAdapter_simple extends RecyclerView.Adapter<RecyclerViewAdapter_simple.RecyclerViewHolder> {

    // creating a variable for our array list and context.
    private ArrayList<simpleData> courseDataArrayList;
    private Context mcontext;

    // creating a constructor class.
    public RecyclerViewAdapter_simple(ArrayList<simpleData> recyclerDataArrayList, Context mcontext) {
        this.courseDataArrayList = recyclerDataArrayList;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate Layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        return new RecyclerViewHolder(view);
    }

    @SuppressLint("CheckResult")
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        // Set the data to textview from our modal class.
        simpleData modal = courseDataArrayList.get(position);
        holder.courseNameTV.setText(modal.getId());
        holder.courseTracksTV.setText(modal.getDescription());
        holder.courseModeTV.setText(modal.getName());
//        holder.release.setText(moviesList.get(position).getMoreDetails().getRelease());
//        holder.ratingBar.setRating(Float.parseFloat(String.valueOf(moviesList.get(position).getRating())));
//        Glide.with((mContext)).load(moviesList.get(position).getPoster()).into(holder.img);
//        Glide.with((mcontext)).load(courseDataArrayList.get(position).getProducts_images().get(0)).into(holder.courseIV);
        String imageUrl = String.valueOf(modal.getProducts_images().get(0));
        //            String imageUrl = product.getProductImage().getImageUrl();

        Glide.with(holder.itemView.getContext())
                .load(imageUrl)
                .apply(RequestOptions.placeholderOf(R.drawable.pizza_2)) // Show a placeholder while loading
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(holder.courseIV);
        holder.courseIV.setVisibility(View.VISIBLE); // Show the ImageView

    }

    @Override
    public int getItemCount() {
        // this method returns the size of recyclerview
        return courseDataArrayList.size();
    }

    // View Holder Class to handle Recycler View.
    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        // creating variables for our views.
        private TextView courseNameTV, courseModeTV, courseTracksTV;
        private ImageView courseIV;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our views with their ids.
            courseNameTV = itemView.findViewById(R.id.idTVCourseName);
            courseModeTV = itemView.findViewById(R.id.idTVBatch);
            courseTracksTV = itemView.findViewById(R.id.idTVTracks);
            courseIV = itemView.findViewById(R.id.idIVCourse);
        }
    }
}