package com.demo.assigment3.view;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.demo.assigment3.R;
import com.demo.assigment3.databinding.ActivityShoesDetailBinding;
import com.demo.assigment3.model.ShoesItemModel;
import com.demo.assigment3.navigation.ShoesDetailNavigator;
import com.demo.assigment3.viewmodel.ShoesDetailViewModel;
import com.google.gson.Gson;

public class ShoesDetailActivity extends AppCompatActivity implements ShoesDetailNavigator {

    private ShoesDetailViewModel shoesDetailViewModel;
    private ShoesItemModel itemObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String objectStr = getIntent().getStringExtra("object");
        itemObject = new Gson().fromJson(objectStr, ShoesItemModel.class);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        initDataBinding();
    }

    private void initDataBinding() {
        ActivityShoesDetailBinding shoesDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_shoes_detail);
        shoesDetailViewModel = ViewModelProviders.of(this).get(ShoesDetailViewModel.class);
        shoesDetailBinding.setViewModel(shoesDetailViewModel);
        shoesDetailBinding.setItemObject(itemObject);
        shoesDetailViewModel.setNavigator(this);
    }

    @Override
    public void backBtnClick() {
        this.finish();
    }

}
