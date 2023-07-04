package com.example.yedi_tilsim__.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.yedi_tilsim__.Model.Model_Arzanladyslar;
import com.example.yedi_tilsim__.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter_Arzanladyslar extends RecyclerView.Adapter<Adapter_Arzanladyslar.ViewHolder> {

    private List<Model_Arzanladyslar> Model_Arzanladyslar = new ArrayList<>();

    private final Context context;

    public Adapter_Arzanladyslar(Context context, List<Model_Arzanladyslar> Model_Arzanladyslar) {
        this.Model_Arzanladyslar = Model_Arzanladyslar;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_arzanladyslar, parent, false);
        return new ViewHolder(inflate);
    }

    @SuppressLint("CheckResult")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.description.setText(Model_Arzanladyslar.get(position).getDescription());
        holder.id.setText(String.valueOf(Model_Arzanladyslar.get(position).getId()));
        holder.price.setText(String.valueOf(Model_Arzanladyslar.get(position).getPrice()));

        Model_Arzanladyslar plateModel = Model_Arzanladyslar.get(position);
    }

    @Override
    public int getItemCount() {
        return Model_Arzanladyslar.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView description, id, price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            description = itemView.findViewById(R.id.descriptionArzanladyslar);
            price = itemView.findViewById(R.id.dataArzanladyslar);
            id = itemView.findViewById(R.id.seenCounterArzanladyslar);
        }
    }
}
