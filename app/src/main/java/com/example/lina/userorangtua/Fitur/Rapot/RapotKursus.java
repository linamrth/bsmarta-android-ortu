package com.example.lina.userorangtua.Fitur.Rapot;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.lina.userorangtua.Api.ApiService;
import com.example.lina.userorangtua.Model.Rapot.RapotKursusModel;
import com.example.lina.userorangtua.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RapotKursus extends AppCompatActivity {
    private RapotKursusModel rapotKursusModel;
    private TextView tvNama, tvKelas, tvProgram, tvLevel;
    private TextView tvNamaguru, tvTanggal, tvPertemuanke;
    private TextView tvMateri, tvHalamanketercapaian, tvHasil, tvCatatanguru;
    private RatingBar tvRewardhasil, tvRewardsikap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rapot_kursus);
        setTitle("Rapot Kursus");

        Intent intent = getIntent();
        Integer idgenerate = intent.getIntExtra("idgenerate", 0);
        Log.d("terserah", String.valueOf(idgenerate));

        tvNama = (TextView) findViewById(R.id.tvnama);
        tvKelas = (TextView) findViewById(R.id.tvkelas);
        tvProgram = (TextView) findViewById(R.id.tvprogram);
        tvLevel = (TextView) findViewById(R.id.tvlevel);
        tvNamaguru = (TextView) findViewById(R.id.tvnamaguru);
        tvTanggal = (TextView) findViewById(R.id.tvtanggal);
        tvPertemuanke = (TextView) findViewById(R.id.tvpertemuanke);
        tvMateri = (TextView) findViewById(R.id.tvmateri);
        tvHalamanketercapaian = (TextView) findViewById(R.id.tvhalamanketercapaian);
        tvHasil = (TextView) findViewById(R.id.tvhasil);
        tvCatatanguru = (TextView) findViewById(R.id.tvcatatanguru);
        tvRewardhasil = (RatingBar) findViewById(R.id.tvrewardhasil);
        tvRewardsikap = (RatingBar) findViewById(R.id.tvrewardsikap);

        ApiService.services_get.getRapotKursus(idgenerate).enqueue(new Callback<RapotKursusModel>() {
            @Override
            public void onResponse(Call<RapotKursusModel> call, Response<RapotKursusModel> response) {
                rapotKursusModel = response.body();

                tvNama.setText(rapotKursusModel.getNamalengkap());
                tvKelas.setText(rapotKursusModel.getKelas());
                tvProgram.setText(rapotKursusModel.getNamaprogram());
                tvLevel.setText("Level " + rapotKursusModel.getLevel());
                tvNamaguru.setText(rapotKursusModel.getNamaguru());
                tvTanggal.setText(rapotKursusModel.getTanggal());
                tvPertemuanke.setText(rapotKursusModel.getPertemuanke());
                tvMateri.setText(rapotKursusModel.getMateri());
                tvHalamanketercapaian.setText("Halaman " + rapotKursusModel.getHalamanketercapaian());
                tvHasil.setText(rapotKursusModel.getHasil());
                tvCatatanguru.setText(rapotKursusModel.getCatatanguru());
                tvRewardhasil.setRating(rapotKursusModel.getRewardhasil());
                tvRewardsikap.setRating(rapotKursusModel.getRewardsikap());
            }

            @Override
            public void onFailure(Call<RapotKursusModel> call, Throwable t) {

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
