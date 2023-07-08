package com.example.yedi_tilsim__.demonuts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yedi_tilsim__.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class demonuts_main extends AppCompatActivity {


    private RetrofitAdapter retrofitAdapter;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private TextView textView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demonuts_main);

        recyclerView = findViewById(R.id.recycler);
        progressBar = findViewById(R.id.idPBLoading);
        textView = findViewById(R.id.txtJson);

        fetchJSON();

    }

    private void fetchJSON() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RecyclerInterface.JSONURL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        RecyclerInterface api = retrofit.create(RecyclerInterface.class);

        Call<String> call = api.getString();

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
//                Log.i("Responsestring", response.body().toString());
                if (response.isSuccessful()) {

                    if (response.body() != null) {

                        //Log.i("onSuccess", String.valueOf(response));
                        Toast.makeText(demonuts_main.this, "Success", Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);

                        String jsonresponse = response.body().toString();

                        writeRecycler(jsonresponse);

                    } else {
                        Log.i("onEmptyResponse", "Returned empty response");//Toast.makeText(getContext(),"Nothing returned",Toast.LENGTH_LONG).show();
                        Toast.makeText(demonuts_main.this, "Empty response", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }


    private void writeRecycler(String response) {
//        textView.setText(response);
//        Log.i("onSuccess", response);

        try {

            ArrayList<ModelRecycler> modelRecyclerArrayList = new ArrayList<>();

//            JSONArray dataArray = obj.getJSONArray("");
            JSONArray jsonArray = new JSONArray(response);
            System.out.println("imgUrl: " + jsonArray);

//            System.out.println("imgUrl: " + dataArray);

            for (int i = 0; i < jsonArray.length(); i++) {

                ModelRecycler modelRecycler = new ModelRecycler();
                JSONObject dataobj = jsonArray.getJSONObject(i);
//                System.out.println("imgUrl: " + dataobj);

//                modelRecycler.setImgURL(dataobj.getString("imgURL"));
                modelRecycler.setName(dataobj.getString("name"));
                modelRecycler.setCountry(dataobj.getString("description"));
                modelRecycler.setCity(dataobj.getString("product_sku"));

                JSONArray imagesArray = dataobj.getJSONArray("products_images");
                JSONObject image = imagesArray.getJSONObject(0);
                String imageUrl = image.getString("img_url");
                modelRecycler.setImgURL(imageUrl);

                modelRecyclerArrayList.add(modelRecycler);

            }

            retrofitAdapter = new RetrofitAdapter(this, modelRecyclerArrayList);
            recyclerView.setAdapter(retrofitAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

}