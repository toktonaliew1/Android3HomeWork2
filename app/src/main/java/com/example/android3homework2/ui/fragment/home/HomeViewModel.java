package com.example.android3homework2.ui.fragment.home;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.android3homework2.model.MainModel;


import java.util.ArrayList;

public  class HomeViewModel extends ViewModel {
    public MutableLiveData<ArrayList<MainModel>> mutableLiveData = new MutableLiveData<>();
    public ArrayList<MainModel> list = new ArrayList<>();

    public void getList() {
        list.clear();
        list.add(new MainModel("alexandr", "android 3"));
        list.add(new MainModel("fatma", "android 3"));
        list.add(new MainModel("aman", "android 3"));
        list.add(new MainModel("arsen", "android 3"));
        mutableLiveData.setValue(list);
    }
}
