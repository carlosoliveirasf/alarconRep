package com.challenge.conductor.conductchallenge.presenter;

import com.challenge.conductor.conductchallenge.abstracts.ChartView;
import com.challenge.conductor.conductchallenge.service.CardService;
import com.challenge.conductor.conductchallenge.vo.CartaoVO;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChartPresenter {

    private ChartView chartView;

    public ChartPresenter(ChartView chartView) {
        this.chartView = chartView;
    }

    public void getCardUsage(){
        CardService cardService = new CardService();
        cardService.callGetCardUsage(new Callback<List<CartaoVO>>() {
            @Override
            public void onResponse(Call<List<CartaoVO>> call, Response<List<CartaoVO>> response) {
                if(response.isSuccessful()){
                    List<CartaoVO> cartaoVOS = response.body();
                    Double amount = 0.0;
                    for(CartaoVO cartaoVO : cartaoVOS){
                        amount = cartaoVO.getValue() + amount;
                    }
                    chartView.onSuccessGetCartaoUsage(cartaoVOS, amount);
                }else{
                    chartView.onFailedGetCartaoUsage(response.message());
                }
            }

            @Override
            public void onFailure(Call<List<CartaoVO>> call, Throwable t) {
                chartView.onFailedGetCartaoUsage(t.getMessage());
            }
        });

    }
}
