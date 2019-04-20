package com.demo.assigment3.view;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.demo.assigment3.R;
import com.demo.assigment3.databinding.ActivityGeneralInfoBinding;
import com.demo.assigment3.navigation.GeneralInfoNavigator;
import com.demo.assigment3.viewmodel.GeneralInfoViewModel;

public class GeneralInfoActivity extends AppCompatActivity implements GeneralInfoNavigator {

    private GeneralInfoViewModel generalInfoViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataBinding();
    }

    private void initDataBinding() {
        ActivityGeneralInfoBinding generalInfoBinding = DataBindingUtil.setContentView(this, R.layout.activity_general_info);
        generalInfoViewModel = ViewModelProviders.of(this).get(GeneralInfoViewModel.class);
        generalInfoBinding.setViewModel(generalInfoViewModel);
        generalInfoViewModel.setNavigator(this);
    }

    @Override
    public void moveToSelectStyleActivity() {
        Intent selectStyleActivity = new Intent(this, SelectStyleActivity.class);
        startActivity(selectStyleActivity);
    }

    @Override
    public void moveToSelectColorActivity() {
        Intent selectColorActivity = new Intent(this, SelectColorActivity.class);
        startActivity(selectColorActivity);
    }

    @Override
    public void backBtnClick() {
        this.finish();
    }
}
