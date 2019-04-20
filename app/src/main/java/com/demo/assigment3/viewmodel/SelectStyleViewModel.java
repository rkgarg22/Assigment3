package com.demo.assigment3.viewmodel;

import android.arch.lifecycle.ViewModel;

import com.demo.assigment3.navigation.GeneralInfoNavigator;
import com.demo.assigment3.navigation.SelectStyleNavigator;

import java.lang.ref.WeakReference;


public class SelectStyleViewModel extends ViewModel {
    private WeakReference<SelectStyleNavigator> mNavigator;

    public void setNavigator(SelectStyleNavigator navigator) {
        this.mNavigator = new WeakReference<>(navigator);
    }

    public void backBtnClick() {
        mNavigator.get().backBtnClick();
    }
}

