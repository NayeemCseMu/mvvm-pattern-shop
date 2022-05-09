package com.example.mvvm_pattern_shop.Service.Repository;

import androidx.lifecycle.MutableLiveData;

import com.example.mvvm_pattern_shop.Service.Model.FakeProducts;

import java.util.List;

public interface ProductRepository {

    public MutableLiveData<List<FakeProducts>> getShopProductList();

}

