package com.famlab.mateusz.planer.ds;

import com.famlab.mateusz.planer.ds.models.Categories;
import com.famlab.mateusz.planer.ds.models.Product;
import com.famlab.mateusz.planer.ds.models.Products;
import com.famlab.mateusz.planer.ds.models.ResponseAddProduct;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ConnectionPool;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Mateusz on 03.12.2017.
 */

public class ApiDataSource {

    public final static String URL = "http://360.actumlab.com/web/uploads/mateusz/";
    private Api api;

    public ApiDataSource() {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .client(getHTTPClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        api = retrofit.create(Api.class);
    }

    // zapytanie o produkty
    public Observable<Response<Products>> getProducts() {
        return api.getProducts().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<Response<Categories>> getCategories() {
        return api.getCategories().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    // dodj produkty
    public Observable<Response<ResponseAddProduct>> addProduct(Product product) {
        return api.addProduct(product).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }


    // Ustawienia serwera, timeouty itd
    private static OkHttpClient getHTTPClient() {
        int MAX_IDLE_CONNECTIONS = 30;
        int KEEP_ALIVE_DURATION_MS = 3 * 60 * 1000;
        final OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.connectTimeout(10, TimeUnit.SECONDS);
        httpClient.readTimeout(10, TimeUnit.SECONDS);
        httpClient.writeTimeout(10, TimeUnit.SECONDS);
        httpClient.retryOnConnectionFailure(true);
        httpClient.connectionPool(new ConnectionPool(
                MAX_IDLE_CONNECTIONS, KEEP_ALIVE_DURATION_MS, TimeUnit.SECONDS));
        httpClient.interceptors().add(chain -> onOnIntercept(chain));
        return httpClient.build();
    }

    // Obsługa socket timeout
    static private okhttp3.Response onOnIntercept(Interceptor.Chain chain) throws IOException {

        try {
            Request original = chain.request();
            Request.Builder requestBuilder = original.newBuilder();
            requestBuilder.method(original.method(), original.body());
            Request request = requestBuilder.build();
            okhttp3.Response response = chain.proceed(request);
            return response;
        } catch (SocketTimeoutException exception) {
            exception.printStackTrace();
        }

        return chain.proceed(null);
    }

}
