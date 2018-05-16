package com.example.lina.userorangtua.Model.Jadwal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JadwalKursusGenerateModel {
    @SerializedName("namaguru")
    @Expose
    private String namaguru;
    @SerializedName("hari")
    @Expose
    private String hari;
    @SerializedName("tanggal")
    @Expose
    private String tanggal;
    @SerializedName("jam")
    @Expose
    private String jam;

    public String getNamaguru() {
        return namaguru;
    }

    public void setNamaguru(String namaguru) {
        this.namaguru = namaguru;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }
}
