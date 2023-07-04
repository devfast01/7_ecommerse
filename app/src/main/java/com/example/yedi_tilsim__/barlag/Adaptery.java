package com.example.yedi_tilsim__.barlag;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.yedi_tilsim__.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adaptery extends RecyclerView.Adapter<Adaptery.MyViewHolder> {

    private final Context mContext;
    private List<Movie> moviesList;

    public Adaptery(Context mContext, List<Movie> moviesList) {
        this.mContext = mContext;
        this.moviesList = moviesList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        v = layoutInflater.inflate(R.layout.movie_item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.title.setText(moviesList.get(position).getTitle());
        // the trick : Getting data from the nested json object;
        holder.duration.setText(moviesList.get(position).getMoreDetails().getDuration());
        holder.category.setText(moviesList.get(position).getMoreDetails().getCategory());
        holder.release.setText(moviesList.get(position).getMoreDetails().getRelease());
        holder.ratingBar.setRating(Float.parseFloat(String.valueOf(moviesList.get(position).getRating())));
        Glide.with((mContext)).load(moviesList.get(position).getPoster()).into(holder.img);

        // Adding Glide library to display the image
//        Movie.ImageDetails imageDetails = ImageDetails.get(position);
//        Glide.with((mContext)).load(imageDetails.getImgUrl()).into(holder.img);
        // Setting ratingbar value
//        holder.ratingBar.setRating(moviesList.get((position).getM));


//        holder.title.setText(moviesList.get(position).getTitle());
//        // the trick : Getting data from the nested json object;
//        holder.duration.setText(moviesList.get(position).getMoreDetails().getDuration());
//        holder.category.setText(moviesList.get(position).getMoreDetails().getCategory());
//        holder.release.setText(moviesList.get(position).getMoreDetails().getRelease());
//        // Adding Glide library to display the image
//        Glide.with((mContext)).load(moviesList.get(position).getPoster()).into(holder.img);
//        // Setting ratingbar value
//        holder.ratingBar.setRating(Float.parseFloat(String.valueOf(moviesList.get(position).getRating())));

    }

    @Override
    public int getItemCount() {
       // if(moviesList==null) return 0;
        return moviesList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        TextView duration;
        ImageView img;

        RatingBar ratingBar;
        TextView category;
        TextView release;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.Movietitle);
            duration = itemView.findViewById(R.id.id);
            img = itemView.findViewById(R.id.imageMovie);
            ratingBar = itemView.findViewById(R.id.ratingBar);
            category = itemView.findViewById(R.id.MovieCategory);
            release = itemView.findViewById(R.id.MovieRelease);

        }
    }

}
