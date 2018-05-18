package com.example.lina.userorangtua.Model.Kuisioner;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class KuisionerStatusModel {
    @SerializedName("tanggal")
    @Expose
    private String tanggal;
    @SerializedName("namaguru")
    @Expose
    private String namaguru;
    @SerializedName("statuskuisioner")
    @Expose
    private String statuskuisioner;
    @SerializedName("idkuisioner")
    @Expose
    private String idkuisioner;

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getNamaguru() {
        return namaguru;
    }

    public void setNamaguru(String namaguru) {
        this.namaguru = namaguru;
    }

    public String getStatuskuisioner() {
        return statuskuisioner;
    }

    public void setStatuskuisioner(String statuskuisioner) {
        this.statuskuisioner = statuskuisioner;
    }

    public String getIdkuisioner() {
        return idkuisioner;
    }

    public void setIdkuisioner(String idkuisioner) {
        this.idkuisioner = idkuisioner;
    }
}
