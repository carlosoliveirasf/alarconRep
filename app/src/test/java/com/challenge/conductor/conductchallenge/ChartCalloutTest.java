package com.challenge.conductor.conductchallenge;

import com.challenge.conductor.conductchallenge.abstracts.ChartView;
import com.challenge.conductor.conductchallenge.callback.CardUsageCallback;
import com.challenge.conductor.conductchallenge.vo.CartaoVO;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import retrofit2.Response;

import static org.mockito.Mockito.verify;

public class ChartCalloutTest {
    @Mock
    ChartView chartView;

    CardUsageCallback cardUsageCallback;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        cardUsageCallback = new CardUsageCallback(chartView);
    }

    @Test
    public void successCalloutGetChartData(){
        List<CartaoVO> cartaoVOS = new ArrayList<>();
        Response<List<CartaoVO>> response = Response.success(cartaoVOS);
        cardUsageCallback.onResponse(null, response);

        verify(chartView).onSuccessGetCartaoUsage(cartaoVOS);
    }

    @Test
    public void failedCalloutGetChartData(){
        Response<List<CartaoVO>> response = Response.error(500, new ResponseBody() {

            @Override
            public MediaType contentType() {
                return null;
            }

            @Override
            public long contentLength() {
                return 0;
            }

            @Override
            public BufferedSource source() {
                return null;
            }
        });
        cardUsageCallback.onResponse(null, response);

        verify(chartView).onFailedGetCartaoUsage("Error occurred in getCardUsage");
    }
}
