/*
 *  Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      https://mindorks.com/license/apache-v2
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License
 */

package com.demo.assigment3.utils;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import com.demo.assigment3.adapter.ColorAdapter;
import com.demo.assigment3.adapter.ShoesListAdapter;
import com.demo.assigment3.model.ColorItemModel;
import com.demo.assigment3.model.ShoesItemModel;

import java.util.List;


public final class BindingUtils {

    private BindingUtils() {
        // This class is not publicly instantiable
    }

    @BindingAdapter({"adapter"})
    public static void addCatItems(RecyclerView recyclerView, List<ColorItemModel> colorData) {
        ColorAdapter adapter = (ColorAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.setData(colorData);
        }
    }

    @BindingAdapter({"adapter"})
    public static void addShoesItem(RecyclerView recyclerView, List<ShoesItemModel> shoesItemModelList) {
        ShoesListAdapter adapter = (ShoesListAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.setData(shoesItemModelList);
        }
    }

}
