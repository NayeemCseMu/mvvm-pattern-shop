package com.example.mvvm_pattern_shop.Service.Network;

import android.content.Context;

import com.example.mvvm_pattern_shop.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    public static final String FAKESTORE_BASE_URL = "https://fakestoreapi.com/";
    public static Retrofit retrofit;

    public static  Retrofit getRetroInstance()
    {
        if (retrofit == null) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            if (BuildConfig.DEBUG) {
                logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            }
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.connectTimeout(5, TimeUnit.MINUTES);
            httpClient.readTimeout(5, TimeUnit.MINUTES);
            httpClient.addInterceptor(logging);
//            httpClient.addInterceptor(new HeaderIntercept());
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(FAKESTORE_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();
        }

        return  retrofit;
    }
}
