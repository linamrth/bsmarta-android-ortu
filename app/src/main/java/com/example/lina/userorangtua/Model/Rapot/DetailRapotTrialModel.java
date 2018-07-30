package com.example.lina.userorangtua.Model.Rapot;

import com.example.lina.userorangtua.Api.ApiService;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DetailRapotTrialModel {
    @SerializedName("foto")
    @Expose
    private String foto;
    @SerializedName("namalengkap")
    @Expose
    private String namalengkap;
    @SerializedName("kelas")
    @Expose
    private String kelas;
    @SerializedName("namaprogram")
    @Expose
    private String namaprogram;
    @SerializedName("idtrial")
    @Expose
    private Integer idtrial;

    public String getFoto() {
        return ApiService.BASE_URL_FOTO+foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

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

    public Integer getIdtrial() {
        return idtrial;
    }

    public void setIdtrial(Integer idtrial) {
        this.idtrial = idtrial;
    }
}
