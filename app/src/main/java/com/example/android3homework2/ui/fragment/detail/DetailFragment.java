package com.example.android3homework2.ui.fragment.detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.example.android3homework2.databinding.FragmentDetailBinding;



public class DetailFragment extends Fragment {
    private FragmentDetailBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String name = DetailFragmentArgs.fromBundle(getArguments()).getModel().getName();
        String description = DetailFragmentArgs.fromBundle(getArguments()).getModel().getDescription();
        binding.detailFragment.setText(name);
        binding.detailDes.setText(description);
    }
}