package com.challenge.conductor.conductchallenge.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.challenge.conductor.conductchallenge.R;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class StarterActivity extends AppCompatActivity {

    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starter);
        handler = new Handler();
        YoYo.with(Techniques.FadeInDown)
                .duration(2500)
                .pivot(YoYo.CENTER_PIVOT, YoYo.CENTER_PIVOT)
                .playOn(findViewById(R.id.logoSS));
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(StarterActivity.this, MainActivity.class));
                finish();
            }
        }, 2500);

    }
}
