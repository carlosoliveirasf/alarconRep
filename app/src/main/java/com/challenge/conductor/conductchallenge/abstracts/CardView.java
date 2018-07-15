package com.challenge.conductor.conductchallenge.abstracts;

import com.challenge.conductor.conductchallenge.vo.UserVO;

public interface CardView {
    void onSuccessGetSaldo(String saldo);
    void onFailedGetSaldo(String message);
    void onSuccessGetPortador(UserVO userVO);
    void onFailedGetPortador(String message);

}
