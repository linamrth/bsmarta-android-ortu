package com.example.lina.userorangtua.Fitur.Jadwal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.lina.userorangtua.Api.ApiService;
import com.example.lina.userorangtua.Model.Jadwal.JadwalTrialModel;
import com.example.lina.userorangtua.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JadwalTrial extends AppCompatActivity {
    private JadwalTrialModel jadwalTrialModel;
    private TextView tvNama, tvKelas, tvSekolah, tvProgram, tvGuru, tvHari, tvTanggal, tvJam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadwal_trial);
        setTitle("Jadwal Trial");

        Intent intent = getIntent();
        Integer idtrial = intent.getIntExtra("idtrial", 0);
        Log.d("terserah", String.valueOf(idtrial));

        tvNama = (TextView) findViewById(R.id.tvisinama);
        tvKelas = (TextView) findViewById(R.id.tvisikelas);
        tvSekolah = (TextView) findViewById(R.id.tvisisekolah);
        tvProgram = (TextView) findViewById(R.id.tvisiprogram);
        tvGuru = (TextView) findViewById(R.id.tvisiguru);
        tvHari = (TextView) findViewById(R.id.tvisihari);
        tvTanggal = (TextView) findViewById(R.id.tvisitanggal);
        tvJam = (TextView) findViewById(R.id.tvisijam);

        ApiService.services_get.getJadwalTrial(idtrial).enqueue(new Callback<JadwalTrialModel>() {
            @Override
            public void onResponse(Call<JadwalTrialModel> call, Response<JadwalTrialModel> response) {
                jadwalTrialModel = response.body();

//                Log.d("getNamalengkap", String.valueOf(jadwalTrialModel.getNamalengkap()));

                tvNama.setText(jadwalTrialModel.getNamalengkap());
                tvKelas.setText(jadwalTrialModel.getKelas());
                tvSekolah.setText(jadwalTrialModel.getAsalsekolah());
                tvProgram.setText(jadwalTrialModel.getNamaprogram());
                tvGuru.setText(jadwalTrialModel.getNamaguru());
                tvHari.setText(jadwalTrialModel.getHari());
                tvTanggal.setText(jadwalTrialModel.getTanggal());

                if(jadwalTrialModel.getJam().equals("1")){
                    tvJam.setText("10.00 - 11.00");
                } else if(jadwalTrialModel.getJam().equals("2")){
                    tvJam.setText("11.00 - 12.00");
                } else if(jadwalTrialModel.getJam().equals("3")){
                    tvJam.setText("13.00 - 14.00");
                } else if(jadwalTrialModel.getJam().equals("4")){
                    tvJam.setText("14.00 - 15.00");
                } else if(jadwalTrialModel.getJam().equals("5")){
                    tvJam.setText("15.00 - 16.00");
                } else if(jadwalTrialModel.getJam().equals("6")){
                    tvJam.setText("16.00 - 17.00");
                } else if(jadwalTrialModel.getJam().equals("7")) {
                    tvJam.setText("18.00 - 19.00");
                }
            }

            @Override
            public void onFailure(Call<JadwalTrialModel> call, Throwable t) {

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
