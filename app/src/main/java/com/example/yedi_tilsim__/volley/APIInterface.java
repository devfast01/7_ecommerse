package com.example.yedi_tilsim__.volley;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIInterface {
    String BASE_URL = "http://192.168.0.103:8091/product/all"; // Add your API base URL here

    @GET("product/all")
    Call<List<Product_volley>> getProducts();

    @POST("add_to_cart") // Replace "add_to_cart" with the appropriate endpoint for adding a product to the cart
    Call<Void> addToCart(/* Add necessary parameters here to identify the product to add to the cart */);
}