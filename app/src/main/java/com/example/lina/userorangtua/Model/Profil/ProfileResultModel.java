package com.example.lina.userorangtua.Model.Profil;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProfileResultModel {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("results")
    @Expose
    private ProfileModel results;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ProfileModel getResults() {
        return results;
    }

    public void setResults(ProfileModel results) {
        this.results = results;
    }
}
