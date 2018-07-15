package com.challenge.conductor.conductchallenge.service;

import com.challenge.conductor.conductchallenge.connection.WebService;
import com.challenge.conductor.conductchallenge.vo.CartaoVO;
import com.challenge.conductor.conductchallenge.vo.ExtratoVO;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CardService {

    private final Retrofit retrofit;

    public CardService(){
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

    public void callGetExtrato(Callback<ExtratoVO> callback){
        WebService webService = retrofit.create(WebService.class);
        Call<ExtratoVO> call = webService.getExtrato();
        call.enqueue(callback);
    }

    public void callGetCardUsage(Callback<List<CartaoVO>> callback){
        WebService webService = retrofit.create(WebService.class);
        Call<List<CartaoVO>> call = webService.getUsoDoCartao();
        call.enqueue(callback);
    }
}
