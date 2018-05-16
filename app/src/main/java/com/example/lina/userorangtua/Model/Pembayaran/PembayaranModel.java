package com.example.lina.userorangtua.Model.Pembayaran;

public class PembayaranModel {
    private String nama;
    private String kelas;
    private String programlevel;
    private String tanggal;
    private String status;

    public PembayaranModel(String nama, String kelas, String programlevel) {
        this.nama = nama;
        this.kelas = kelas;
        this.programlevel = programlevel;
    }

    public PembayaranModel(String tanggal, String status) {
        this.tanggal = tanggal;
        this.status = status;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getProgramlevel() {
        return programlevel;
    }

    public void setProgramlevel(String programlevel) {
        this.programlevel = programlevel;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
