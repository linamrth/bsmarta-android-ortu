package com.example.lina.userorangtua.Model.Jadwal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class DetailJadwalKursusResultModel {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("result")
    @Expose
    private ArrayList<DetailJadwalKursusModel> result = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<DetailJadwalKursusModel> getResult() {
        return result;
    }

    public void setResult(ArrayList<DetailJadwalKursusModel> result) {
        this.result = result;
    }
}
