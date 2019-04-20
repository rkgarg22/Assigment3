package com.demo.assigment3.viewmodel;

import android.arch.lifecycle.ViewModel;
import com.demo.assigment3.navigation.GeneralInfoNavigator;
import java.lang.ref.WeakReference;


public class GeneralInfoViewModel extends ViewModel {

    private WeakReference<GeneralInfoNavigator> mNavigator;

    public void setNavigator(GeneralInfoNavigator navigator) {
        this.mNavigator = new WeakReference<>(navigator);
    }

    public void styleBtnClick() {
        mNavigator.get().moveToSelectStyleActivity();
    }

    public void colorBtnClick() {
        mNavigator.get().moveToSelectColorActivity();
    }

    public void backBtnClick() {
        mNavigator.get().backBtnClick();
    }

}

