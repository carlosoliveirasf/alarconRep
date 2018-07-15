package com.challenge.conductor.conductchallenge.abstracts;

import com.challenge.conductor.conductchallenge.vo.ExtratoVO;

public interface MainView {
    void onSuccessGetExtrato(ExtratoVO extratoVO);
    void onFailedGetExtrato(String message);
}
