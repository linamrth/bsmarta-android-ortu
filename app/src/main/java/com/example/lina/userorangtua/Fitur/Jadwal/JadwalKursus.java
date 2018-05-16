package com.example.lina.userorangtua.Fitur.Jadwal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.lina.userorangtua.Api.ApiService;
import com.example.lina.userorangtua.Model.Jadwal.JadwalKursusResultModel;
import com.example.lina.userorangtua.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JadwalKursus extends AppCompatActivity {
    private ArrayList<JadwalKursusResultModel> dataJadwal = new ArrayList<>();
    private RecyclerView rv;
    private JadwalKursusAdapter jadwalKursusAdapter;
    private TextView tvHari, tvTanggal, tvJam, tvNamaguru;
    private TextView tvNama, tvKelas, tvProgram, tvLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadwal_kursus);
        setTitle("Jadwal Kursus");

        Intent intent = getIntent();
        Integer idsiswabelajar = intent.getIntExtra("idsiswabelajar", 0);
        Log.d("terserah", String.valueOf(idsiswabelajar));

        tvNama = (TextView) findViewById(R.id.tvnama);
        tvKelas = (TextView) findViewById(R.id.tvkelas);
        tvProgram = (TextView) findViewById(R.id.tvprogram);
        tvLevel = (TextView) findViewById(R.id.tvlevel);

        rv = (RecyclerView) findViewById(R.id.rv);

        ApiService.services_get.getJadwalKursus(idsiswabelajar).enqueue(new Callback<JadwalKursusResultModel>() {
            @Override
            public void onResponse(Call<JadwalKursusResultModel> call, Response<JadwalKursusResultModel> response) {
                JadwalKursusResultModel resultModel = response.body();

                //Untuk Informasi Data Siswa
                tvNama.setText(resultModel.getSiswabelajar().get(0).getNamalengkap());
                tvKelas.setText(resultModel.getSiswabelajar().get(0).getKelas());
                tvProgram.setText(resultModel.getSiswabelajar().get(0).getNamaprogram());
                tvLevel.setText("Level " + resultModel.getSiswabelajar().get(0).getLevel());

                //Untuk Looping Data Jadwal Generate
                jadwalKursusAdapter = new JadwalKursusAdapter(JadwalKursus.this, resultModel.getJadwalgenerate());
                rv.setLayoutManager(new LinearLayoutManager(JadwalKursus.this));
                rv.setAdapter(jadwalKursusAdapter);
                rv.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<JadwalKursusResultModel> call, Throwable t) {

            }
        });

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
