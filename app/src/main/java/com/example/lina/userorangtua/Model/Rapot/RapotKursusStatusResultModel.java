package com.example.lina.userorangtua.Model.Rapot;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class RapotKursusStatusResultModel {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("jadwalgenerate")
    @Expose
    private ArrayList<RapotKursusStatusModel> jadwalgenerate = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<RapotKursusStatusModel> getJadwalgenerate() {
        return jadwalgenerate;
    }

    public void setJadwalgenerate(ArrayList<RapotKursusStatusModel> jadwalgenerate) {
        this.jadwalgenerate = jadwalgenerate;
    }
}
