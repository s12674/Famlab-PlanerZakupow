package com.famlab.mateusz.planer.ds;

import com.famlab.mateusz.planer.ds.models.Product;
import com.famlab.mateusz.planer.ds.models.Products;
import com.famlab.mateusz.planer.ds.models.ResponseAddProduct;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Mateusz on 03.12.2017.
 */

interface Api {
    @GET("product.json")
    Observable<Response<Products>> getProducts();

    // Pobranie produktów z konkretnymi parametrami w body
    @GET("product.json")
    Observable<Response<Products>> getProducts(@Query("lat") double lat, @Query("lon") double lon);

    // Dodanie produktu
    @POST("product.json")
    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    Observable<Response<ResponseAddProduct>> addProduct(@Body Product product);
}
