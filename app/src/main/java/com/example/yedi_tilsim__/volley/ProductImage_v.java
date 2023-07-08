package com.example.yedi_tilsim__.volley;

public class ProductImage_v {
    public ProductImage_v(int imageId, String imageUrl, int productId) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImgUrl() {
        return img_url;
    }

    public void setImgUrl(String imgUrl) {
        this.img_url = imgUrl;
    }

    public int getProductsId() {
        return products_id ;
    }

    public void setProductsId(int productsId) {
        this.products_id = productsId;
    }

    private int id;
    private String img_url;
    private int products_id;
}
