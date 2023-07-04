package com.example.yedi_tilsim__.barlag;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieApi {

   // @GET("v3/d862875d-7960-498c-b538-a1f3ffea1b9a")
    //@GET("v3/c38ef967-0c43-4cbb-b4a0-1f330e2d33b7")
   // @GET("v3/075c35e3-48bf-4ff7-9f46-65014a8a316e")  // nested
    //@GET("v3/6fec982d-23e1-4230-96ad-f2e75c87e696")
    @GET("v3/f5ddfee7-e455-4408-8de0-fecef2442975")  // nested
    Call<JSONResponse> getMovies();

}
