package com.pavelkovachev.sportsinfo.ui.fragment.events;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import androidx.navigation.Navigation;

import com.pavelkovachev.sportsinfo.Constants;
import com.pavelkovachev.sportsinfo.R;
import com.pavelkovachev.sportsinfo.databinding.FragmentEventsBinding;
import com.pavelkovachev.sportsinfo.ui.fragment.base.BaseFragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class EventsFragment extends BaseFragment<EventsViewModel, FragmentEventsBinding> {

    private String date;
    private boolean isTvEventsClicked = true;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_events;
    }

    @Override
    protected Class<EventsViewModel> getViewModel() {
        return EventsViewModel.class;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.DATE_FORMAT_PATTERN);
        date = dateFormat.format(calendar.getTime());

        binding.calendarView.setOnDayClickListener(eventDay -> {
            Calendar clickedDayCalendar = eventDay.getCalendar();
            date = dateFormat.format(clickedDayCalendar.getTime());
        });

        binding.radioBtnGroupEvents.setOnCheckedChangeListener((group, checkedId) -> {
            checkedId = group.getCheckedRadioButtonId();
            if (binding.radioBtnAllEvents.equals(view.findViewById(checkedId))) {
                isTvEventsClicked = false;
            } else {
                isTvEventsClicked = true;
            }
        });

        binding.btnSearchEvents.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString(Constants.BUNDLE_DATE, date);
            if (isTvEventsClicked) {
                Navigation.findNavController(view).navigate(R.id.action_nav_events_to_tvEventsFragment, bundle);
            } else {
                Navigation.findNavController(view).navigate(R.id.action_nav_events_to_allEventsFragment, bundle);
            }
        });
    }
}