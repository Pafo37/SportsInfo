package com.pavelkovachev.sportsinfo.persistence.model.sport;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class SportModel {

    @NonNull
    @PrimaryKey()
    private int sportId;

    @ColumnInfo(name = "sport_name")
    private String sportName;

    @ColumnInfo(name = "sport_image")
    private String sportImage;

    @ColumnInfo(name = "sport_description")
    private String sportDescription;

    public SportModel(int sportId, String sportName, String sportImage, String sportDescription) {
        this.sportId = sportId;
        this.sportName = sportName;
        this.sportImage = sportImage;
        this.sportDescription = sportDescription;
    }

    public int getSportId() {
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

    public void setSportId(int sportId) {
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
}