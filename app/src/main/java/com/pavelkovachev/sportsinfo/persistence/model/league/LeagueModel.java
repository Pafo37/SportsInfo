package com.pavelkovachev.sportsinfo.persistence.model.league;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.pavelkovachev.sportsinfo.adapters.diffutil.DiffComparable;
import com.pavelkovachev.sportsinfo.network.response.leagues.LeaguesResponse;

@Entity
public class LeagueModel implements DiffComparable {

    @NonNull
    @PrimaryKey
    private String leagueId;

    @ColumnInfo(name = "league_name")
    private String leagueName;

    @ColumnInfo(name = "league_sport")
    private String leagueSport;

    public LeagueModel(String leagueId, String leagueName, String leagueSport) {
        this.leagueId = leagueId;
        this.leagueName = leagueName;
        this.leagueSport = leagueSport;
    }

    public String getLeagueId() {
        return leagueId;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public String getLeagueSport() {
        return leagueSport;
    }

    public void setLeagueId(String leagueId) {
        this.leagueId = leagueId;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public void setLeagueSport(String leagueSport) {
        this.leagueSport = leagueSport;
    }

    public static LeagueModel convertToLeagueModel(LeaguesResponse leaguesResponse) {
        return new LeagueModel(
                leaguesResponse.getIdLeague(),
                leaguesResponse.getStrLeague(),
                leaguesResponse.getStrSport());
    }

    @Override
    public boolean isItemTheSameAs(Object newItem) {
        LeagueModel newLeague = (LeagueModel) newItem;
        return this.getLeagueId() == newLeague.getLeagueId();
    }

    @Override
    public boolean areContentsTheSameAs(Object newItem) {
        LeagueModel newLeague = (LeagueModel) newItem;
        return this == newLeague;
    }
}