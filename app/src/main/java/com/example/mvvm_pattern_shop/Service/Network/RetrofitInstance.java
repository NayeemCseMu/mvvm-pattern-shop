package com.example.mvvm_pattern_shop.Service.Network;

import android.content.Context;

import com.example.mvvm_pattern_shop.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

//    public static final String FAKESTORE_BASE_URL = "https://fakestoreapi.com/";
    public static final String ECONIX_BASE_URL = "https://econix-react.envytheme.com/";

    public static Retrofit retrofit;

    public static  Retrofit getRetroInstance()
    {
        if (retrofit == null)
        {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(ECONIX_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return  retrofit;
    }
}
