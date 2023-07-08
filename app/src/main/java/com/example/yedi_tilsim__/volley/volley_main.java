package com.example.yedi_tilsim__.volley;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.yedi_tilsim__.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class volley_main extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Product_volley> productList;
    private ProductAdapter_v productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley_main2);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        productList = new ArrayList<>();
        productAdapter = new ProductAdapter_v(productList, this);
        recyclerView.setAdapter(productAdapter);

        // Make a JSON request using Volley
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, APIInterface.BASE_URL,
                null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    // Parse the JSON response and populate the productList
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject jsonObject = response.getJSONObject(i);

                        int id = jsonObject.getInt("id");
                        String name = jsonObject.getString("name");
                        String description = jsonObject.getString("description");
                        double price = jsonObject.getDouble("price");
                        String productSku = jsonObject.getString("product_sku");
                        int quantity = jsonObject.getInt("quantity");
                        int categoryId = jsonObject.getInt("categories_id");
                        int discountId = jsonObject.getInt("discounts_id");
                        int brandId = jsonObject.getInt("brands_id");

                        List<ProductImage_v> productImages = new ArrayList<>();
                        JSONArray imagesArray = jsonObject.getJSONArray("products_images");
                        for (int j = 0; j < imagesArray.length(); j++) {
                            JSONObject imageObj = imagesArray.getJSONObject(j);
                            int imageId = imageObj.getInt("id");
                            String imageUrl = imageObj.getString("img_url");
                            int productId = imageObj.getInt("products_id");

                            ProductImage_v productImage = new ProductImage_v(imageId, imageUrl, productId);
                            productImages.add(productImage);
                        }

                        Product_volley product = new Product_volley(id, name, description, price, productSku, quantity,
                                categoryId, discountId, brandId, productImages);

                        productList.add(product);
                    }

                    // Notify the adapter that the data set has changed
                    productAdapter.notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(volley_main.this, "Error fetching data: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        // Add the JSON request to the request queue
        Volley.newRequestQueue(this).add(jsonArrayRequest);
    }
}