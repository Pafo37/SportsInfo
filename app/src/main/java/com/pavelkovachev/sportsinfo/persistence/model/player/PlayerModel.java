package com.pavelkovachev.sportsinfo.persistence.model.player;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.pavelkovachev.sportsinfo.adapters.diffutil.DiffComparable;
import com.pavelkovachev.sportsinfo.network.response.players.PlayersResponse;

@Entity
public class PlayerModel implements DiffComparable {

    @NonNull
    @PrimaryKey
    private String playerId;

    @ColumnInfo(name = "player_name")
    private String playerName;

    @ColumnInfo(name = "player_image")
    private String playerImage;

    @ColumnInfo(name = "player_nationality")
    private String playerNationality;

    @ColumnInfo(name = "player_team_name")
    private String playerTeamName;

    @ColumnInfo(name = "player_height")
    private String playerHeight;

    @ColumnInfo(name = "player_date_born")
    private String playerDateBorn;

    @ColumnInfo(name = "player_birthplace")
    private String playerBirthplace;

    @ColumnInfo(name = "player_description")
    private String playerDescription;

    public PlayerModel(String playerId, String playerImage, String playerName, String playerNationality, String playerTeamName,
                       String playerHeight, String playerDateBorn, String playerBirthplace,
                       String playerDescription) {
        this.playerId = playerId;
        this.playerImage = playerImage;
        this.playerName = playerName;
        this.playerNationality = playerNationality;
        this.playerTeamName = playerTeamName;
        this.playerHeight = playerHeight;
        this.playerDateBorn = playerDateBorn;
        this.playerBirthplace = playerBirthplace;
        this.playerDescription = playerDescription;
    }

    public String getPlayerId() {
        return playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getPlayerNationality() {
        return playerNationality;
    }

    public String getPlayerTeamName() {
        return playerTeamName;
    }

    public String getPlayerHeight() {
        return playerHeight;
    }

    public String getPlayerDateBorn() {
        return playerDateBorn;
    }

    public String getPlayerBirthplace() {
        return playerBirthplace;
    }

    public String getPlayerDescription() {
        return playerDescription;
    }

    public String getPlayerImage() {
        return playerImage;
    }

    public void setPlayerImage(String playerImage) {
        this.playerImage = playerImage;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setPlayerNationality(String playerNationality) {
        this.playerNationality = playerNationality;
    }

    public void setPlayerTeamName(String playerTeamName) {
        this.playerTeamName = playerTeamName;
    }

    public void setPlayerHeight(String playerHeight) {
        this.playerHeight = playerHeight;
    }

    public void setPlayerDateBorn(String playerDateBorn) {
        this.playerDateBorn = playerDateBorn;
    }

    public void setPlayerBirthplace(String playerBirthplace) {
        this.playerBirthplace = playerBirthplace;
    }

    public void setPlayerDescription(String playerDescription) {
        this.playerDescription = playerDescription;
    }

    @Override
    public boolean isItemTheSameAs(Object newItem) {
        PlayerModel newPlayer = (PlayerModel) newItem;
        return newPlayer.getPlayerId() == newPlayer.getPlayerId();
    }

    @Override
    public boolean areContentsTheSameAs(Object newItem) {
        PlayerModel newPlayer = (PlayerModel) newItem;
        return this == newPlayer;
    }

    public static PlayerModel convertToPlayerModel(PlayersResponse playersResponse) {
        return new PlayerModel(
                playersResponse.getIdPlayer(),
                playersResponse.getStrThumb(),
                playersResponse.getStrPlayer(),
                playersResponse.getStrNationality(),
                playersResponse.getStrTeam(),
                playersResponse.getStrHeight(),
                playersResponse.getDateBorn(),
                playersResponse.getStrBirthLocation(),
                playersResponse.getStrDescriptionEN());
    }
}