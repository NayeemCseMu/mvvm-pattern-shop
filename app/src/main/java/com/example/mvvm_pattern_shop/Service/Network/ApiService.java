package com.example.mvvm_pattern_shop.Service.Network;

import com.example.mvvm_pattern_shop.Service.Model.EconixModel;
import com.example.mvvm_pattern_shop.Service.Model.ProductModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("products")
    Call<EconixModel> getProductList();
}
