package com.example.yedi_tilsim__.barlag;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Movie {
    // Model Class

//
//    public Movie(String name, List<ImageDetails> imageDetails) {
//        this.name = name;
//        ImageDetails = imageDetails;
//    }
//
//    private final String name;
//    private final List<ImageDetails> ImageDetails;
//
//    public String getName() {
//        return name;
//    }
//
//    public List<ImageDetails> getImageDetails() {
//        return ImageDetails;
//    }
//
//    public class ImageDetails {
//
//        public ImageDetails(String imgUrl) {
//            this.imgUrl = imgUrl;
//        }
//
//        public String getImgUrl() {
//            return imgUrl;
//        }
//
//        private final String imgUrl;
//
//    }
//
//    public Movie(String name,ImageDetails imageDetails) {
//        this.name = name;
//        this.imageDetails = imageDetails;
//    }
//    public String getPrice() {
//        return name;
//    }
//
//    private final String name;
//
//
//    @SerializedName("productImage")
//    private final ImageDetails imageDetails;
//
//    public ImageDetails getImageDetails() {
//        return imageDetails;
//    }
//





//
//    public Movie(float brandId, String name, String price, String description, String quantity, ImageDetails imageDetails) {
//        this.brandId = brandId;
//        this.name = name;
//        this.price = price;
//        this.description = description;
//        this.quantity = quantity;
//        this.imageDetails = imageDetails;
//    }
//
//    public float getBrandId() {
//        return brandId;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getPrice() {
//        return price;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public String getQuantity() {
//        return quantity;
//    }
//
//    private final float brandId;
//    private final String name;
//    private final String price;
//    private final String description;
//    private final String quantity;
//
//    @SerializedName("productImage")
//    private final ImageDetails imageDetails;
//
//    public ImageDetails getImageDetails() {
//        return imageDetails;
//    }
//


//
//

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
