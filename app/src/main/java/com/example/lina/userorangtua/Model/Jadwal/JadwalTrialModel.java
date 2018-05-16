package com.example.lina.userorangtua.Model.Jadwal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JadwalTrialModel {
    @SerializedName("namalengkap")
    @Expose
    private String namalengkap;
    @SerializedName("kelas")
    @Expose
    private String kelas;
    @SerializedName("asalsekolah")
    @Expose
    private String asalsekolah;
    @SerializedName("namaprogram")
    @Expose
    private String namaprogram;
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

    public String getAsalsekolah() {
        return asalsekolah;
    }

    public void setAsalsekolah(String asalsekolah) {
        this.asalsekolah = asalsekolah;
    }

    public String getNamaprogram() {
        return namaprogram;
    }

    public void setNamaprogram(String namaprogram) {
        this.namaprogram = namaprogram;
    }

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
