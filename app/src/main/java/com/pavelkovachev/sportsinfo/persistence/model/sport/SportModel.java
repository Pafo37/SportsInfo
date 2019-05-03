package com.pavelkovachev.sportsinfo.persistence.model.sport;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.pavelkovachev.sportsinfo.adapters.diffutil.DiffComparable;
import com.pavelkovachev.sportsinfo.network.response.sports.SportsResponse;

@Entity
public class SportModel implements DiffComparable {

    @NonNull
    @PrimaryKey()
    private String sportId;

    @ColumnInfo(name = "sport_name")
    private String sportName;

    @ColumnInfo(name = "sport_image")
    private String sportImage;

    @ColumnInfo(name = "sport_description")
    private String sportDescription;

    public SportModel(String sportId, String sportName, String sportImage, String sportDescription) {
        this.sportId = sportId;
        this.sportName = sportName;
        this.sportImage = sportImage;
        this.sportDescription = sportDescription;
    }

    public String getSportId() {
        return sportId;
    }

    public String getSportName() {
        return sportName;
    }

    public String getSportImage() {
        return sportImage;
    }

    public String getSportDescription() {
        return sportDescription;
    }

    public void setSportId(String sportId) {
        this.sportId = sportId;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public void setSportImage(String sportImage) {
        this.sportImage = sportImage;
    }

    public void setSportDescription(String sportDescription) {
        this.sportDescription = sportDescription;
    }

    @Override
    public boolean isItemTheSameAs(Object newItem) {
        SportModel newSport = (SportModel) newItem;
        return this.getSportId() == newSport.getSportId();
    }

    @Override
    public boolean areContentsTheSameAs(Object newItem) {
        SportModel newSport = (SportModel) newItem;
        return this == newSport;
    }

    public static SportModel convertToSportModel(SportsResponse sportsResponse) {

        return new SportModel(sportsResponse.getIdSport(), sportsResponse.getStrSport(),
                sportsResponse.getStrSportThumb(), sportsResponse.getStrSportDescription());
    }
}