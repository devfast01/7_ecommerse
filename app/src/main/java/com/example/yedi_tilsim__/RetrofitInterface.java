package com.example.yedi_tilsim__;

import com.example.yedi_tilsim__.Model.JSONResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitInterface {

    //    @GET("products")
    @GET("v3/6fec982d-23e1-4230-96ad-f2e75c87e696")
    Call<JSONResponse> getProducts();

}
