package com.example.lina.userorangtua.Fitur.Jadwal;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.lina.userorangtua.Api.ApiService;
import com.example.lina.userorangtua.Model.Jadwal.DetailJadwalTrialResultModel;
import com.example.lina.userorangtua.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailJadwalTrial extends AppCompatActivity {
    private ArrayList<DetailJadwalTrialResultModel> dataDetailjadwal ;
    private RecyclerView rv;
    private DetailJadwalTrialAdapter detailJadwalAdapter;
    private TextView tvNama, tvKelas, tvProgram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_jadwal_trial);
        setTitle("Daftar Siswa");

        SharedPreferences sharedPreferences = getSharedPreferences("bsmart", MODE_PRIVATE);
        rv = (RecyclerView) findViewById(R.id.rv);

        ApiService.services_get.getDetailJadwalTrial(sharedPreferences.getInt("idorangtua",0)).enqueue(new Callback<DetailJadwalTrialResultModel>() {
            @Override
            public void onResponse(Call<DetailJadwalTrialResultModel> call, Response<DetailJadwalTrialResultModel> response) {
               // Toast.makeText(DetailJadwalTrial.this, "" + response.body(), Toast.LENGTH_SHORT).show();
                DetailJadwalTrialResultModel resultModel = response.body();

                detailJadwalAdapter = new DetailJadwalTrialAdapter(DetailJadwalTrial.this, resultModel.getResult());
                rv.setLayoutManager(new LinearLayoutManager(DetailJadwalTrial.this));
                rv.setAdapter(detailJadwalAdapter);
                rv.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<DetailJadwalTrialResultModel> call, Throwable t) {

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
