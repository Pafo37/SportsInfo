package com.pavelkovachev.sportsinfo.adapters;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.pavelkovachev.sportsinfo.BR;
import com.pavelkovachev.sportsinfo.adapters.diffutil.DiffComparable;
import com.pavelkovachev.sportsinfo.ui.fragment.base.BaseViewModel;

public class BaseDiffUtilAdapter<T extends DiffComparable> extends ListAdapter<T, BaseDiffUtilAdapter.ViewHolder> {

    private int itemLayoutId;
    private BaseViewModel viewModel;

    public BaseDiffUtilAdapter(@NonNull DiffUtil.ItemCallback<T> diffCallback, int itemLayoutId, BaseViewModel viewModel) {
        super(diffCallback);
        this.itemLayoutId = itemLayoutId;
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        ViewDataBinding itemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), itemLayoutId, parent, false);
        return new ViewHolder<>(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.getBinding().setVariable(BR.item, getItem(position));
        viewHolder.getBinding().setVariable(BR.viewModel, viewModel);
        viewHolder.getBinding().executePendingBindings();
    }

    static class ViewHolder<DB extends ViewDataBinding> extends RecyclerView.ViewHolder {

        private DB binding;

        private ViewHolder(@NonNull DB binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public DB getBinding() {
            return binding;
        }
    }
}