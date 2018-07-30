package com.example.lina.userorangtua.Model.Kuisioner;

import com.example.lina.userorangtua.Api.ApiService;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class KuisionerStatusModel {
    @SerializedName("foto")
    @Expose
    private String foto;
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
    private Integer idkuisioner;

    public String getFoto() {
        return ApiService.BASE_URL_FOTO+foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

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

    public Integer getIdkuisioner() {
        return idkuisioner;
    }

    public void setIdkuisioner(Integer idkuisioner) {
        this.idkuisioner = idkuisioner;
    }
}
