package com.demo.assigment3.view;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.WindowManager;

import com.demo.assigment3.R;
import com.demo.assigment3.adapter.ShoesListAdapter;
import com.demo.assigment3.databinding.ActivityShoesSearchBinding;
import com.demo.assigment3.model.ShoesItemModel;
import com.demo.assigment3.navigation.ShoesListActivityNavigator;
import com.demo.assigment3.viewmodel.ShoesListViewModel;
import com.google.gson.Gson;

import java.util.ArrayList;

public class ShoesListActivity extends AppCompatActivity implements ShoesListActivityNavigator {

    private ShoesListViewModel shoesListViewModel;
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        initDataBinding();
        subscribeToLiveData();
        subscribeToSearchText();
    }

    private void initDataBinding() {
        ActivityShoesSearchBinding shoesSearchBinding = DataBindingUtil.setContentView(this, R.layout.activity_shoes_search);
        //shoesListViewModel = ViewModelProviders.of(this).get(ShoesListViewModel.class);
        shoesListViewModel = new ShoesListViewModel();
        shoesSearchBinding.setViewModel(shoesListViewModel);

        layoutManager = new LinearLayoutManager(this);
        shoesSearchBinding.shoesListRecyclerView.setLayoutManager(layoutManager);

        ShoesListAdapter adapter = new ShoesListAdapter();
        shoesSearchBinding.shoesListRecyclerView.setAdapter(adapter);
        shoesSearchBinding.shoesListRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        shoesListViewModel.setNavigator(this);
        shoesListViewModel.loadShoesData();
    }

    public void subscribeToLiveData() {
        shoesListViewModel.getShoesItemMutableLiveData().observe(this, shoesItemModelList -> {
            shoesListViewModel.setShoesItemArrayList(shoesItemModelList);
        });
    }

    @Override
    public void backBtnClick() {
        this.finish();
    }

    @Override
    public void speakBtnClick() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Voice searching...");
        startActivityForResult(intent, 100);
    }

    @Override
    public void moveToShoesDetailActivity(ShoesItemModel obj) {

        Gson gson = new Gson();
        String objStr = gson.toJson(obj);
        Intent shoesDetailActivity = new Intent(this, ShoesDetailActivity.class);
        shoesDetailActivity.putExtra("object", objStr);
        startActivity(shoesDetailActivity);
    }

    public void subscribeToSearchText() {
        shoesListViewModel.editTextContent.observe(this, text -> {
            shoesListViewModel.getFilter().filter(text);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 100 && resultCode == RESULT_OK) {
            final ArrayList<String> matches = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            if (!matches.isEmpty()) {
                String searchText = matches.get(0);
                shoesListViewModel.setData(searchText);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
