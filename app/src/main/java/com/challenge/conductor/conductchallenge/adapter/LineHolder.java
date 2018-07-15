package com.challenge.conductor.conductchallenge.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.challenge.conductor.conductchallenge.R;

public class LineHolder extends RecyclerView.ViewHolder {

    public TextView txtDate;
    public TextView txtDescription;
    public TextView txtValue;

    public LineHolder(View itemView) {
        super(itemView);
        txtDate = itemView.findViewById(R.id.txtDate);
        txtDescription = itemView.findViewById(R.id.txtDescription);
        txtValue = itemView.findViewById(R.id.txtValue);
    }
}
