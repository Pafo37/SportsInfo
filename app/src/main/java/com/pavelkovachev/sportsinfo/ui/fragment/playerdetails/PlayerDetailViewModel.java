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

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class PlayerDetailViewModel extends BaseViewModel {

    @Inject
    SportsApiService apiService;
    @Inject
    PlayerDbService playerDbService;

    private MutableLiveData<PlayerModel> playerDetails = new MutableLiveData<>();
    private MutableLiveData<String> playerName = new MutableLiveData<>();
    private MutableLiveData<String> playerNationality = new MutableLiveData<>();
    private MutableLiveData<String> playerTeam = new MutableLiveData<>();
    private MutableLiveData<String> playerHeight = new MutableLiveData<>();
    private MutableLiveData<String> playerDateOfBirth = new MutableLiveData<>();
    private MutableLiveData<String> playerBirthPlace = new MutableLiveData<>();
    private MutableLiveData<String> playerDescription = new MutableLiveData<>();
    private MutableLiveData<String> playerImage = new MutableLiveData<>();

    public MutableLiveData<String> getPlayerImage() {
        return playerImage;
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

    @Inject
    public PlayerDetailViewModel() {
    }

    public void getPlayerDetails(String playerId, String teamID) {
        subscribeSingle(apiService.getPlayers(teamID), new SingleObserver<PlayersListResponse>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onSuccess(PlayersListResponse playersListResponse) {
                if (playersListResponse.getPlayers() != null) {
                    List<PlayerModel> playerModelList = new ArrayList<>();
                    Stream.of(playersListResponse.getPlayers()).filter(player -> player.getIdPlayer().equals(playerId))
                            .forEach(playersResponse -> playerModelList.add(PlayerModel.convertToPlayerModel(playersResponse)));
                    playerDetails.setValue(playerModelList.get(0));
                    playerName.setValue(playerDetails.getValue().getPlayerName());
                    playerNationality.setValue(playerDetails.getValue().getPlayerNationality());
                    playerTeam.setValue(playerDetails.getValue().getPlayerTeamName());
                    playerHeight.setValue(playerDetails.getValue().getPlayerHeight());
                    playerDateOfBirth.setValue(playerDetails.getValue().getPlayerDateBorn());
                    playerBirthPlace.setValue(playerDetails.getValue().getPlayerBirthplace());
                    playerDescription.setValue(playerDetails.getValue().getPlayerDescription());
                    playerImage.setValue(playerDetails.getValue().getPlayerImage());
                    playerDbService.insertPlayers(playerModelList);
                }
            }

            @Override
            public void onError(Throwable e) {
                //TODO : add alert dialog
            }
        });

    }
}