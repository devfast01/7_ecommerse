package com.example.yedi_tilsim__.GPT_json;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.yedi_tilsim__.R;
import com.example.yedi_tilsim__.nestedJson.Movie;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class main_page extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProductAdapter productAdapter;

    private List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        recyclerView = findViewById(R.id.recyclerView);
        productList = new ArrayList<>();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.103:8091/") // Replace with your JSON endpoint URL
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ProductService productService = retrofit.create(ProductService.class);

        Call<ImageResponse> call = productService.getProducts();

        call.enqueue(new Callback<ImageResponse>() {
            @Override
            public void onResponse(Call<ImageResponse> call, Response<ImageResponse> response) {
                ImageResponse imageResponse = response.body();
                if (imageResponse != null) {
                    Toast.makeText(main_page.this, "success", Toast.LENGTH_SHORT).show();
                    productList = new ArrayList<>(Arrays.asList(imageResponse.getProducts_images()));
                    Log.i("onSuccess", String.valueOf(productList));

                    PutDataIntoRecycelerView(productList);

                } else {
                    Toast.makeText(main_page.this, "s000000", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ImageResponse> call, Throwable t) {
                // Handle failure
                Toast.makeText(main_page.this, "Faild to get data", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void PutDataIntoRecycelerView(List<Product> productList) {
        productAdapter = new ProductAdapter(this, productList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(productAdapter);

    }
}