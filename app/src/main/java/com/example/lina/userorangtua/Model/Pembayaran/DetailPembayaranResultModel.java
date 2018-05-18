package com.example.lina.userorangtua.Model.Pembayaran;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class DetailPembayaranResultModel {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("siswabelajar")
    @Expose
    private ArrayList<DetailPembayaranSiswaBelajarModel> siswabelajar = null;
    @SerializedName("pembayaran")
    @Expose
    private ArrayList<DetailPembayaranBayarModel> pembayaran = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<DetailPembayaranSiswaBelajarModel> getSiswabelajar() {
        return siswabelajar;
    }

    public void setSiswabelajar(ArrayList<DetailPembayaranSiswaBelajarModel> siswabelajar) {
        this.siswabelajar = siswabelajar;
    }

    public ArrayList<DetailPembayaranBayarModel> getPembayaran() {
        return pembayaran;
    }

    public void setPembayaran(ArrayList<DetailPembayaranBayarModel> pembayaran) {
        this.pembayaran = pembayaran;
    }
}
