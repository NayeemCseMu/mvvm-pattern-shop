package com.example.mvvm_pattern_shop.Service.Repository;

import androidx.lifecycle.MutableLiveData;

import com.example.mvvm_pattern_shop.Service.Model.EconixModel;
import com.example.mvvm_pattern_shop.Service.Model.Product;
import com.example.mvvm_pattern_shop.Service.Model.ProductModel;

import java.util.List;

public interface ProductRepository {

    public MutableLiveData<List<Product>> getShopProductList();

}

