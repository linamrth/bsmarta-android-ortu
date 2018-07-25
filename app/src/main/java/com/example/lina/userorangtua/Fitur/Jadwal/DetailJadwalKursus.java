package com.example.lina.userorangtua.Fitur.Jadwal;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lina.userorangtua.Api.ApiService;
import com.example.lina.userorangtua.Model.Jadwal.DetailJadwalKursusResultModel;
import com.example.lina.userorangtua.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailJadwalKursus extends AppCompatActivity {
    private ArrayList<DetailJadwalKursusResultModel> dataDetailjadwal;
    private RecyclerView rv;
    private DetailJadwalKursusAdapter detailJadwalKursusAdapter;
    private TextView tvNama, tvKelas, tvProgramlevel, tvLevel;
    private ImageView imgnama, imgkelas, imgprogram, imglevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_jadwal_kursus);
        setTitle("Daftar Siswa");

        SharedPreferences sharedPreferences = getSharedPreferences("bsmart", MODE_PRIVATE);
        rv = (RecyclerView) findViewById(R.id.rv);

        ApiService.services_get.getDetailJadwalKursus(sharedPreferences.getInt("idorangtua",0)).enqueue(new Callback<DetailJadwalKursusResultModel>() {
            @Override
            public void onResponse(Call<DetailJadwalKursusResultModel> call, Response<DetailJadwalKursusResultModel> response) {
                 //Toast.makeText(DetailJadwalKursus.this, "" + response.body(), Toast.LENGTH_SHORT).show();
                DetailJadwalKursusResultModel resultModel = response.body();

                detailJadwalKursusAdapter = new DetailJadwalKursusAdapter(DetailJadwalKursus.this, resultModel.getResult());
                rv.setLayoutManager(new LinearLayoutManager(DetailJadwalKursus.this));
                rv.setAdapter(detailJadwalKursusAdapter);
                rv.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<DetailJadwalKursusResultModel> call, Throwable t) {

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
