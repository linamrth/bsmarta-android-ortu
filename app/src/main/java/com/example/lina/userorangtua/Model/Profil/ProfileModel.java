package com.example.lina.userorangtua.Model.Profil;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ProfileModel {


    @SerializedName("namaortu")
    @Expose
    private String namaortu;
    @SerializedName("jeniskelamin")
    @Expose
    private String jeniskelamin;
    @SerializedName("telepon")
    @Expose
    private String telepon;
    @SerializedName("siswa")
    @Expose
    private ArrayList<ProfileSiswaModel> siswa = null;

    public String getNamaortu() {
        return namaortu;
    }

    public void setNamaortu(String namaortu) {
        this.namaortu = namaortu;
    }

    public String getJeniskelamin() {
        return jeniskelamin;
    }

    public void setJeniskelamin(String jeniskelamin) {
        this.jeniskelamin = jeniskelamin;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public List<ProfileSiswaModel> getSiswa() {
        return siswa;
    }

    public void setSiswa(ArrayList<ProfileSiswaModel> siswa) {
        this.siswa = siswa;
    }


}
