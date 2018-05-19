package com.example.lina.userorangtua.Fitur.Kuisioner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.lina.userorangtua.Api.ApiService;
import com.example.lina.userorangtua.Model.Kuisioner.KuisionerLihatModel;
import com.example.lina.userorangtua.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KuisionerLihat extends AppCompatActivity {
    private KuisionerLihatModel kuisionerLihatModel;
    private TextView tvNama, tvKelas, tvProgram, tvLevel;
    private TextView tvNamaguru, tvTanggal;
    private TextView tvPenguasaanmateri, tvKemampuanmengajar, tvKedisiplinan, tvTanggungjawabdantingkahlaku, tvKerjasama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuisioner_lihat);
        setTitle("Kuisioner");

        Intent intent = getIntent();
        Integer idkuisioner = intent.getIntExtra("idkuisioner", 0);
        Log.d("terserah", String.valueOf(idkuisioner));

        tvNama = (TextView) findViewById(R.id.tvnama);
        tvKelas = (TextView) findViewById(R.id.tvkelas);
        tvProgram = (TextView) findViewById(R.id.tvprogram);
        tvLevel = (TextView) findViewById(R.id.tvlevel);
        tvNamaguru = (TextView) findViewById(R.id.tvnamaguru);
        tvTanggal = (TextView) findViewById(R.id.tvtanggal);
        tvPenguasaanmateri = (TextView) findViewById(R.id.tvpenguasaanmateri);
        tvKemampuanmengajar = (TextView) findViewById(R.id.tvkemampuanmengajar);
        tvKedisiplinan = (TextView) findViewById(R.id.tvkedisiplinan);
        tvTanggungjawabdantingkahlaku = (TextView) findViewById(R.id.tvtanggungjawabdantingkahlaku);
        tvKerjasama = (TextView) findViewById(R.id.tvkerjasama);

        ApiService.services_get.getKuisionerLihat(idkuisioner).enqueue(new Callback<KuisionerLihatModel>() {
            @Override
            public void onResponse(Call<KuisionerLihatModel> call, Response<KuisionerLihatModel> response) {
                kuisionerLihatModel = response.body();

                tvNama.setText(kuisionerLihatModel.getNamalengkap());
                tvKelas.setText(kuisionerLihatModel.getKelas());
                tvProgram.setText(kuisionerLihatModel.getNamaprogram());
                tvLevel.setText("Level " + kuisionerLihatModel.getLevel());
                tvNamaguru.setText(kuisionerLihatModel.getNamaguru());
                tvTanggal.setText(kuisionerLihatModel.getTanggal());

                if(kuisionerLihatModel.getPenguasaanmateri().equals("1")){
                    tvPenguasaanmateri.setText("Sangat Kurang");
                } else if (kuisionerLihatModel.getPenguasaanmateri().equals("2")){
                    tvPenguasaanmateri.setText("Kurang");
                } else if (kuisionerLihatModel.getPenguasaanmateri().equals("3")){
                    tvPenguasaanmateri.setText("Cukup");
                } else if (kuisionerLihatModel.getPenguasaanmateri().equals("4")){
                    tvPenguasaanmateri.setText("Baik");
                } else if (kuisionerLihatModel.getPenguasaanmateri().equals("5")){
                    tvPenguasaanmateri.setText("Sangat Baik");
                }

                if(kuisionerLihatModel.getKemampuanmengajar().equals("1")){
                    tvKemampuanmengajar.setText("Sangat Kurang");
                } else if (kuisionerLihatModel.getKemampuanmengajar().equals("2")){
                    tvKemampuanmengajar.setText("Kurang");
                } else if (kuisionerLihatModel.getKemampuanmengajar().equals("3")){
                    tvKemampuanmengajar.setText("Cukup");
                } else if (kuisionerLihatModel.getKemampuanmengajar().equals("4")){
                    tvKemampuanmengajar.setText("Baik");
                } else if (kuisionerLihatModel.getKemampuanmengajar().equals("5")){
                    tvKemampuanmengajar.setText("Sangat Baik");
                }

                if(kuisionerLihatModel.getKedisiplinan().equals("1")){
                    tvKedisiplinan.setText("Sangat Kurang");
                } else if (kuisionerLihatModel.getKedisiplinan().equals("2")){
                    tvKedisiplinan.setText("Kurang");
                } else if (kuisionerLihatModel.getKedisiplinan().equals("3")){
                    tvKedisiplinan.setText("Cukup");
                } else if (kuisionerLihatModel.getKedisiplinan().equals("4")){
                    tvKedisiplinan.setText("Baik");
                } else if (kuisionerLihatModel.getKedisiplinan().equals("5")){
                    tvKedisiplinan.setText("Sangat Baik");
                }

                if(kuisionerLihatModel.getTanggungjawabdantingkahlaku().equals("1")){
                    tvTanggungjawabdantingkahlaku.setText("Sangat Kurang");
                } else if (kuisionerLihatModel.getTanggungjawabdantingkahlaku().equals("2")){
                    tvTanggungjawabdantingkahlaku.setText("Kurang");
                } else if (kuisionerLihatModel.getTanggungjawabdantingkahlaku().equals("3")){
                    tvTanggungjawabdantingkahlaku.setText("Cukup");
                } else if (kuisionerLihatModel.getTanggungjawabdantingkahlaku().equals("4")){
                    tvTanggungjawabdantingkahlaku.setText("Baik");
                } else if (kuisionerLihatModel.getTanggungjawabdantingkahlaku().equals("5")){
                    tvTanggungjawabdantingkahlaku.setText("Sangat Baik");
                }

                if(kuisionerLihatModel.getKerjasama().equals("1")){
                    tvKerjasama.setText("Sangat Kurang");
                } else if (kuisionerLihatModel.getKerjasama().equals("2")){
                    tvKerjasama.setText("Kurang");
                } else if (kuisionerLihatModel.getKerjasama().equals("3")){
                    tvKerjasama.setText("Cukup");
                } else if (kuisionerLihatModel.getKerjasama().equals("4")){
                    tvKerjasama.setText("Baik");
                } else if (kuisionerLihatModel.getKerjasama().equals("5")){
                    tvKerjasama.setText("Sangat Baik");
                }
            }

            @Override
            public void onFailure(Call<KuisionerLihatModel> call, Throwable t) {

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
