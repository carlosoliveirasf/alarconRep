package com.challenge.conductor.conductchallenge.presenter;

import com.challenge.conductor.conductchallenge.abstracts.CardView;
import com.challenge.conductor.conductchallenge.callback.PortadorCallback;
import com.challenge.conductor.conductchallenge.callback.SaldoCallback;
import com.challenge.conductor.conductchallenge.service.UserService;

public class CardPresenter {

    private CardView cardView;

    public CardPresenter(CardView cardView) {
        this.cardView = cardView;
    }

    public void getSaldo(){
        UserService userService = new UserService();
        userService.callGetSaldo(new SaldoCallback(cardView));
    }

    public void getCardInformation(){
        UserService userService = new UserService();
        userService.callGetPortador(new PortadorCallback(cardView));
    }
}
