package com.challenge.conductor.conductchallenge.presenter;

import com.challenge.conductor.conductchallenge.abstracts.CardView;
import com.challenge.conductor.conductchallenge.service.UserService;
import com.challenge.conductor.conductchallenge.vo.SaldoVO;
import com.challenge.conductor.conductchallenge.vo.UserVO;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CardPresenter {

    private CardView cardView;

    public CardPresenter(CardView cardView) {
        this.cardView = cardView;
    }

    public void getSaldo(){
        UserService userService = new UserService();
        userService.callGetSaldo(new Callback<SaldoVO>() {
            @Override
            public void onResponse(Call<SaldoVO> call, Response<SaldoVO> response) {
                if(response.isSuccessful()){
                    SaldoVO saldoVO = response.body();
                    cardView.onSuccessGetSaldo(String.valueOf(saldoVO.getBalance()));
                }else{
                    cardView.onFailedGetSaldo(response.message());
                }
            }
            @Override
            public void onFailure(Call<SaldoVO> call, Throwable t) {
                cardView.onFailedGetSaldo(t.getMessage());
            }
        });
    }

    public void getCardInformation(){
        UserService userService = new UserService();
        userService.callGetPortador(new Callback<UserVO>() {
            @Override
            public void onResponse(Call<UserVO> call, Response<UserVO> response) {
                if(response.isSuccessful()){
                    UserVO userVO = response.body();
                    cardView.onSuccessGetPortador(userVO);
                }else{
                    cardView.onFailedGetPortador(response.message());
                }
            }

            @Override
            public void onFailure(Call<UserVO> call, Throwable t) {
                cardView.onFailedGetPortador(t.getMessage());
            }
        });
    }
}
