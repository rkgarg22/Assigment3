package com.demo.assigment3.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.widget.Filter;
import android.widget.Filterable;

import com.demo.assigment3.BR;
import com.demo.assigment3.model.ShoesItemModel;
import com.demo.assigment3.navigation.ShoesListActivityNavigator;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class ShoesListViewModel extends BaseObservable implements Filterable {

    private WeakReference<ShoesListActivityNavigator> mNavigator;

    public final ObservableList<ShoesItemModel> shoesItemArrayList = new ObservableArrayList<>();
    private final MutableLiveData<List<ShoesItemModel>> shoesItemMutableLiveData;

    List<ShoesItemModel> originalShoesItemModelList = new ArrayList<ShoesItemModel>();

    @Bindable
    public MutableLiveData<String> editTextContent = new MutableLiveData<String>();

    public ShoesListViewModel() {
        this.shoesItemMutableLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<List<ShoesItemModel>> getShoesItemMutableLiveData() {
        return shoesItemMutableLiveData;
    }

    public void setNavigator(ShoesListActivityNavigator navigator) {
        this.mNavigator = new WeakReference<>(navigator);
    }

    public void loadShoesData() {

        for (int i = 0; i < 20; i++) {
            ShoesItemModel obj = new ShoesItemModel();
            obj.setShoeID(Integer.toString(i));
            obj.setName("Shoes Name " + i);
            obj.setManufacturer("Manufacturer " + i);
            originalShoesItemModelList.add(obj);
        }
        shoesItemMutableLiveData.setValue(originalShoesItemModelList);
    }

    public void setShoesItemArrayList(List<ShoesItemModel> shoesItemArrayList) {
        this.shoesItemArrayList.clear();
        this.shoesItemArrayList.addAll(shoesItemArrayList);
    }

    public void backBtnClick() {
        mNavigator.get().backBtnClick();
    }

    public void speakBtnClick() {
        mNavigator.get().speakBtnClick();
    }

    public void setData(String text) {
        editTextContent.setValue(text);
        notifyPropertyChanged(BR.editTextContent);
    }

    public void moveToDetailActivity(ShoesItemModel obj) {
        mNavigator.get().moveToShoesDetailActivity(obj);
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String charString = constraint.toString();
                List<ShoesItemModel> filterList = new ArrayList<ShoesItemModel>();
                for (ShoesItemModel obj : originalShoesItemModelList) {
                    if (obj.getName().toLowerCase().contains(charString.toLowerCase()) ||
                            obj.getManufacturer().toLowerCase().contains(charString.toLowerCase())) {
                        filterList.add(obj);
                    }
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = filterList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                List<ShoesItemModel> filterList = (ArrayList<ShoesItemModel>) results.values;
                shoesItemMutableLiveData.setValue(filterList);
            }
        };
    }
}

