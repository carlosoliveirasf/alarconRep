package com.challenge.conductor.conductchallenge.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Toast;

import com.challenge.conductor.conductchallenge.R;
import com.challenge.conductor.conductchallenge.abstracts.MainView;
import com.challenge.conductor.conductchallenge.adapter.LineAdapter;
import com.challenge.conductor.conductchallenge.presenter.MainPresenter;
import com.challenge.conductor.conductchallenge.vo.ExtratoVO;

public class MainActivity extends AppCompatActivity implements MainView {

    private LineAdapter lineAdapter;
    private RecyclerView recyclerView;
    private MainPresenter mainPresenter = new MainPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeComponents();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,
                    new CardFragment()).commit();
        }
    }

    private void initializeComponents(){
        recyclerView = findViewById(R.id.recyclerViewList);
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        setUpCardInformation();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()){
                        case R.id.nav_chartter:
                            selectedFragment = new ChartFragment();
                            break;
                        case R.id.nav_card:
                            selectedFragment = new CardFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,
                            selectedFragment).commit();

                    return true;
                }
            };

    public void setUpCardInformation(){
        mainPresenter.getExtrato();
    }

    @Override
    public void onSuccessGetExtrato(ExtratoVO extratoVO) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        lineAdapter = new LineAdapter(extratoVO);
        recyclerView.setAdapter(lineAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    @Override
    public void onFailedGetExtrato(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
