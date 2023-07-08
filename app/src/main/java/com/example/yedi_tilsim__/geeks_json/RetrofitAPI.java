package com.example.yedi_tilsim__.geeks_json;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitAPI {
    @GET("product/all")
    Call<List<RecyclerData>> getAllProducts();
}
