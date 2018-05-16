package com.example.lina.userorangtua.Model.Jadwal;

public class ModelJadwal {
    private String judul;
    private String caption;
    private String nama;
    private String kelas;
    private String programlevel;
    private String pertemuan;
    private String namaguru;
    private String tanggal;
    private String jam;

    public ModelJadwal(String judul, String caption) {
        this.judul = judul;
        this.caption = caption;
    }

    public ModelJadwal(String nama, String kelas, String programlevel) {
        this.nama = nama;
        this.kelas = kelas;
        this.programlevel = programlevel;
    }

    public ModelJadwal(String pertemuan, String namaguru, String tanggal, String jam) {
        this.pertemuan = pertemuan;
        this.namaguru = namaguru;
        this.tanggal = tanggal;
        this.jam = jam;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
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

    public String getPertemuan() {
        return pertemuan;
    }

    public void setPertemuan(String pertemuan) {
        this.pertemuan = pertemuan;
    }

    public String getNamaguru() {
        return namaguru;
    }

    public void setNamaguru(String namaguru) {
        this.namaguru = namaguru;
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
