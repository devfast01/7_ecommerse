package com.example.yedi_tilsim__.geeks_json;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.example.yedi_tilsim__.R;
import com.example.yedi_tilsim__.simpleJson.ProductImage_simple;

public class geeks_json extends AppCompatActivity {

    // creating a variable for recycler view,
    // array list and adapter class.
    private RecyclerView courseRV;
    private ArrayList<RecyclerData> recyclerDataArrayList;
    private RecyclerViewAdapter recyclerViewAdapter;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geeks_json);

        // initializing our variables.
        courseRV = findViewById(R.id.idRVCourse);
        progressBar = findViewById(R.id.idPBLoading);

        // creating new array list.
        recyclerDataArrayList = new ArrayList<>();

        // calling a method to
        // get all the courses.
        getAllCourses();
    }

    private void getAllCourses() {
        // on below line we are creating a retrofit
        // builder and passing our base url
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.103:8091/")
                // on below line we are calling add
                // Converter factory as Gson converter factory.
                .addConverterFactory(GsonConverterFactory.create())
                // at last we are building our retrofit builder.
                .build();
        // below line is to create an instance for our retrofit api class.
        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);

        // on below line we are calling a method to get all the courses from API.
        Call<List<RecyclerData>> call = retrofitAPI.getAllProducts();

        // on below line we are calling method to enqueue and calling
        // all the data from array list.
        call.enqueue(new Callback<List<RecyclerData>>() {
            @Override
            public void onResponse(Call<List<RecyclerData>> call, Response<List<RecyclerData>> response) {
                // inside on response method we are checking
                // if the response is success or not.
                if (response.isSuccessful()) {
                    List<RecyclerData> products = response.body();
//                    if (products != null && !products.isEmpty()) {
//                        RecyclerData product = products.get(0);
//                        List<ProductImage> images = product.getProducts_images();
//                        if (images != null && !images.isEmpty()) {
//                            ProductImage image = images.get(1);
//                            String imgUrl = image.getImg_url();
//                            System.out.println("imgUrl: " + imgUrl);
//                        }
//                        }
                    // on successful we are hiding our progressbar.
                    progressBar.setVisibility(View.GONE);

                    // below line is to add our data from api to our array list.
                    recyclerDataArrayList = (ArrayList<RecyclerData>) response.body();

                    // below line we are running a loop to add data to our adapter class.
                    for (int i = 0; i < recyclerDataArrayList.size(); i++) {
                        recyclerViewAdapter = new RecyclerViewAdapter(recyclerDataArrayList, geeks_json.this);

                        // below line is to set layout manager for our recycler view.
                        LinearLayoutManager manager = new LinearLayoutManager(geeks_json.this);

                        // setting layout manager for our recycler view.
                        courseRV.setLayoutManager(manager);

                        // below line is to set adapter to our recycler view.
                        courseRV.setAdapter(recyclerViewAdapter);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<RecyclerData>> call, Throwable t) {
                // in the method of on failure we are displaying a
                // toast message for fail to get data.
                Toast.makeText(geeks_json.this, "Fail to get data", Toast.LENGTH_SHORT).show();
            }
        });
    }
}