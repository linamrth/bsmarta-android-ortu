package com.example.lina.userorangtua.Fitur.Jadwal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.lina.userorangtua.Model.Jadwal.JadwalKursusGenerateModel;
import com.example.lina.userorangtua.Model.Jadwal.JadwalKursusSiswaBelajarModel;

import java.util.ArrayList;

public class SQLiteHelper extends SQLiteOpenHelper {
    private static String DATABASE_NAME = "bsmarta";
    private static final int DATABASE_VERSION = 1;
    public final static String DATABASE_PATH = "/data/data/com.example.lina.userorangtua.Fitur.Jadwal/databases/";

    private static final String TABLE_SISWABELAJAR = "siswabelajar";
    public static final String COLUMN_IDSISWABELAJAR = "idsiswabelajar";
    public static final String COLUMN_NAMALENGKAP = "namalengkap";
    public static final String COLUMN_KELAS = "kelas";
    public static final String COLUMN_NAMAPROGRAM = "namaprogram";
    public static final String COLUMN_LEVEL = "level";

    private static final String TABLE_JADWALSISWA = "jadwalsiswa";
    public static final String COLUMN_IDJADWALSISWA = "idjadwalsiswa";
    public static final String COLUMN_HARI = "hari";
    public static final String COLUMN_TANGGAL = "tanggal";
    public static final String COLUMN_JAM= "jam";
    public static final String COLUMN_NAMAGURU = "namaguru";

    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        String CREATE_SISWABELAJAR_TABLE = "CREATE TABLE " + TABLE_SISWABELAJAR + "("
                + COLUMN_IDSISWABELAJAR + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_NAMALENGKAP + " TEXT,"
                + COLUMN_KELAS + " TEXT,"
                + COLUMN_NAMAPROGRAM + " TEXT,"
                + COLUMN_LEVEL + " TEXT"
                + ")";

        String CREATE_JADWALSISWA_TABLE = "CREATE TABLE " + TABLE_JADWALSISWA + "("
                + COLUMN_IDJADWALSISWA + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_HARI + " TEXT,"
                + COLUMN_TANGGAL + " DATETIME,"
                + COLUMN_JAM + " INTEGER,"
                + COLUMN_NAMAGURU + " TEXT"
                + ")";

        db.execSQL(CREATE_SISWABELAJAR_TABLE);
        db.execSQL(CREATE_JADWALSISWA_TABLE);
    }

    public void onUpgrade(SQLiteDatabase db, int i, int i1){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SISWABELAJAR);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_JADWALSISWA);
        onCreate(db);
    }

    // simpan data siswa
    public boolean setSiswaBelajar(JadwalKursusSiswaBelajarModel siswa) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_NAMALENGKAP, siswa.getNamalengkap());
        values.put(COLUMN_KELAS, siswa.getKelas());
        values.put(COLUMN_NAMAPROGRAM, siswa.getNamaprogram());
        values.put(COLUMN_LEVEL, siswa.getLevel());

       return true;
    }

    // ambil semua data siswa
    public ArrayList<JadwalKursusSiswaBelajarModel> listSiswa(){
        ArrayList<JadwalKursusSiswaBelajarModel> list_siswa = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_SISWABELAJAR;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()){
            do {
                JadwalKursusSiswaBelajarModel datasiswa = new JadwalKursusSiswaBelajarModel();
                datasiswa.setNamalengkap(cursor.getString(0));
                datasiswa.setKelas(cursor.getString(1));
                datasiswa.setNamaprogram(cursor.getString(2));
                datasiswa.setLevel(cursor.getString(3));
            } while (cursor.moveToNext());
        }

        return list_siswa;
    }

    // simpan data jadwal
    public boolean setJadwalsiswa(JadwalKursusGenerateModel jadwal) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_HARI, jadwal.getHari());
        values.put(COLUMN_TANGGAL, jadwal.getTanggal());
        values.put(COLUMN_JAM, jadwal.getJam());
        values.put(COLUMN_NAMAGURU, jadwal.getNamaguru());

        return true;
    }

    // ambil semua data jadwa;
    public ArrayList<JadwalKursusGenerateModel> listJadwal(){
        ArrayList<JadwalKursusGenerateModel> list_jadwal = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_JADWALSISWA;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()){
            do {
                JadwalKursusGenerateModel datajadwal = new JadwalKursusGenerateModel();
                datajadwal.setHari(cursor.getString(0));
                datajadwal.setTanggal(cursor.getString(1));
                datajadwal.setJam(cursor.getString(2));
                datajadwal.setNamaguru(cursor.getString(3));
            } while (cursor.moveToNext());
        }

        return list_jadwal;
    }

    // Getting Siswa Count
    public int getSiswaCount() {
        String countQuery = "SELECT  * FROM " + TABLE_SISWABELAJAR;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        // return count
        return cursor.getCount();
    }

    // Getting Jadwal Count
    public int getJadwalCount() {
        String countQuery = "SELECT  * FROM " + TABLE_JADWALSISWA;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        // return count
        return cursor.getCount();
    }

    //Menyimpan baris siswa
    public int countSiswa(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.query(SQLiteHelper.TABLE_SISWABELAJAR, null, null, null, null, null, null);

        return cursor.getCount();
    }

    //Menyimpan baris jadwal
    public int countJadwal(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.query(SQLiteHelper.TABLE_JADWALSISWA, null, null, null, null, null, null);

        return cursor.getCount();
    }
}