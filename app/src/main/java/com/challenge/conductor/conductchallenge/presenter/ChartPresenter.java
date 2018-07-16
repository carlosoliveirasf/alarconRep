package com.challenge.conductor.conductchallenge.presenter;

import com.challenge.conductor.conductchallenge.abstracts.ChartView;
import com.challenge.conductor.conductchallenge.callback.CardUsageCallback;
import com.challenge.conductor.conductchallenge.service.CardService;

public class ChartPresenter {

    private ChartView chartView;

    public ChartPresenter(ChartView chartView) {
        this.chartView = chartView;
    }

    public void getCardUsage(){
        CardService cardService = new CardService();
        cardService.callGetCardUsage(new CardUsageCallback(chartView));
    }
}
