package com.example.yedi_tilsim__.GPT_json;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductService {

    @GET("product/all") // Replace with your API endpoint for fetching product data
    Call<ImageResponse> getProducts();

}
