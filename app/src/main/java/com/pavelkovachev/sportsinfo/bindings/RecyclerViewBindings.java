package com.pavelkovachev.sportsinfo.bindings;

import android.databinding.BindingAdapter;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class RecyclerViewBindings {

    @BindingAdapter({"items", "adapters"})
    public static <T, VH extends RecyclerView.ViewHolder> void setAdapterBindings(
            RecyclerView view, List<T> items, ListAdapter<T, VH> adapter) {
        if (view.getLayoutManager() == null) {
            view.setLayoutManager(new LinearLayoutManager(view.getContext(), RecyclerView.VERTICAL, false));
        }

        if (view.getAdapter() == null) {
            view.setAdapter(adapter);
        }
        adapter.submitList(items);
    }
}