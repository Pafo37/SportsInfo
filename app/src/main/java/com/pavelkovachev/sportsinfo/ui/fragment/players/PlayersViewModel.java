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

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class PlayersViewModel extends BaseViewModel {

    @Inject
    SportsApiService apiService;

    @Inject
    PlayerDbService playerDbService;

    @Inject
    public PlayersViewModel() {
    }

    private MutableLiveData<List<PlayerModel>> playerList = new MutableLiveData<>();
    private MutableLiveData<Boolean> isErrorShown = new MutableLiveData<>();
    private MutableLiveData<String> playerId = new MutableLiveData<>();
    private MutableLiveData<String> playerName = new MutableLiveData<>();
    private MutableLiveData<Boolean> isPlayerClicked = new MutableLiveData<>();

    public MutableLiveData<String> getPlayerName() {
        return playerName;
    }

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

    public void getPlayers(String teamId) {

        subscribeSingle(Single.zip(
                apiService.getPlayers(teamId).onErrorReturnItem(new PlayersListResponse()),
                playerDbService.getAllPlayers(), this::getDataFromApiAndDb),
                new SingleObserver<List<PlayerModel>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        //NOT USED
                    }

                    @Override
                    public void onSuccess(List<PlayerModel> playerModels) {
                        playerDbService.insertPlayers(playerModels);
                        playerList.setValue(playerModels);
                    }

                    @Override
                    public void onError(Throwable e) {
                        isErrorShown.setValue(true);
                    }
                });
    }

    public void onPlayerClicked(PlayerModel playerModel) {
        playerId.setValue(playerModel.getPlayerId());
        playerName.setValue(playerModel.getPlayerName());
        isPlayerClicked.setValue(true);
    }

    private List<PlayerModel> getDataFromApiAndDb(PlayersListResponse playersListResponse,
                                                  List<PlayerModel> playerModels) {
        List<PlayerModel> playerModelList = new ArrayList<>();
        if (playersListResponse.getPlayers() != null) {
            Stream.of(playersListResponse.getPlayers())
                    .forEach(playersResponse -> playerModelList.add(PlayerModel.convertToPlayerModel(playersResponse)));

        } else if (playerModels != null) {
            return playerModels;
        } else {
            throw new NullPointerException();
        }
        return playerModelList;
    }
}