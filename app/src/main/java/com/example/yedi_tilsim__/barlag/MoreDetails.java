package com.example.yedi_tilsim__.barlag;

public class MoreDetails {

    public String getRelease() {
        return release;
    }

    public String getCategory() {
        return category;
    }

    public String getDuration() {
        return duration;
    }

    public MoreDetails(String release, String category, String duration) {
        this.release = release;
        this.category = category;
        this.duration = duration;
    }

    private String release;
    private String category;
    private String duration;

}
