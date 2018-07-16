package com.challenge.conductor.conductchallenge;

import com.challenge.conductor.conductchallenge.abstracts.CardView;
import com.challenge.conductor.conductchallenge.callback.PortadorCallback;
import com.challenge.conductor.conductchallenge.callback.SaldoCallback;
import com.challenge.conductor.conductchallenge.vo.SaldoVO;
import com.challenge.conductor.conductchallenge.vo.UserVO;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import retrofit2.Response;

import static org.mockito.Mockito.verify;

public class CardCalloutTest {
    @Mock
    CardView cardView;

    SaldoCallback saldoCallback;
    PortadorCallback portadorCallback;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        saldoCallback = new SaldoCallback(cardView);
        portadorCallback = new PortadorCallback(cardView);
    }

    @Test
    public void successCalloutGetSaldo(){
        SaldoVO saldoVO = new SaldoVO();
        saldoVO.setBalance(15.5);
        Response<SaldoVO> response = Response.success(saldoVO);
        saldoCallback.onResponse(null, response);

        verify(cardView).onSuccessGetSaldo(saldoVO.getBalance().toString());
    }

    @Test
    public void failedCalloutGetSaldo(){
        Response<SaldoVO> response = Response.error(500, new ResponseBody() {

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
        saldoCallback.onResponse(null, response);

        verify(cardView).onFailedGetSaldo("Error occurred in getSaldo");
    }

    @Test
    public void successCalloutGetPortador(){
        UserVO userVO = new UserVO();
        Response<UserVO> response = Response.success(userVO);
        portadorCallback.onResponse(null, response);
        verify(cardView).onSuccessGetPortador(userVO);
    }

    @Test
    public void failedCalloutGetPortador(){
        Response<UserVO> response = Response.error(500, new ResponseBody() {

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
        portadorCallback.onResponse(null, response);

        verify(cardView).onFailedGetPortador("Error occurred in getPortador");
    }
}
