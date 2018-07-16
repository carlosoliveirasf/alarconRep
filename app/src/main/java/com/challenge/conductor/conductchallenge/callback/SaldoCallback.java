package com.challenge.conductor.conductchallenge.callback;

import com.challenge.conductor.conductchallenge.abstracts.CardView;
import com.challenge.conductor.conductchallenge.vo.SaldoVO;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SaldoCallback implements Callback<SaldoVO> {
    private CardView cardView;

    public SaldoCallback(CardView cardView) {
        this.cardView = cardView;
    }

    @Override
    public void onResponse(Call<SaldoVO> call, Response<SaldoVO> response) {
        if(response.isSuccessful()){
            SaldoVO saldoVO = response.body();
            cardView.onSuccessGetSaldo(String.valueOf(saldoVO.getBalance()));
        }else{
            cardView.onFailedGetSaldo("Error occurred in getSaldo");
        }
    }

    @Override
    public void onFailure(Call<SaldoVO> call, Throwable t) {
        cardView.onFailedGetSaldo("Error occurred in getSaldo");
    }
}
