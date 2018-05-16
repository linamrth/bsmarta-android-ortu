package com.example.lina.userorangtua.Fitur.Rapot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.lina.userorangtua.R;

public class RapotKursus extends AppCompatActivity {
    ListView lv;
    String judul[] = {
            "Materi Pembelajaran",
            "Hasil Belajar",
            "Halaman Ketercapaian",
            "Catatan Guru",
            "Reward Hasil Belajar",
            "Reward Sikap Belajar"
    };
    String caption[] = {
            "Kreatifitas; Motorik, konsep 1 (kehadiran benda & simbol); variasi jari",
            "Sangat baik",
            "4",
            "Pelajari lebih banyak lagi tentang penjumlahan",
            "3",
            "2"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rapot_kursus);
        setTitle("Rapot Kursus");

        lv = (ListView) findViewById(R.id.lv);
        RapotKursusAdapter rapotKursusAdapter = new RapotKursusAdapter(getApplicationContext(), judul, caption);
        lv.setAdapter(rapotKursusAdapter);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == android.R.id.home){
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
