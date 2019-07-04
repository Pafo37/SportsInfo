package com.pavelkovachev.sportsinfo.ui.fragment.allevents;

import android.arch.lifecycle.MutableLiveData;

import com.annimon.stream.Stream;
import com.pavelkovachev.sportsinfo.network.SportsApiService;
import com.pavelkovachev.sportsinfo.network.response.events.EventsListResponse;
import com.pavelkovachev.sportsinfo.persistence.model.event.EventModel;
import com.pavelkovachev.sportsinfo.services.EventDbService;
import com.pavelkovachev.sportsinfo.ui.fragment.base.BaseViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class AllEventsViewModel extends BaseViewModel {

    @Inject
    SportsApiService apiService;

    @Inject
    EventDbService eventDbService;

    @Inject
    public AllEventsViewModel() {
    }

    private MutableLiveData<String> eventDate = new MutableLiveData<>();
    private MutableLiveData<List<EventModel>> allEventsList = new MutableLiveData<>();
    private MutableLiveData<Boolean> isErrorShown = new MutableLiveData<>();

    public MutableLiveData<String> getEventDate() {
        return eventDate;
    }

    public MutableLiveData<List<EventModel>> getAllEventsList() {
        return allEventsList;
    }

    public MutableLiveData<Boolean> getIsErrorShown() {
        return isErrorShown;
    }

    public void getAllEvents() {
        subscribeSingle(apiService.getEvents(eventDate.getValue()),
                new SingleObserver<EventsListResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        //NOT USED
                    }

                    @Override
                    public void onSuccess(EventsListResponse eventsListResponse) {
                        if (eventsListResponse.getEvents() != null) {
                            List<EventModel> eventModelList = new ArrayList<>();
                            Stream.of(eventsListResponse.getEvents()).forEach(
                                    eventsResponse ->
                                            eventModelList.add(EventModel.convertToEventModel(eventsResponse))
                            );
                            eventDbService.insertAllEvents(eventModelList);
                            allEventsList.setValue(eventModelList);
                        } else {
                            isErrorShown.setValue(true);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        isErrorShown.setValue(true);
                    }
                });
    }
}