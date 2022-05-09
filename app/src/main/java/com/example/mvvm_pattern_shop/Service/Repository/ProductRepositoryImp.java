package com.example.mvvm_pattern_shop.Service.Repository;

import static androidx.core.content.PackageManagerCompat.LOG_TAG;
import static java.sql.DriverManager.println;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.mvvm_pattern_shop.Service.Model.EconixModel;
import com.example.mvvm_pattern_shop.Service.Model.Product;
import com.example.mvvm_pattern_shop.Service.Model.ProductModel;
import com.example.mvvm_pattern_shop.Service.Network.ApiService;
import com.example.mvvm_pattern_shop.Service.Network.RetrofitInstance;
import com.example.mvvm_pattern_shop.Utils.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductRepositoryImp implements ProductRepository{

    private static Context mContext;
    private static ProductRepositoryImp instance;
    private EconixModel econixModel;
    public List<Product> mList;
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
    public MutableLiveData<List<Product>>  getShopProductList()
    {

        if(mutableLiveData == null){
            mutableLiveData = new MutableLiveData();
        }
       apiService  = RetrofitInstance.getRetroInstance().create(ApiService.class);

        Call<EconixModel> call = apiService.getProductList();

        call.enqueue(new Callback<EconixModel>() {
            @Override
            public void onResponse(Call<EconixModel> call, Response<EconixModel> response) {

                if(response.isSuccessful()){
//                    Constants.sendResponse(mutableLiveData, response,EconixModel.class);
                    econixModel =  response.body();
                    mList = econixModel.getProducts();
                    mutableLiveData.postValue(mList);
                }

            }

            @Override
            public void onFailure(Call<EconixModel> call, Throwable t) {
                Log.e("Error", "Catch Error 1! "+t.toString() );
            }
        });

        return  mutableLiveData;

    }
}
