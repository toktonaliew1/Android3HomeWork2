package com.example.android3homework2.ui.fragment.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.android3homework2.adapter.Adapter;
import com.example.android3homework2.databinding.FragmentHomeBinding;
import com.example.android3homework2.model.MainModel;
import com.example.android3homework2.ui.fragment.ItemClick;


import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;
    private HomeViewModel viewModel;
    public Adapter adapter = new Adapter();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        initAdapter();
        addObserver();
        getList();
    }

    private void initAdapter() {
        binding.homeRecycler.setAdapter(adapter);
        adapter.setItemClick(new ItemClick() {
            @Override
            public void itemClick(MainModel mainModel) {
                Navigation.findNavController(requireView()).
                        navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment(mainModel));

            }
        });
    }

    private void addObserver() {
        viewModel.mutableLiveData.observe(getViewLifecycleOwner(), new Observer<ArrayList<MainModel>>() {
            @Override
            public void onChanged(ArrayList<MainModel> mainModels) {
                adapter.setList(mainModels);
            }
        });
    }

    private void getList()   {
        viewModel.getList();
    }
}