package com.challenge.conductor.conductchallenge.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.challenge.conductor.conductchallenge.R;
import com.challenge.conductor.conductchallenge.abstracts.CardView;
import com.challenge.conductor.conductchallenge.presenter.CardPresenter;
import com.challenge.conductor.conductchallenge.vo.UserVO;

import java.util.Calendar;

public class CardFragment extends Fragment implements CardView{

    private CardPresenter cardPresenter;
    private TextView txtSaldo;
    private TextView txtCardNumber;
    private TextView txtPortadorName;
    private TextView txtExpDateValue;
    private Context context;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_card, container, false);
        context = inflater.getContext();
        cardPresenter = new CardPresenter(this);
        txtSaldo = view.findViewById(R.id.txtDisponivel);
        txtCardNumber = view.findViewById(R.id.txtCardNumber);
        txtPortadorName = view.findViewById(R.id.txtPortadorName);
        txtExpDateValue = view.findViewById(R.id.txtExpDateValue);
        getCardInformation();
        return view;
    }

    private void getCardInformation(){
        cardPresenter.getCardInformation();
        cardPresenter.getSaldo();
    }

    @Override
    public void onSuccessGetSaldo(String saldo) {
        txtSaldo.setText(saldo);
    }

    @Override
    public void onFailedGetSaldo(String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onSuccessGetPortador(UserVO userVO) {
        String cardNumber = "xxxx xxxx xxxx " + userVO.getCardNumber().substring(userVO.getCardNumber().length() - 4);
        txtCardNumber.setText(cardNumber);
        txtPortadorName.setText(userVO.getName());
        Calendar cal = Calendar.getInstance();
        cal.setTime(userVO.getExpirationDate());
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        String viewData = String.valueOf(month + 1) + "/" + String.valueOf(year) ;
        txtExpDateValue.setText(viewData);
    }

    @Override
    public void onFailedGetPortador(String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
