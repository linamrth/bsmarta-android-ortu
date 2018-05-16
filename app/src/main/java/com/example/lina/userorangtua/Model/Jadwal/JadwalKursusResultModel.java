package com.example.lina.userorangtua.Model.Jadwal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class JadwalKursusResultModel {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("siswabelajar")
    @Expose
    private ArrayList<JadwalKursusSiswaBelajarModel> siswabelajar = null;
    @SerializedName("jadwalgenerate")
    @Expose
    private ArrayList<JadwalKursusGenerateModel> jadwalgenerate = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<JadwalKursusSiswaBelajarModel> getSiswabelajar() {
        return siswabelajar;
    }

    public void setSiswabelajar(ArrayList<JadwalKursusSiswaBelajarModel> siswabelajar) {
        this.siswabelajar = siswabelajar;
    }

    public ArrayList<JadwalKursusGenerateModel> getJadwalgenerate() {
        return jadwalgenerate;
    }

    public void setJadwalgenerate(ArrayList<JadwalKursusGenerateModel> jadwalgenerate) {
        this.jadwalgenerate = jadwalgenerate;
    }
}
