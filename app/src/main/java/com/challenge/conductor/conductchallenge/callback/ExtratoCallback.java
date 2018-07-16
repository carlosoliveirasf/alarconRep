package com.challenge.conductor.conductchallenge.callback;

import com.challenge.conductor.conductchallenge.abstracts.MainView;
import com.challenge.conductor.conductchallenge.vo.ExtratoVO;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ExtratoCallback implements Callback<ExtratoVO> {

    private MainView mainView;

    public ExtratoCallback(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void onResponse(Call<ExtratoVO> call, Response<ExtratoVO> response) {
        if(response.isSuccessful()){
            ExtratoVO extratoVO = response.body();
            mainView.onSuccessGetExtrato(extratoVO);
        }else{
            mainView.onFailedGetExtrato("Error occurred in getExtrato");
        }
    }

    @Override
    public void onFailure(Call<ExtratoVO> call, Throwable t) {
        mainView.onFailedGetExtrato("Error occurred in getExtrato");
    }
}
