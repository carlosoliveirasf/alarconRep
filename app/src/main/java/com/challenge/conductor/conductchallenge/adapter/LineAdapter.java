package com.challenge.conductor.conductchallenge.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import com.challenge.conductor.conductchallenge.R;
import com.challenge.conductor.conductchallenge.vo.CartaoVO;
import com.challenge.conductor.conductchallenge.vo.ExtratoVO;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

public class LineAdapter extends RecyclerView.Adapter<LineHolder>{

    private ExtratoVO extratoVO;

    public LineAdapter(ExtratoVO extratoVO) {
        this.extratoVO = extratoVO;
    }

    @NonNull
    @Override
    public LineHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LineHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.main_line_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LineHolder holder, int position) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(extratoVO.getPurchaseVOS().get(position).getDate());
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH);
        String viewData = String.valueOf(day) + "/" + String.valueOf(month + 1);
        holder.txtDate.setText(viewData);
        holder.txtDescription.setText(extratoVO.getPurchaseVOS().get(position).getDescription());
        holder.txtValue.setText(String.valueOf(extratoVO.getPurchaseVOS().get(position).getValue()));

    }

    @Override
    public int getItemCount() {
        return extratoVO.getPurchaseVOS() != null ? extratoVO.getPurchaseVOS().size() : 0;
    }
}
