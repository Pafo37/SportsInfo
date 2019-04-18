package com.pavelkovachev.sportsinfo.adapters;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;

import com.pavelkovachev.sportsinfo.persistence.model.sport.SportModel;

public class HomeScreenDiffCallback extends DiffUtil.ItemCallback<SportModel> {

    @Override
    public boolean areItemsTheSame(@NonNull SportModel oldItem, @NonNull SportModel newItem) {
        return oldItem.getSportId() == newItem.getSportId();
    }

    @Override
    public boolean areContentsTheSame(@NonNull SportModel oldItem, @NonNull SportModel newItem) {
        return oldItem == newItem;
    }
}
