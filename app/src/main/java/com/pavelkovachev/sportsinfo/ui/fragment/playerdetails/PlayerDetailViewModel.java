package com.pavelkovachev.sportsinfo.ui.fragment.playerdetails;

import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

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

public class PlayerDetailViewModel extends BaseViewModel {

    @Inject
    SportsApiService apiService;

    @Inject
    PlayerDbService playerDbService;

    @Inject
    public PlayerDetailViewModel() {
    }

    private MutableLiveData<PlayerModel> playerDetails = new MutableLiveData<>();
    private MutableLiveData<String> playerName = new MutableLiveData<>();
    private MutableLiveData<String> playerNationality = new MutableLiveData<>();
    private MutableLiveData<String> playerTeam = new MutableLiveData<>();
    private MutableLiveData<String> playerHeight = new MutableLiveData<>();
    private MutableLiveData<String> playerDateOfBirth = new MutableLiveData<>();
    private MutableLiveData<String> playerBirthPlace = new MutableLiveData<>();
    private MutableLiveData<String> playerDescription = new MutableLiveData<>();
    private MutableLiveData<String> playerImage = new MutableLiveData<>();
    private MutableLiveData<Boolean> isErrorShown = new MutableLiveData<>();

    public MutableLiveData<String> getPlayerImage() {
        return playerImage;
    }

    public MutableLiveData<Boolean> getIsErrorShown() {
        return isErrorShown;
    }

    public SportsApiService getApiService() {
        return apiService;
    }

    public MutableLiveData<String> getPlayerNationality() {
        return playerNationality;
    }

    public MutableLiveData<String> getPlayerTeam() {
        return playerTeam;
    }

    public MutableLiveData<String> getPlayerHeight() {
        return playerHeight;
    }

    public MutableLiveData<String> getPlayerDateOfBirth() {
        return playerDateOfBirth;
    }

    public MutableLiveData<String> getPlayerBirthPlace() {
        return playerBirthPlace;
    }

    public MutableLiveData<String> getPlayerDescription() {
        return playerDescription;
    }

    public MutableLiveData<String> getPlayerName() {
        return playerName;
    }

    public void getPlayerDetails(String playerId, String teamID) {

        subscribeSingle(Single.zip(apiService.getPlayers(teamID),
                playerDbService.getAllPlayers(),
                this::getDataFromApiAndDb), new SingleObserver<List<PlayerModel>>() {
            @Override
            public void onSubscribe(Disposable d) {
                //NOT USED
            }

            @Override
            public void onSuccess(List<PlayerModel> playerModels) {
                setProgressBarVisibility(false);
                List<PlayerModel> playerModelList = new ArrayList<>();
                Stream.of(playerModels)
                        .filter(player -> player.getPlayerId().equals(playerId))
                        .forEach(playerModelList::add);
                playerDetails.setValue(playerModelList.get(0));
                playerName.setValue(playerDetails.getValue().getPlayerName());
                playerNationality.setValue(playerDetails.getValue().getPlayerNationality());
                playerTeam.setValue(playerDetails.getValue().getPlayerTeamName());
                playerHeight.setValue(playerDetails.getValue().getPlayerHeight());
                playerDateOfBirth.setValue(playerDetails.getValue().getPlayerDateBorn());
                playerBirthPlace.setValue(playerDetails.getValue().getPlayerBirthplace());
                playerDescription.setValue(playerDetails.getValue().getPlayerDescription());
                playerImage.setValue(playerDetails.getValue().getPlayerImage());
                playerDbService.insertPlayer(playerDetails.getValue());
            }

            @Override
            public void onError(Throwable e) {
                setProgressBarVisibility(false);
                isErrorShown.setValue(true);
            }
        });
    }

    private List<PlayerModel> getDataFromApiAndDb(PlayersListResponse playersListResponse,
                                                  List<PlayerModel> playerModels) {
        List<PlayerModel> playerModelList = new ArrayList<>();
        if (playersListResponse.getPlayers() != null) {
            Stream.of(playersListResponse.getPlayers())
                    .forEach(playersResponse -> playerModelList
                            .add(PlayerModel.convertToPlayerModel(playersResponse)));
        } else if (playerModels.size() != 0) {
            return playerModels;
        } else {
            throw new NullPointerException();
        }
        return playerModelList;
    }
}