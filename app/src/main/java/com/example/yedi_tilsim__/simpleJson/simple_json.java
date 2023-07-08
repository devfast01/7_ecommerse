package com.example.yedi_tilsim__.simpleJson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.yedi_tilsim__.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class simple_json extends AppCompatActivity {


    // creating a variable for recycler view,
    // array list and adapter class.
    private RecyclerView courseRV;
    private ArrayList<simpleData> recyclerDataArrayList;
    private RecyclerViewAdapter_simple recyclerViewAdapter;
    private ProgressBar progressBar;
    private ImageView simple;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_json);

        // initializing our variables.
        courseRV = findViewById(R.id.idRVCourse);
        progressBar = findViewById(R.id.idPBLoading);
        simple = findViewById(R.id.simple);

        // creating new array list.
        recyclerDataArrayList = new ArrayList<>();

        // calling a method to
        // get all the courses.
        getAllCourses();
    }

    private void getAllCourses() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.103:8091/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        simple_API retrofitAPI = retrofit.create(simple_API.class);

        // on below line we are calling a method to get all the courses from API.
        Call<List<simpleData>> call = retrofitAPI.getAllCourses();


        call.enqueue(new Callback<List<simpleData>>() {
            @Override
            public void onResponse(Call<List<simpleData>> call, Response<List<simpleData>> response) {

                if (response.isSuccessful()) {
                    // on successful we are hiding our progressbar.
                    progressBar.setVisibility(View.GONE);
                    List<simpleData> products = response.body();

                    if (products != null && !products.isEmpty()) {
                        simpleData product = products.get(0);
                        List<ProductImage_simple> images = product.getProducts_images();
                        if (images != null && !images.isEmpty()) {
                            ProductImage_simple image = images.get(0);
                            String imgUrl = image.getImg_url();
                            Picasso.get().load(imgUrl).into(simple);

                            System.out.println("imgUrl: " + imgUrl);
                        }
                    }

                }
            }

            @Override
            public void onFailure(Call<List<simpleData>> call, Throwable t) {
                Toast.makeText(simple_json.this, "Fail to get data", Toast.LENGTH_SHORT).show();
            }
        });
    }


}