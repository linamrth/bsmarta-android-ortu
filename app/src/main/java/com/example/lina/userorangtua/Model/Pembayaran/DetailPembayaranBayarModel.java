package com.example.lina.userorangtua.Model.Pembayaran;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DetailPembayaranBayarModel {
    @SerializedName("tanggal")
    @Expose
    private String tanggal;
    @SerializedName("statuspembayaran")
    @Expose
    private String statuspembayaran;

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getStatuspembayaran() {
        return statuspembayaran;
    }

    public void setStatuspembayaran(String statuspembayaran) {
        this.statuspembayaran = statuspembayaran;
    }
}
