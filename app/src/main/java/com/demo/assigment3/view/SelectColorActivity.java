package com.demo.assigment3.view;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;

import com.demo.assigment3.R;
import com.demo.assigment3.adapter.ColorAdapter;
import com.demo.assigment3.databinding.ActivitySelectColorBinding;
import com.demo.assigment3.navigation.SelectColorNavigator;
import com.demo.assigment3.viewmodel.SelectColorViewModel;

public class SelectColorActivity extends AppCompatActivity implements SelectColorNavigator {

    private SelectColorViewModel selectColorViewModel;

    GridLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataBinding();
        subscribeToLiveData();
    }

    private void initDataBinding() {
        ActivitySelectColorBinding selectColorBinding = DataBindingUtil.setContentView(this, R.layout.activity_select_color);
        selectColorViewModel = ViewModelProviders.of(this).get(SelectColorViewModel.class);
        selectColorBinding.setViewModel(selectColorViewModel);
        selectColorViewModel.setNavigator(this);

        mLayoutManager = new GridLayoutManager(this,4);
        selectColorBinding.colorRecyclerView.setLayoutManager(mLayoutManager);

        ColorAdapter adapter = new ColorAdapter();
        selectColorBinding.colorRecyclerView.setAdapter(adapter);
    }

    public void subscribeToLiveData(){
        selectColorViewModel.getColorDataMutableLiveData().observe(this, colorDataList -> {
            selectColorViewModel.setColorDataArrayList(colorDataList);
        });
    }

    @Override
    public void backBtnClick() {
        this.finish();
    }
}
