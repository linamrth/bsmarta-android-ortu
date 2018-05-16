package com.example.lina.userorangtua.Model.Rapot;

public class RapotModel {
    private String nama;
    private String kelas;
    private String programlevel;
    private String soal;
    private String jawaban;
    private String tanggal;
    private String namaguru;
    private String statusbelumterisi;
    private String statussudahterisi;

    public RapotModel(String nama, String kelas, String programlevel) {
        this.nama = nama;
        this.kelas = kelas;
        this.programlevel = programlevel;
    }

    public RapotModel(String soal, String jawaban) {
        this.soal = soal;
        this.jawaban = jawaban;
    }

    public RapotModel(String tanggal, String namaguru, String statusbelumterisi, String statussudahterisi) {
        this.tanggal = tanggal;
        this.namaguru = namaguru;
        this.statusbelumterisi = statusbelumterisi;
        this.statussudahterisi = statussudahterisi;
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

    public String getSoal() {
        return soal;
    }

    public void setSoal(String soal) {
        this.soal = soal;
    }

    public String getJawaban() {
        return jawaban;
    }

    public void setJawaban(String jawaban) {
        this.jawaban = jawaban;
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

    public String getStatusbelumterisi() {
        return statusbelumterisi;
    }

    public void setStatusbelumterisi(String statusbelumterisi) {
        this.statusbelumterisi = statusbelumterisi;
    }

    public String getStatussudahterisi() {
        return statussudahterisi;
    }

    public void setStatussudahterisi(String statussudahterisi) {
        this.statussudahterisi = statussudahterisi;
    }
}
