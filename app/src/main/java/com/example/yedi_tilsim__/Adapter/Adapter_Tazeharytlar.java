package com.example.yedi_tilsim__.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.yedi_tilsim__.Model.Model_TazeHarytlar;
import com.example.yedi_tilsim__.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter_Tazeharytlar extends RecyclerView.Adapter<Adapter_Tazeharytlar.PlateViewHolder>{

    private List<Model_TazeHarytlar> plateModelList;
    private Context context;

    public Adapter_Tazeharytlar(List<Model_TazeHarytlar> plateModelList, Context context) {
        this.plateModelList = plateModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public PlateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewGroup) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_taze_harytlar,parent, false );
        return new PlateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlateViewHolder holder, int position) {
        Model_TazeHarytlar plateModel = plateModelList.get(position);
        Glide.with(context).load(plateModel.getPlate_img()).into(holder.plateImg);
    }

    @Override
    public int getItemCount() {
        return plateModelList.size();
    }

    public class PlateViewHolder extends RecyclerView.ViewHolder {
        private ImageView plateImg;
        public PlateViewHolder(@NonNull View itemView) {
            super(itemView);
            plateImg = (ImageView) itemView.findViewById(R.id.imageView2);
        }
    }
}
