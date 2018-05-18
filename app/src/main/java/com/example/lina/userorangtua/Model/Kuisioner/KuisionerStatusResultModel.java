package com.example.lina.userorangtua.Model.Kuisioner;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class KuisionerStatusResultModel {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("results")
    @Expose
    private ArrayList<KuisionerStatusModel> results = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<KuisionerStatusModel> getResults() {
        return results;
    }

    public void setResults(ArrayList<KuisionerStatusModel> results) {
        this.results = results;
    }

}
