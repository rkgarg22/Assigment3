package com.demo.assigment3.navigation;

import com.demo.assigment3.model.ShoesItemModel;

public interface ShoesListActivityNavigator {

    void backBtnClick();

    void speakBtnClick();

    void moveToShoesDetailActivity(ShoesItemModel obj);
}
