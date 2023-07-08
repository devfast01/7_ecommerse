package com.example.yedi_tilsim__.volley;

import java.util.List;

public class Product_volley {


    public Product_volley(int id, String name, String description, double price, String productSku, int quantity, int categoryId, int discountId, int brandId, List<ProductImage_v> productImages) {
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

    public void setProductSku(String productSku) {
        this.product_sku = productSku;
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

    public void setCategoriesId(int categoriesId) {
        this.categories_id = categoriesId;
    }

    public int getDiscountsId() {
        return discounts_id;
    }

    public void setDiscountsId(int discountsId) {
        this.discounts_id = discountsId;
    }

    public int getBrandsId() {
        return brands_id;
    }

    public void setBrandsId(int brandsId) {
        this.brands_id = brandsId;
    }

    public List<ProductImage_v> getProductImages() {
        return products_images;
    }

    public void setProductImages(List<ProductImage_v> productImages) {
        this.products_images = productImages;
    }

    private int id;
    private String name;
    private String description;
    private double price;
    private String product_sku;
    private int quantity;
    private int categories_id;
    private int discounts_id;
    private int brands_id;
    private List<ProductImage_v> products_images;
}
