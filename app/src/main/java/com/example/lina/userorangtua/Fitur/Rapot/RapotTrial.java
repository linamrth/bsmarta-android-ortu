package com.example.lina.userorangtua.Fitur.Rapot;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.lina.userorangtua.Api.ApiService;
import com.example.lina.userorangtua.Model.Rapot.RapotTrialModel;
import com.example.lina.userorangtua.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RapotTrial extends AppCompatActivity {
    private RapotTrialModel rapotTrialModel;
    private TextView tvNama, tvKelas, tvProgram, tvNamaguru;
    private TextView tvSoal1, tvSoal2, tvSoal3, tvSoal4, tvSoal5, tvSoal6, tvSoal7, tvSoal8, tvSoal9, tvSoal10, tvSoal11, tvCatatan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rapot_trial_cintabaca);
        setTitle("Rapot Trial");

        Intent intent = getIntent();
        Integer idtrial = intent.getIntExtra("idtrial", 0);
        String namaprogram = intent.getStringExtra("namaprogram");
        Log.d("terserah", String.valueOf(idtrial));
        Log.d("namaprogram", String.valueOf(namaprogram));

        tvNama = (TextView) findViewById(R.id.tvnama);
        tvKelas = (TextView) findViewById(R.id.tvkelas);
        tvProgram = (TextView) findViewById(R.id.tvprogram);
        tvNamaguru = (TextView) findViewById(R.id.tvnamaguru);
        tvSoal1 = (TextView) findViewById(R.id.tvsoal1);
        tvSoal2 = (TextView) findViewById(R.id.tvsoal2);
        tvSoal3 = (TextView) findViewById(R.id.tvsoal3);
        tvSoal4 = (TextView) findViewById(R.id.tvsoal4);
        tvSoal5 = (TextView) findViewById(R.id.tvsoal5);
        tvSoal6 = (TextView) findViewById(R.id.tvsoal6);
        tvSoal7 = (TextView) findViewById(R.id.tvsoal7);
        tvSoal8 = (TextView) findViewById(R.id.tvsoal8);
        tvSoal9 = (TextView) findViewById(R.id.tvsoal9);
        tvSoal10 = (TextView) findViewById(R.id.tvsoal10);
        tvSoal11 = (TextView) findViewById(R.id.tvsoal11);
        tvCatatan = (TextView) findViewById(R.id.tvcatatan);

        ApiService.services_get.getRapotTrial(idtrial).enqueue(new Callback<RapotTrialModel>() {
            @Override
            public void onResponse(Call<RapotTrialModel> call, Response<RapotTrialModel> response) {
                rapotTrialModel = response.body();

                tvNama.setText(rapotTrialModel.getNamalengkap());
                tvKelas.setText(rapotTrialModel.getKelas());
                tvProgram.setText(rapotTrialModel.getNamaprogram());
                tvNamaguru.setText(rapotTrialModel.getNamaguru());
                tvSoal1.setText(rapotTrialModel.getSoal1());
                tvSoal2.setText(rapotTrialModel.getSoal2());
                tvSoal3.setText(rapotTrialModel.getSoal3());
                tvSoal4.setText(rapotTrialModel.getSoal4());
                tvSoal5.setText(rapotTrialModel.getSoal5());
                tvSoal6.setText(rapotTrialModel.getSoal6());
                tvSoal7.setText(rapotTrialModel.getSoal7());
                tvSoal8.setText(rapotTrialModel.getSoal8());
                tvSoal9.setText(rapotTrialModel.getSoal9());
                tvSoal10.setText(rapotTrialModel.getSoal10());
                tvSoal11.setText(rapotTrialModel.getSoal11());
                tvCatatan.setText(rapotTrialModel.getCatatan());
            }

            @Override
            public void onFailure(Call<RapotTrialModel> call, Throwable t) {

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
