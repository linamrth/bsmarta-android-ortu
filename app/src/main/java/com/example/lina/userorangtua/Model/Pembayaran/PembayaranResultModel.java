package com.example.lina.userorangtua.Model.Pembayaran;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PembayaranResultModel {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("results")
    @Expose
    private ArrayList<PembayaranModel> results = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<PembayaranModel> getResults() {
        return results;
    }

    public void setResults(ArrayList<PembayaranModel> results) {
        this.results = results;
    }
}
