package com.demo.assigment3.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.graphics.Color;

import com.demo.assigment3.R;
import com.demo.assigment3.model.ColorItemModel;
import com.demo.assigment3.navigation.SelectColorNavigator;
import com.demo.assigment3.navigation.SelectStyleNavigator;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;


public class SelectColorViewModel extends ViewModel {

    private String[] allColors = {"#FFFFFFFF", "#FFDEDFDE", "#FFE5D9B3", "#FFF9CA38", "#FFCB9F21", "#FFDC602F", "#FF79A732", "#FF2F7DB8",
            "#FFBB3780", "#FF6E6A11", "#FFCE3B30", "#FF6F3C8D", "#FF646565", "#FF6A4A35", "#FF0D0D0D", "#FFFBF1D2"};

    public final ObservableList<ColorItemModel> colorItemArrayList = new ObservableArrayList<>();
    private final MutableLiveData<List<ColorItemModel>> colorDataMutableLiveData;

    private WeakReference<SelectColorNavigator> mNavigator;

    public void setNavigator(SelectColorNavigator navigator) {
        this.mNavigator = new WeakReference<>(navigator);
    }

    public void backBtnClick() {
        mNavigator.get().backBtnClick();
    }

    public SelectColorViewModel() {
        this.colorDataMutableLiveData = new MutableLiveData<>();
        loadColorData();
    }

    public void loadColorData() {
        List<ColorItemModel> colorItemModelsList = new ArrayList<ColorItemModel>();
        for (String colorCode : allColors) {
            ColorItemModel colorItemModel = new ColorItemModel();
            colorItemModel.setColorCode(colorCode);
            colorItemModelsList.add(colorItemModel);
        }
        colorDataMutableLiveData.setValue(colorItemModelsList);
    }

    public MutableLiveData<List<ColorItemModel>> getColorDataMutableLiveData() {
        return colorDataMutableLiveData;
    }

    public void setColorDataArrayList(List<ColorItemModel> colorDataArrayList) {
        colorItemArrayList.clear();
        this.colorItemArrayList.addAll(colorDataArrayList);
    }

    public void colorSelected(ColorItemModel obj) {
        List<ColorItemModel> modelList = colorDataMutableLiveData.getValue();
        for (ColorItemModel colorItemModel : modelList) {
            if (colorItemModel.equals(obj)) {
                colorItemModel.setSlected(true);
            } else {
                colorItemModel.setSlected(false);
            }
        }
        colorDataMutableLiveData.postValue(modelList);
    }
}

