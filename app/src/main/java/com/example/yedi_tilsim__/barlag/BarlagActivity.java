package com.example.yedi_tilsim__.barlag;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.annotation.SuppressLint;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yedi_tilsim__.Didar_retro.RetroModel;
import com.example.yedi_tilsim__.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BarlagActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Movie> movieList;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barlag);

        recyclerView = findViewById(R.id.MoviRecycleView);
        movieList = new ArrayList<>();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://run.mocky.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MovieApi movieApi = retrofit.create((MovieApi.class));

        Call<JSONResponse> call = movieApi.getMovies();

        call.enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Call<JSONResponse> call, @NonNull Response<JSONResponse> response) {

                JSONResponse jsonResponse = response.body();
                if (jsonResponse != null) {
                    movieList = new ArrayList<>(Arrays.asList(jsonResponse.getMoviz()));
                    Toast.makeText(BarlagActivity.this, "Succesfully", Toast.LENGTH_SHORT).show();
                    PutDataIntoRecycelerView(movieList);
                }else  {
                    Toast.makeText(BarlagActivity.this, "00000000000", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {
                Toast.makeText(BarlagActivity.this, "Faild", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void PutDataIntoRecycelerView(List<Movie> movieList) {
        Adaptery adaptery = new Adaptery(this,movieList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adaptery);
    }
}