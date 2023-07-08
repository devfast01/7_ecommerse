package com.example.yedi_tilsim__.nestedJson;

import com.google.gson.annotations.SerializedName;

public class Movie {

    public Movie(String id, String title, String poster, float rating, MoreDetails moreDetails) {
        this.id = id;
        this.title = title;
        this.poster = poster;
        this.rating = rating;
        this.moreDetails = moreDetails;
    }

    private String id;
    private String title;
    private String poster;
    private float rating;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public MoreDetails getMoreDetails() {
        return moreDetails;
    }

    public void setMoreDetails(MoreDetails moreDetails) {
        this.moreDetails = moreDetails;
    }

    @SerializedName("Details")
    private MoreDetails moreDetails;

}
