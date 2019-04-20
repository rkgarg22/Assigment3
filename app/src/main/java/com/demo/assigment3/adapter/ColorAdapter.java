package com.demo.assigment3.adapter;


import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.demo.assigment3.databinding.ColorItemLayoutBinding;
import com.demo.assigment3.model.ColorItemModel;
import com.demo.assigment3.viewmodel.SelectColorViewModel;

import java.util.ArrayList;
import java.util.List;

public class ColorAdapter extends RecyclerView.Adapter<ColorAdapter.ViewHolder> {

    private List<ColorItemModel> colorItemModelArrayList;

    public ColorAdapter() {
        this.colorItemModelArrayList = new ArrayList<>();
    }

    @Override
    public ColorAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {
        ColorItemLayoutBinding itemLayoutBinding = ColorItemLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false);
        ColorAdapter.ViewHolder viewHolder = new ColorAdapter.ViewHolder(itemLayoutBinding);
        SelectColorViewModel viewModel = ViewModelProviders.of(((AppCompatActivity)parent.getContext())).get(SelectColorViewModel.class);
        itemLayoutBinding.setViewModel(viewModel);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ColorAdapter.ViewHolder holder, int position) {
        ColorItemModel model = colorItemModelArrayList.get(position);
        holder.itemLayoutBinding.checkImage.setVisibility(View.GONE);
        holder.itemLayoutBinding.setModel(model);
        holder.itemLayoutBinding.circleIcon.setSolidColor(model.getColorCode());
    }

    @Override
    public int getItemCount() {
        return colorItemModelArrayList.size();
    }

    public void setData(List<ColorItemModel> data) {
        this.colorItemModelArrayList.clear();
        this.colorItemModelArrayList.addAll(data);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ColorItemLayoutBinding itemLayoutBinding;

        public ViewHolder(ColorItemLayoutBinding itemLayoutBinding) {
            super(itemLayoutBinding.getRoot());
            this.itemLayoutBinding = itemLayoutBinding;
        }
    }
}
