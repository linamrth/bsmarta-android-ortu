package com.example.lina.userorangtua.Model.Kuisioner;

public class KuisionerModel {
    private String nama;
    private String kelas;
    private String programlevel;
    private String tanggal;
    private String namaguru;
    private String statusbelumisi;
    private String statussudahisi;

    public KuisionerModel(String nama, String kelas, String programlevel) {
        this.nama = nama;
        this.kelas = kelas;
        this.programlevel = programlevel;
    }

    public KuisionerModel(String tanggal, String namaguru, String statusbelumisi, String statussudahisi) {
        this.tanggal = tanggal;
        this.namaguru = namaguru;
        this.statusbelumisi = statusbelumisi;
        this.statussudahisi = statussudahisi;
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

    public String getNamaguru() {
        return namaguru;
    }

    public void setNamaguru(String namaguru) {
        this.namaguru = namaguru;
    }

    public String getStatusbelumisi() {
        return statusbelumisi;
    }

    public void setStatusbelumisi(String statusbelumisi) {
        this.statusbelumisi = statusbelumisi;
    }

    public String getStatussudahisi() {
        return statussudahisi;
    }

    public void setStatussudahisi(String statussudahisi) {
        this.statussudahisi = statussudahisi;
    }
}
