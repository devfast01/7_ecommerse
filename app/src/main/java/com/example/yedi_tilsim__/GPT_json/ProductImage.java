package com.example.yedi_tilsim__.GPT_json;

import com.google.gson.annotations.SerializedName;

public class ProductImage {
    @SerializedName("img_url")
    private String img_url;

    public String getImageUrl() {
        return img_url;
    }
}
