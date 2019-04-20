package com.demo.assigment3.viewmodel;

import android.arch.lifecycle.ViewModel;

import com.demo.assigment3.navigation.GeneralInfoNavigator;
import com.demo.assigment3.navigation.ShoesDetailNavigator;

import java.lang.ref.WeakReference;


public class ShoesDetailViewModel extends ViewModel {

    private WeakReference<ShoesDetailNavigator> mNavigator;

    public void setNavigator(ShoesDetailNavigator navigator) {
        this.mNavigator = new WeakReference<>(navigator);
    }

    public void backBtnClick() {
        mNavigator.get().backBtnClick();
    }

}

