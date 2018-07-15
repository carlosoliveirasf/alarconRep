package com.challenge.conductor.conductchallenge.connection;

import com.challenge.conductor.conductchallenge.vo.CartaoVO;
import com.challenge.conductor.conductchallenge.vo.ExtratoVO;
import com.challenge.conductor.conductchallenge.vo.SaldoVO;
import com.challenge.conductor.conductchallenge.vo.UserVO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WebService {

    String BASE_URL = "https://2hm1e5siv9.execute-api.us-east-1.amazonaws.com/dev/";
    String GET_SALDO = "resume";
    String GET_PORTADOR = "users/profile";
    String GET_EXTRATO = "card-statement?month=10&year=2018&page=1";
    String GET_USO_DO_CARTAO = "card-usage";

    @GET(GET_SALDO)
    Call<SaldoVO> getSaldo();

    @GET(GET_PORTADOR)
    Call<UserVO> getPortador();

    @GET(GET_EXTRATO)
    Call<ExtratoVO> getExtrato();

    @GET(GET_USO_DO_CARTAO)
    Call<List<CartaoVO>> getUsoDoCartao();
}
