
package com.example.android3homework2.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android3homework2.databinding.ListBinding;
import com.example.android3homework2.model.MainModel;
import com.example.android3homework2.ui.fragment.ItemClick;


import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private ItemClick itemClick;
    private ArrayList<MainModel> list = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListBinding binding = ListBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setItemClick(ItemClick itemClick) {
        this.itemClick = itemClick;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setList(ArrayList<MainModel> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
      private ListBinding binding;

        public ViewHolder(@NonNull ListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public void onBind(MainModel mainModel) {
            binding.name.setText(mainModel.getName());
            binding.description.setText(mainModel.getDescription());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemClick.itemClick(mainModel);
                }
            });
        }
    }
}
