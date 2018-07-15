package com.challenge.conductor.conductchallenge.presenter;

import com.challenge.conductor.conductchallenge.abstracts.MainView;
import com.challenge.conductor.conductchallenge.service.CardService;
import com.challenge.conductor.conductchallenge.vo.ExtratoVO;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter {
    public MainView mainView;

    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
    }

    public void getExtrato(){
        CardService cardService = new CardService();
        cardService.callGetExtrato(new Callback<ExtratoVO>() {
            @Override
            public void onResponse(Call<ExtratoVO> call, Response<ExtratoVO> response) {
                if(response.isSuccessful()){
                    ExtratoVO extratoVO = response.body();
                    mainView.onSuccessGetExtrato(extratoVO);
                }else{
                    mainView.onFailedGetExtrato(response.message());
                }
            }

            @Override
            public void onFailure(Call<ExtratoVO> call, Throwable t) {
                mainView.onFailedGetExtrato(t.getMessage());
            }
        });
    }
}
