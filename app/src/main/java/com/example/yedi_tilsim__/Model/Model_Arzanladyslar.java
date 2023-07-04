package com.example.yedi_tilsim__.Model;

public class Model_Arzanladyslar {

    private String id;
    private String description;
    private String price;


    public Model_Arzanladyslar(String description, String id, String price) {
        this.description = description;
        this.id = id;
        this.price = price;

    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}