package com.pavelkovachev.sportsinfo.ui.fragment.tvevents;

import android.arch.lifecycle.MutableLiveData;

import com.annimon.stream.Stream;
import com.pavelkovachev.sportsinfo.network.SportsApiService;
import com.pavelkovachev.sportsinfo.network.response.tvevents.TvEventsListResponse;
import com.pavelkovachev.sportsinfo.persistence.model.tvevent.TvEventModel;
import com.pavelkovachev.sportsinfo.services.TvEventDbService;
import com.pavelkovachev.sportsinfo.ui.fragment.base.BaseViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class TvEventsViewModel extends BaseViewModel {

    @Inject
    SportsApiService apiService;

    @Inject
    TvEventDbService tvEventDbService;

    private MutableLiveData<List<TvEventModel>> tvEventsList = new MutableLiveData<>();
    private MutableLiveData<String> eventDate = new MutableLiveData<>();
    private MutableLiveData<Boolean> isErrorShown = new MutableLiveData<>();

    @Inject
    public TvEventsViewModel() {
    }

    public MutableLiveData<String> getEventDate() {
        return eventDate;
    }

    public MutableLiveData<List<TvEventModel>> getTvEventsList() {
        return tvEventsList;
    }

    public MutableLiveData<Boolean> getIsErrorShown() {
        return isErrorShown;
    }

    public void getTvEvents() {
        subscribeSingle(apiService.getTvEvents(eventDate.getValue()),
                new SingleObserver<TvEventsListResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        //NOT USED
                    }

                    @Override
                    public void onSuccess(TvEventsListResponse tvEventsListResponse) {
                        if (tvEventsListResponse.getTvEvents() != null) {
                            List<TvEventModel> tvEventModels = new ArrayList<>();
                            Stream.of(tvEventsListResponse.getTvEvents()).forEach(
                                    tvEventsResponse ->
                                            tvEventModels.add(TvEventModel.convertToTvEventModel(tvEventsResponse)));
                            tvEventDbService.insertTvEvents(tvEventModels);
                            tvEventsList.setValue(tvEventModels);
                        } else {
                            isErrorShown.setValue(true);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        isErrorShown.postValue(true);
                    }
                });
    }
}