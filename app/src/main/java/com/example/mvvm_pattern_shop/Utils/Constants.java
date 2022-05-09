package com.example.mvvm_pattern_shop.Utils;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.mvvm_pattern_shop.Service.Model.ErrorResponse;
import com.google.gson.Gson;

import java.lang.reflect.Field;

import retrofit2.Response;

public class Constants {

    public static void sendResponse(MutableLiveData liveData, Response response, Class c) {
        try {
            if (response.isSuccessful()) {
                liveData.postValue(response.body());
            } else {
                ErrorResponse errorResponse = new Gson().fromJson(response.errorBody().string(), ErrorResponse.class);
                Field responseCode = c.getSuperclass().getDeclaredField("responseCode");
                Field responseMsg = c.getSuperclass().getDeclaredField("responseMsg");
                responseCode.setAccessible(true);
                responseMsg.setAccessible(true);
                Object o = c.newInstance();
                responseCode.set(o, response.code());
                responseMsg.set(o, errorResponse.getMsg());

                liveData.postValue(o);
            }

        } catch (Exception e) {
            Log.e("e", e.getMessage());
            liveData.postValue(null);
        }
    }
}
