package com.pavelkovachev.sportsinfo.adapters;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.pavelkovachev.sportsinfo.R;
import com.pavelkovachev.sportsinfo.databinding.ItemHomescreenBinding;
import com.pavelkovachev.sportsinfo.persistence.model.sport.SportModel;

public class HomeScreenAdapter extends ListAdapter<SportModel, HomeScreenAdapter.HomeScreenViewHolder> {

    private onSportClickListener onSportClickListener;

    public HomeScreenAdapter(@NonNull HomeScreenDiffCallback diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public HomeScreenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        ItemHomescreenBinding itemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext())
                , R.layout.item_homescreen, parent, false);
        return new HomeScreenViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeScreenViewHolder viewHolder, int position) {
        viewHolder.bind(getItem(position));
    }

    public void setOnSportClickListener(onSportClickListener onSportClickListener) {
        this.onSportClickListener = onSportClickListener;
    }

    class HomeScreenViewHolder extends RecyclerView.ViewHolder {

        private SportModel sportModel;
        private onSportClickListener onSportClickListener;
        private final ItemHomescreenBinding binding;

        public HomeScreenViewHolder(ItemHomescreenBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(SportModel sportModel) {
            binding.setSport(sportModel);
            binding.executePendingBindings();
        }

        void onClick() {
            onSportClickListener.onClick(this.sportModel);
        }
    }

    public interface onSportClickListener {
        void onClick(SportModel sportModel);
    }
}