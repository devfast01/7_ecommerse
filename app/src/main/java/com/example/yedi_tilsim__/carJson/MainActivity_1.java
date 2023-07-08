package com.example.yedi_tilsim__.carJson;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yedi_tilsim__.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity_1 extends AppCompatActivity {

    ArrayList<CarsModel> carsModels=new ArrayList<>();
    private CarsAdapter carsAdapter;
    private RecyclerView cars_recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_1);

        cars_recyclerview=(RecyclerView)findViewById(R.id.cars_recyclerview);
        cars_recyclerview.setLayoutManager(new LinearLayoutManager(this));

        getCarsResponse();

    }

    private void getCarsResponse() {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://navneet7k.github.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestInteface requestInteface=retrofit.create(RequestInteface.class);
        Call<List<CarsModel>> call=requestInteface.getCarsJson();

        call.enqueue(new Callback<List<CarsModel>>() {
            @Override
            public void onResponse(Call<List<CarsModel>> call, Response<List<CarsModel>> response) {
                carsModels=new ArrayList<>(response.body());
                carsAdapter=new CarsAdapter(MainActivity_1.this,carsModels);
                cars_recyclerview.setAdapter(carsAdapter);
                Toast.makeText(MainActivity_1.this,"Success",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<CarsModel>> call, Throwable t) {
                Toast.makeText(MainActivity_1.this,"Failed",Toast.LENGTH_SHORT).show();
            }
        });
    }

}
