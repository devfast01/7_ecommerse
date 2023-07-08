package com.example.yedi_tilsim__.geeks_json;

import java.util.List;

public class RecyclerData {
    // string variables for our data
    // make sure that the variable name
    // must be similar to that of key value
    // which we are getting from our json file.
    private String id;
    private String name;
    private String description;

    public List<ProductImage> getProducts_images() {
        return products_images;
    }

    public void setProducts_images(List<ProductImage> products_images) {
        this.products_images = products_images;
    }

    private List<ProductImage> products_images;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
