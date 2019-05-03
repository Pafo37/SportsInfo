package com.pavelkovachev.sportsinfo.adapters.diffutil;

import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;

public class ItemDiffUtil<T extends DiffComparable<T>> extends DiffUtil.ItemCallback<T> {

    @Override
    public boolean areItemsTheSame(@NonNull T oldItem, @NonNull T newItem) {
        return oldItem.isItemTheSameAs(newItem);
    }

    @Override
    public boolean areContentsTheSame(@NonNull T oldItem, @NonNull T newItem) {
        return oldItem.areContentsTheSameAs(newItem);
    }
}