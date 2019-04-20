package com.demo.assigment3.viewmodel;

import android.arch.lifecycle.ViewModel;

import com.demo.assigment3.navigation.MainViewNavigator;

import java.lang.ref.WeakReference;

public class MainViewModel extends ViewModel {

    private WeakReference<MainViewNavigator> mNavigator;

    public void setNavigator(MainViewNavigator navigator) {
        this.mNavigator = new WeakReference<>(navigator);
    }

    public void skipBtnClick() {
        mNavigator.get().skipClick();
    }

    public void searchViewClick() {
        mNavigator.get().moveToSearchActivity();
    }
}

