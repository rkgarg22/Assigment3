package com.demo.assigment3.view;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.demo.assigment3.R;
import com.demo.assigment3.databinding.ActivitySelectStyleBinding;
import com.demo.assigment3.navigation.SelectStyleNavigator;
import com.demo.assigment3.viewmodel.SelectStyleViewModel;

public class SelectStyleActivity extends AppCompatActivity implements SelectStyleNavigator {

    private SelectStyleViewModel selectStyleViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataBinding();
    }

    private void initDataBinding() {
        ActivitySelectStyleBinding selectStyleBinding = DataBindingUtil.setContentView(this, R.layout.activity_select_style);
        selectStyleViewModel = ViewModelProviders.of(this).get(SelectStyleViewModel.class);
        selectStyleBinding.setViewModel(selectStyleViewModel);
        selectStyleViewModel.setNavigator(this);
    }

    @Override
    public void backBtnClick() {
        this.finish();
    }
}
