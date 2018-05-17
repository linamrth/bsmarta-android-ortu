package com.example.lina.userorangtua.Fitur.Rapot;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.lina.userorangtua.Api.ApiService;
import com.example.lina.userorangtua.Model.Rapot.RapotKursusStatusResultModel;
import com.example.lina.userorangtua.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RapotKursusStatus extends AppCompatActivity {
    private ArrayList<RapotKursusStatusResultModel> dataRapotkursus;
    private RecyclerView rv;
    private RapotKursusStatusAdapter rapotKursusStatusAdapter;
    private TextView tvTanggal, tvNamaguru, tvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rapot_kursus_status);
        setTitle("Daftar Rapot");

        Intent intent = getIntent();
        Integer idsiswabelajar = intent.getIntExtra("idsiswabelajar", 0);
        Log.d("terserah", String.valueOf(idsiswabelajar));

        tvTanggal = (TextView) findViewById(R.id.tvtanggal);
        tvNamaguru = (TextView) findViewById(R.id.tvnamaguru);
        tvStatus = (TextView) findViewById(R.id.tvstatusrapot);

        rv = (RecyclerView) findViewById(R.id.rv);

        ApiService.services_get.getRapotKursusStatus(idsiswabelajar).enqueue(new Callback<RapotKursusStatusResultModel>() {
            @Override
            public void onResponse(Call<RapotKursusStatusResultModel> call, Response<RapotKursusStatusResultModel> response) {
                RapotKursusStatusResultModel resultModel = response.body();

                rapotKursusStatusAdapter = new RapotKursusStatusAdapter(RapotKursusStatus.this, resultModel.getJadwalgenerate());
                rv.setLayoutManager(new LinearLayoutManager(RapotKursusStatus.this));
                rv.setAdapter(rapotKursusStatusAdapter);
                rv.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<RapotKursusStatusResultModel> call, Throwable t) {

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
