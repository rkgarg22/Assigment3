package com.demo.assigment3.adapter;


import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.demo.assigment3.databinding.ColorItemLayoutBinding;
import com.demo.assigment3.databinding.ShoesItemLayoutBinding;
import com.demo.assigment3.model.ColorItemModel;
import com.demo.assigment3.model.ShoesItemModel;
import com.demo.assigment3.view.ShoesListActivity;
import com.demo.assigment3.viewmodel.SelectColorViewModel;
import com.demo.assigment3.viewmodel.ShoesListViewModel;

import java.util.ArrayList;
import java.util.List;

public class ShoesListAdapter extends RecyclerView.Adapter<ShoesListAdapter.ViewHolder> {

    private List<ShoesItemModel> shoesItemModelsArrayList;

    public ShoesListAdapter() {
        this.shoesItemModelsArrayList = new ArrayList<>();
    }

    @Override
    public ShoesListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                          int viewType) {
        ShoesItemLayoutBinding itemLayoutBinding = ShoesItemLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false);
        ShoesListAdapter.ViewHolder viewHolder = new ShoesListAdapter.ViewHolder(itemLayoutBinding);
        ShoesListViewModel viewModel = new ShoesListViewModel();
        if(parent.getContext() instanceof ShoesListActivity) {
            viewModel.setNavigator(((ShoesListActivity) parent.getContext()));
        }
        itemLayoutBinding.setViewModel(viewModel);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ShoesListAdapter.ViewHolder holder, int position) {
        ShoesItemModel model = shoesItemModelsArrayList.get(position);
        holder.itemLayoutBinding.setItem(model);
    }

    @Override
    public int getItemCount() {
        return shoesItemModelsArrayList.size();
    }

    public void setData(List<ShoesItemModel> data) {
        this.shoesItemModelsArrayList.clear();
        this.shoesItemModelsArrayList.addAll(data);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ShoesItemLayoutBinding itemLayoutBinding;

        public ViewHolder(ShoesItemLayoutBinding itemLayoutBinding) {
            super(itemLayoutBinding.getRoot());
            this.itemLayoutBinding = itemLayoutBinding;
        }
    }
}
