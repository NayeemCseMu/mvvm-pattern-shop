package com.example.mvvm_pattern_shop.Service.Repository;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.mvvm_pattern_shop.Service.Model.FakeProducts;
import com.example.mvvm_pattern_shop.Service.Network.ApiService;
import com.example.mvvm_pattern_shop.Service.Network.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductRepositoryImp implements ProductRepository{

    private static Context mContext;
    private static ProductRepositoryImp instance;
    private FakeProducts econixModel;
    public List<FakeProducts> mList;
    private MutableLiveData mutableLiveData;
    private static ApiService apiService;

    public static ProductRepositoryImp getInstance(Context context)
    {
//        apiService = RetrofitInstance.getRetroInstance(context).create(ApiService.class);
        if(instance == null){
            mContext = context;
            instance = new ProductRepositoryImp();
        }
        return instance;
    }



    @Override
    public MutableLiveData<List<FakeProducts>>  getShopProductList()
    {

        if(mutableLiveData == null){
            mutableLiveData = new MutableLiveData();
        }
        mList = new ArrayList<>();
       apiService  = RetrofitInstance.getRetroInstance().create(ApiService.class);

        Call<List<FakeProducts>> call = apiService.getProductList();

        call.enqueue(new Callback<List<FakeProducts>>() {
            @Override
            public void onResponse(Call<List<FakeProducts>> call, Response<List<FakeProducts>> response) {

                if(response.isSuccessful()){
//                    Constants.sendResponse(mutableLiveData, response,EconixModel.class);
                    mList =  response.body();
//                    mList = econixModel.getProducts();
//                    mList = econixModel.;
                    mutableLiveData.postValue(mList);
                }

            }

            @Override
            public void onFailure(Call<List<FakeProducts>> call, Throwable t) {
                Log.e("Error", "Catch Error 1! "+t.toString() );
            }
        });

        return  mutableLiveData;

    }
}
