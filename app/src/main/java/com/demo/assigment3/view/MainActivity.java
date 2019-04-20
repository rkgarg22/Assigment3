package com.demo.assigment3.view;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.demo.assigment3.R;
import com.demo.assigment3.databinding.ActivityMainBinding;
import com.demo.assigment3.navigation.MainViewNavigator;
import com.demo.assigment3.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity implements MainViewNavigator {

    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataBinding();
    }

    private void initDataBinding() {
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        activityMainBinding.setViewModel(mainViewModel);
        mainViewModel.setNavigator(this);
    }

    @Override
    public void moveToSearchActivity() {
        Intent generalInfoIntent = new Intent(this, ShoesListActivity.class);
        startActivity(generalInfoIntent);
    }

    @Override
    public void skipClick() {
        Intent generalInfoIntent = new Intent(this, GeneralInfoActivity.class);
        startActivity(generalInfoIntent);
    }
}
