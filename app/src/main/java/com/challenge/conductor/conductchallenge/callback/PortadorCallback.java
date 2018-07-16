package com.challenge.conductor.conductchallenge.callback;

import com.challenge.conductor.conductchallenge.abstracts.CardView;
import com.challenge.conductor.conductchallenge.vo.UserVO;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PortadorCallback implements Callback<UserVO> {

    private CardView cardView;

    public PortadorCallback(CardView cardView) {
        this.cardView = cardView;
    }

    @Override
    public void onResponse(Call<UserVO> call, Response<UserVO> response) {
        if(response.isSuccessful()){
            UserVO userVO = response.body();
            cardView.onSuccessGetPortador(userVO);
        }else{
            cardView.onFailedGetPortador("Error occurred in getPortador");
        }
    }

    @Override
    public void onFailure(Call<UserVO> call, Throwable t) {
        cardView.onFailedGetSaldo("Error occurred in getPortador");
    }
}
