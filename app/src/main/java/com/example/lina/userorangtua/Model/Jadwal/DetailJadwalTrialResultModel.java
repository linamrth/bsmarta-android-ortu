package com.example.lina.userorangtua.Model.Jadwal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class DetailJadwalTrialResultModel {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("result")
    @Expose
    private ArrayList<DetailJadwalTrialModel> result = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<DetailJadwalTrialModel> getResult() {
        return result;
    }

    public void setResult(ArrayList<DetailJadwalTrialModel> result) {
        this.result = result;
    }
}
