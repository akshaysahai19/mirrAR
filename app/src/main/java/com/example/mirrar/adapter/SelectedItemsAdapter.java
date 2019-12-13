package com.example.mirrar.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mirrar.R;
import com.example.mirrar.databinding.SelectedRecyclerviewLayoutBinding;
import com.example.mirrar.models.Items;

import java.util.ArrayList;

public class SelectedItemsAdapter extends RecyclerView.Adapter<SelectedItemsAdapter.SelectedItemViewHolder> {

    private ArrayList<Items> itemsArrayList;
    private Context context;

    public SelectedItemsAdapter(ArrayList<Items> itemsArrayList, Context context) {
        this.itemsArrayList = itemsArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public SelectedItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        SelectedRecyclerviewLayoutBinding selectedRecyclerviewLayoutBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.selected_recyclerview_layout, parent, false);
        return new SelectedItemViewHolder(selectedRecyclerviewLayoutBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull SelectedItemViewHolder holder, int position) {
            holder.selectedRecyclerviewLayoutBinding.name.setText(itemsArrayList.get(position).getName());
        holder.selectedRecyclerviewLayoutBinding.selected.setText(itemsArrayList.get(position).getValue());
        holder.selectedRecyclerviewLayoutBinding.amount.setText(String.valueOf(itemsArrayList.get(position).getAmount()));
    }

    @Override
    public int getItemCount() {
        return itemsArrayList.size();
    }

    public class SelectedItemViewHolder extends RecyclerView.ViewHolder {

        private SelectedRecyclerviewLayoutBinding selectedRecyclerviewLayoutBinding;

        public SelectedItemViewHolder(@NonNull SelectedRecyclerviewLayoutBinding itemView) {
            super(itemView.getRoot());

            this.selectedRecyclerviewLayoutBinding = itemView;
        }
    }

    public void setItemsArrayList(ArrayList<Items> itemsArrayList) {
        this.itemsArrayList = itemsArrayList;
        notifyDataSetChanged();
    }
}
