package com.example.yedi_tilsim__.GPT_json;


import android.graphics.Bitmap;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Product {
    private int id;
    private String name;
    private String description;
    private double price;
    private String product_sku;
    private int quantity;
    private int categories_id;
    private int discounts_id;
    private int brands_id;

    public ProductImage getProductImage() {
        return products_images;
    }

    public void setProductImage(ProductImage products_images) {
        this.products_images = products_images;
    }

    @SerializedName("products_images")
    private ProductImage products_images;

    // Constructor, getters, and setters

    public Product(int id, String name, String description, double price, String product_sku, int quantity, int categories_id, int discounts_id, int brands_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.product_sku = product_sku;
        this.quantity = quantity;
        this.id = categories_id;
        this.discounts_id = discounts_id;
        this.brands_id = brands_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProductSku() {
        return product_sku;
    }

    public void setProductSku(String product_sku) {
        this.product_sku = product_sku;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCategoriesId() {
        return categories_id;
    }

    public void setCategoriesId(int categories_id) {
        this.categories_id = categories_id;
    }

    public int getDiscountsId() {
        return discounts_id;
    }

    public void setDiscountsId(int discounts_id) {
        this.discounts_id = discounts_id;
    }

    public int getBrandsId() {
        return brands_id;
    }

    public void setBrandsId(int brands_id) {
        this.brands_id = brands_id;
    }


}