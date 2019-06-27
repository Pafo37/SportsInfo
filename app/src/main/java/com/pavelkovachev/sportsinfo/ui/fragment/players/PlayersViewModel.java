package com.pavelkovachev.sportsinfo.ui.fragment.players;

import android.arch.lifecycle.MutableLiveData;

import com.annimon.stream.Stream;
import com.pavelkovachev.sportsinfo.network.SportsApiService;
import com.pavelkovachev.sportsinfo.network.response.players.PlayersListResponse;
import com.pavelkovachev.sportsinfo.persistence.model.player.PlayerModel;
import com.pavelkovachev.sportsinfo.services.PlayerDbService;
import com.pavelkovachev.sportsinfo.ui.fragment.base.BaseViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class PlayersViewModel extends BaseViewModel {

    private MutableLiveData<List<PlayerModel>> playerList = new MutableLiveData<>();
    private MutableLiveData<Boolean> isErrorShown = new MutableLiveData<>();
    private MutableLiveData<String> playerId = new MutableLiveData<>();
    private MutableLiveData<Boolean> isPlayerClicked = new MutableLiveData<>();

    public MutableLiveData<List<PlayerModel>> getPlayerList() {
        return playerList;
    }

    public MutableLiveData<Boolean> getIsErrorShown() {
        return isErrorShown;
    }

    public MutableLiveData<String> getPlayerId() {
        return playerId;
    }

    public MutableLiveData<Boolean> getIsPlayerClicked() {
        return isPlayerClicked;
    }

    @Inject
    SportsApiService apiService;
    @Inject
    PlayerDbService playerDbService;

    @Inject
    public PlayersViewModel() {
    }

    public void getPlayers(String teamId) {
        subscribeSingle(apiService.getPlayers(teamId), new SingleObserver<PlayersListResponse>() {
            @Override
            public void onSubscribe(Disposable d) {
                //NOT USED
            }

            @Override
            public void onSuccess(PlayersListResponse playersListResponse) {
                if (playersListResponse.getPlayers() != null) {
                    List<PlayerModel> playerModelList = new ArrayList<>();
                    Stream.of(playersListResponse.getPlayers())
                            .forEach(playersResponse -> playerModelList.add(PlayerModel.convertToPlayerModel(playersResponse)));
                    playerList.setValue(playerModelList);
                    playerDbService.insertPlayers(playerModelList);
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

    public void onPlayerClicked(PlayerModel playerModel) {
        playerId.setValue(playerModel.getPlayerId());
        isPlayerClicked.setValue(true);
    }
}