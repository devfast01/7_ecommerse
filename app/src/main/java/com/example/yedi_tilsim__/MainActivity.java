package com.example.yedi_tilsim__;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.example.yedi_tilsim__.Adapter.Adapter_Arzanladyslar;
import com.example.yedi_tilsim__.Adapter.Adapter_Tazeharytlar;
import com.example.yedi_tilsim__.Adapter.SliderAdapter_bildirisler;
import com.example.yedi_tilsim__.Model.JSONResponse;
import com.example.yedi_tilsim__.Model.Model_Arzanladyslar;
import com.example.yedi_tilsim__.Model.Model_BildirislerSlider;
import com.example.yedi_tilsim__.Model.Model_TazeHarytlar;
import com.example.yedi_tilsim__.barlag.Adaptery;
import com.example.yedi_tilsim__.barlag.BarlagActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.JsonArray;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.IndicatorView.draw.controller.DrawController;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    // private static final String BASE_URL = "https://run.mocky.io/";

    List<Model_Arzanladyslar> model_arzanladyslar;
    RecyclerView recyclerViewArzanladyslar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);


        recyclerViewArzanladyslar = findViewById(R.id.recyclerViewArzanladyslar);
        model_arzanladyslar = new ArrayList<>();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://run.mocky.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitInterface retrofitInterface = retrofit.create((RetrofitInterface.class));

        Call<JSONResponse> call = retrofitInterface.getProducts();
        call.enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Call<JSONResponse> call, @NonNull Response<JSONResponse> response) {

                JSONResponse jsonResponse = response.body() ;
                if (jsonResponse != null) {
                    model_arzanladyslar = new ArrayList<>(Arrays.asList(jsonResponse.getData()));
                    Toast.makeText(MainActivity.this, "Succesfully", Toast.LENGTH_SHORT).show();
                    PutDataIntoRecycelerView(model_arzanladyslar);
                } else {
                    Toast.makeText(MainActivity.this, "00000000000", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Faild", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void PutDataIntoRecycelerView(List<Model_Arzanladyslar> model_arzanladyslar) {
        Adapter_Arzanladyslar adapter_arzanladyslar = new Adapter_Arzanladyslar(this,model_arzanladyslar);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerViewArzanladyslar.setLayoutManager(new GridLayoutManager(this,3));// RecycleView 3 setire bolinya
        // recyclerViewArzanladyslar.setLayoutManager(layoutManager);
        recyclerViewArzanladyslar.setAdapter(adapter_arzanladyslar);

    }
}