package com.challenge.conductor.conductchallenge.abstracts;

import com.challenge.conductor.conductchallenge.vo.CartaoVO;

import java.util.List;

public interface ChartView {
    void onSuccessGetCartaoUsage(List<CartaoVO> cartaoVO);
    void onFailedGetCartaoUsage(String message);
}
