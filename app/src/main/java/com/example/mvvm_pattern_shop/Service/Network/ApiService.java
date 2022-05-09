package com.example.mvvm_pattern_shop.Service.Network;

import com.example.mvvm_pattern_shop.Service.Model.FakeProducts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("products")
    Call<List<FakeProducts>> getProductList();
}
