package com.example.yedi_tilsim__.demonuts;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RecyclerInterface {
//    String JSONURL = "https://demonuts.com/Demonuts/JsonTest/Tennis/";
//    @GET("json_parsing.php")
//    Call<String> getString();

//   String JSONURL = "https://run.mocky.io/";
//    @GET("v3/527bc5f1-28a6-4dee-9297-a468d6feeb04")

//    String JSONURL = "http://192.168.0.103:8091/";
//    @GET("product/all")
//    Call<String> getString();

//    String JSONURL = "http://run.mocky.io/";
//    @GET("v3/0293650d-e33f-4eb1-9a08-727f51cf4b94")
//    Call<String> getString();

    String JSONURL = "http://run.mocky.io/";
    @GET("v3/4b4b3ddc-f140-43ea-8fc0-707644e2af4a")
    Call<String> getString();
}
