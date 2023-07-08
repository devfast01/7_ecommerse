package com.example.yedi_tilsim__.nestedJson;

public class JSONResponse {
    public Movie[] getMoviz() {
        return data;
    }

    public void setMoviz(Movie[] moviz) {
        this.data = moviz;
    }

    private Movie[] data;

}
