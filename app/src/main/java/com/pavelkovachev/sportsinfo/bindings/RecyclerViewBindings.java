package com.pavelkovachev.sportsinfo.bindings;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.BindingAdapter;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.pavelkovachev.sportsinfo.adapters.BaseDiffUtilAdapter;
import com.pavelkovachev.sportsinfo.adapters.diffutil.DiffComparable;
import com.pavelkovachev.sportsinfo.adapters.diffutil.ItemDiffUtil;
import com.pavelkovachev.sportsinfo.ui.fragment.base.BaseViewModel;

import java.util.List;

public class RecyclerViewBindings {

    @BindingAdapter(value = {"items", "layoutId", "vm"}, requireAll = false)
    public static <T extends DiffComparable<T>> void setAdapterBindings(
            RecyclerView view, MutableLiveData<List<T>> items, int itemLayoutId, BaseViewModel viewModel) {
        if (view.getLayoutManager() == null) {
            view.setLayoutManager(new LinearLayoutManager(view.getContext(), RecyclerView.VERTICAL, false));
        }

        if (view.getAdapter() == null) {
            BaseDiffUtilAdapter<T> adapter = new BaseDiffUtilAdapter<>(new ItemDiffUtil<T>(), itemLayoutId, viewModel);
            view.setAdapter(adapter);
        } else {
            ((ListAdapter) view.getAdapter()).submitList(items.getValue());
        }
    }
}