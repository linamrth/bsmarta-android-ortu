package com.example.lina.userorangtua.Model.Rapot;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class DetailRapotTrialResultModel {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("results")
    @Expose
    private ArrayList<DetailRapotTrialModel> results = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<DetailRapotTrialModel> getResults() {
        return results;
    }

    public void setResults(ArrayList<DetailRapotTrialModel> results) {
        this.results = results;
    }
}
