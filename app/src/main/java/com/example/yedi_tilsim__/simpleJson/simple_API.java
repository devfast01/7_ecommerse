package com.example.yedi_tilsim__.simpleJson;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface simple_API {
//    // as we are making get request so we are displaying
//    // GET as annotation.
//    // and inside we are passing last parameter for our url.
//    @GET("product/all")
//
//    // as we are calling data from array so we are calling
//    // it with array list and naming that method as getAllCourses();
//    Call<ArrayList<RecyclerData>> getAllCourses();

    String JSONURL = "http://192.168.0.103:8091/public/products/2.jpg";

    @GET("product/all")
    Call<List<simpleData>> getAllCourses();
}
