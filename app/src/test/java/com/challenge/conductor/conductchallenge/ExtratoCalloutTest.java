package com.challenge.conductor.conductchallenge;

import com.challenge.conductor.conductchallenge.abstracts.MainView;
import com.challenge.conductor.conductchallenge.callback.ExtratoCallback;
import com.challenge.conductor.conductchallenge.vo.ExtratoVO;

import org.junit.Test;

import org.junit.Before;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import retrofit2.Response;

import static org.mockito.Mockito.verify;

public class ExtratoCalloutTest {

    @Mock
    MainView mainView;

    TestDataFactory testDataFactory ;

    ExtratoCallback extratoCallback;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        testDataFactory = new TestDataFactory();
        extratoCallback = new ExtratoCallback(mainView);
    }

    @Test
    public void successCalloutGetExtrato(){
        ExtratoVO extratoVO = testDataFactory.getExtratoVoData();
        Response<ExtratoVO> response = Response.success(extratoVO);
        extratoCallback.onResponse(null, response);

        verify(mainView).onSuccessGetExtrato(extratoVO);
    }

    @Test
    public void failedCalloutGetExtrato(){
       Response<ExtratoVO> response = Response.error(500, new ResponseBody() {
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
        extratoCallback.onResponse(null, response);

        verify(mainView).onFailedGetExtrato("Error occurred in getExtrato");
    }
}
