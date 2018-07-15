package com.challenge.conductor.conductchallenge.service;

import com.challenge.conductor.conductchallenge.connection.WebService;
import com.challenge.conductor.conductchallenge.vo.SaldoVO;
import com.challenge.conductor.conductchallenge.vo.UserVO;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.Callback;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserService {

    private final Retrofit retrofit;

    public UserService(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(WebService.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public void callGetSaldo(Callback<SaldoVO> callback){
        WebService webService = retrofit.create(WebService.class);
        Call<SaldoVO> call = webService.getSaldo();
        call.enqueue(callback);
    }

    public void callGetPortador(Callback<UserVO> callback){
        WebService webService = retrofit.create(WebService.class);
        Call<UserVO> call = webService.getPortador();
        call.enqueue(callback);
    }
}
