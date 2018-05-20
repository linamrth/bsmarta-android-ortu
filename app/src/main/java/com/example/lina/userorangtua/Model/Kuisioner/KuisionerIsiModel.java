package com.example.lina.userorangtua.Model.Kuisioner;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class KuisionerIsiModel {

    @SerializedName("idkuisioner")
    @Expose
    private Integer idkuisioner;
    @SerializedName("idorangtua")
    @Expose
    private Integer idorangtua;
    @SerializedName("idsiswabelajar")
    @Expose
    private Integer idsiswabelajar;
    @SerializedName("idguru")
    @Expose
    private Integer idguru;
    @SerializedName("statuskuisioner")
    @Expose
    private String statuskuisioner;
    @SerializedName("tanggal")
    @Expose
    private String tanggal;
    @SerializedName("penguasaanmateri")
    @Expose
    private Integer penguasaanmateri;
    @SerializedName("kemampuanmengajar")
    @Expose
    private Integer kemampuanmengajar;
    @SerializedName("kedisiplinan")
    @Expose
    private Integer kedisiplinan;
    @SerializedName("tanggungjawabdantingkahlaku")
    @Expose
    private Integer tanggungjawabdantingkahlaku;
    @SerializedName("kerjasama")
    @Expose
    private Integer kerjasama;

    public Integer getIdkuisioner() {
        return idkuisioner;
    }

    public void setIdkuisioner(Integer idkuisioner) {
        this.idkuisioner = idkuisioner;
    }

    public Integer getIdorangtua() {
        return idorangtua;
    }

    public void setIdorangtua(Integer idorangtua) {
        this.idorangtua = idorangtua;
    }

    public Integer getIdsiswabelajar() {
        return idsiswabelajar;
    }

    public void setIdsiswabelajar(Integer idsiswabelajar) {
        this.idsiswabelajar = idsiswabelajar;
    }

    public Integer getIdguru() {
        return idguru;
    }

    public void setIdguru(Integer idguru) {
        this.idguru = idguru;
    }

    public String getStatuskuisioner() {
        return statuskuisioner;
    }

    public void setStatuskuisioner(String statuskuisioner) {
        this.statuskuisioner = statuskuisioner;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public Integer getPenguasaanmateri() {
        return penguasaanmateri;
    }

    public void setPenguasaanmateri(Integer penguasaanmateri) {
        this.penguasaanmateri = penguasaanmateri;
    }

    public Integer getKemampuanmengajar() {
        return kemampuanmengajar;
    }

    public void setKemampuanmengajar(Integer kemampuanmengajar) {
        this.kemampuanmengajar = kemampuanmengajar;
    }

    public Integer getKedisiplinan() {
        return kedisiplinan;
    }

    public void setKedisiplinan(Integer kedisiplinan) {
        this.kedisiplinan = kedisiplinan;
    }

    public Integer getTanggungjawabdantingkahlaku() {
        return tanggungjawabdantingkahlaku;
    }

    public void setTanggungjawabdantingkahlaku(Integer tanggungjawabdantingkahlaku) {
        this.tanggungjawabdantingkahlaku = tanggungjawabdantingkahlaku;
    }

    public Integer getKerjasama() {
        return kerjasama;
    }

    public void setKerjasama(Integer kerjasama) {
        this.kerjasama = kerjasama;
    }
}
