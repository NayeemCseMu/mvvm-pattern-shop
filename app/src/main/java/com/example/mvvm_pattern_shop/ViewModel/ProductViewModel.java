package com.example.mvvm_pattern_shop.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.mvvm_pattern_shop.Service.Model.FakeProducts;
import com.example.mvvm_pattern_shop.Service.Repository.ProductRepository;
import com.example.mvvm_pattern_shop.Service.Repository.ProductRepositoryImp;

import java.util.List;

public class ProductViewModel extends AndroidViewModel {
    private ProductRepository productRepository;
    public ProductViewModel(@NonNull Application application) {
        super(application);
        productRepository = ProductRepositoryImp.getInstance(application);

    }

    public MutableLiveData<List<FakeProducts>> getProductList(){
        return productRepository.getShopProductList();
    }

}
