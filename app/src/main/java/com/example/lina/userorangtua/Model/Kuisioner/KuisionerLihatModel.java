package com.example.lina.userorangtua.Model.Kuisioner;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class KuisionerLihatModel {
    @SerializedName("namalengkap")
    @Expose
    private String namalengkap;
    @SerializedName("kelas")
    @Expose
    private String kelas;
    @SerializedName("namaprogram")
    @Expose
    private String namaprogram;
    @SerializedName("level")
    @Expose
    private String level;
    @SerializedName("tanggal")
    @Expose
    private String tanggal;
    @SerializedName("namaguru")
    @Expose
    private String namaguru;
    @SerializedName("penguasaanmateri")
    @Expose
    private String penguasaanmateri;
    @SerializedName("kemampuanmengajar")
    @Expose
    private String kemampuanmengajar;
    @SerializedName("kedisiplinan")
    @Expose
    private String kedisiplinan;
    @SerializedName("tanggungjawabdantingkahlaku")
    @Expose
    private String tanggungjawabdantingkahlaku;
    @SerializedName("kerjasama")
    @Expose
    private String kerjasama;

    public String getNamalengkap() {
        return namalengkap;
    }

    public void setNamalengkap(String namalengkap) {
        this.namalengkap = namalengkap;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getNamaprogram() {
        return namaprogram;
    }

    public void setNamaprogram(String namaprogram) {
        this.namaprogram = namaprogram;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
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

    public String getPenguasaanmateri() {
        return penguasaanmateri;
    }

    public void setPenguasaanmateri(String penguasaanmateri) {
        this.penguasaanmateri = penguasaanmateri;
    }

    public String getKemampuanmengajar() {
        return kemampuanmengajar;
    }

    public void setKemampuanmengajar(String kemampuanmengajar) {
        this.kemampuanmengajar = kemampuanmengajar;
    }

    public String getKedisiplinan() {
        return kedisiplinan;
    }

    public void setKedisiplinan(String kedisiplinan) {
        this.kedisiplinan = kedisiplinan;
    }

    public String getTanggungjawabdantingkahlaku() {
        return tanggungjawabdantingkahlaku;
    }

    public void setTanggungjawabdantingkahlaku(String tanggungjawabdantingkahlaku) {
        this.tanggungjawabdantingkahlaku = tanggungjawabdantingkahlaku;
    }

    public String getKerjasama() {
        return kerjasama;
    }

    public void setKerjasama(String kerjasama) {
        this.kerjasama = kerjasama;
    }
}
