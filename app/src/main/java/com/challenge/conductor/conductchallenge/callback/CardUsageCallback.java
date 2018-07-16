package com.challenge.conductor.conductchallenge.callback;

import com.challenge.conductor.conductchallenge.abstracts.ChartView;
import com.challenge.conductor.conductchallenge.vo.CartaoVO;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CardUsageCallback implements Callback<List<CartaoVO>> {
    private ChartView chartView;

    public CardUsageCallback(ChartView chartView) {
        this.chartView = chartView;
    }

    @Override
    public void onResponse(Call<List<CartaoVO>> call, Response<List<CartaoVO>> response) {
        if(response.isSuccessful()){
            List<CartaoVO> cartaoVOS = response.body();
            chartView.onSuccessGetCartaoUsage(cartaoVOS);
        }else{
            chartView.onFailedGetCartaoUsage("Error occurred in getExtrato");
        }
    }

    @Override
    public void onFailure(Call<List<CartaoVO>> call, Throwable t) {
        chartView.onFailedGetCartaoUsage(t.getMessage());
    }
}
