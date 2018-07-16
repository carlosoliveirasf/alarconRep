package com.challenge.conductor.conductchallenge.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.challenge.conductor.conductchallenge.R;
import com.challenge.conductor.conductchallenge.abstracts.ChartView;
import com.challenge.conductor.conductchallenge.presenter.ChartPresenter;
import com.challenge.conductor.conductchallenge.vo.CartaoVO;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class ChartFragment extends Fragment implements ChartView{
    private ChartPresenter chartPresenter;
    private BarChart barChart;
    private Context context;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_charter, container, false);
        context = inflater.getContext();
        chartPresenter = new ChartPresenter(this);
        barChart = view.findViewById(R.id.chart);
        barChart.getDescription().setEnabled(false);
        chartPresenter.getCardUsage();
        barChart.setFitBars(true);
        return view;
    }

    @Override
    public void onSuccessGetCartaoUsage(List<CartaoVO> cartaoVO) {
        ArrayList<BarEntry> barEntries = new ArrayList<>();
        int index = 0;
        for(CartaoVO cartaoVO1 : cartaoVO){
            barEntries.add(new BarEntry(index, Math.round(cartaoVO1.getValue())));
            index++;
        }
        BarDataSet barDataSet = new BarDataSet(barEntries, "Ricardo Eletro");
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setDrawValues(true);

        BarData data = new BarData(barDataSet);

        barChart.setData(data);
        barChart.invalidate();
        barChart.animateY(500);
    }

    @Override
    public void onFailedGetCartaoUsage(String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
