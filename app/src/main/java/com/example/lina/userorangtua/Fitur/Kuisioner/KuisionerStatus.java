package com.example.lina.userorangtua.Fitur.Kuisioner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.lina.userorangtua.Api.ApiService;
import com.example.lina.userorangtua.Model.Kuisioner.KuisionerStatusResultModel;
import com.example.lina.userorangtua.R;

import java.util.ArrayList;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KuisionerStatus extends AppCompatActivity {
    private ArrayList<KuisionerStatusResultModel> dataKuisioner;
    private RecyclerView rv;
    private KuisionerStatusAdapter kuisionerStatusAdapter;
    private TextView tvTanggal, tvNamaguru, tvStatus;
    Integer idsiswabelajar;
    Calendar mCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuisioner_status);
        setTitle("Daftar Kuisioner");

        Intent intent = getIntent();
        idsiswabelajar = intent.getIntExtra("idsiswabelajar", 0);
        Log.d("terserah", String.valueOf(idsiswabelajar));

        tvTanggal = findViewById(R.id.tvtanggal);
        tvNamaguru = findViewById(R.id.tvnamaguru);
        tvStatus = findViewById(R.id.tvstatuskuisioner);

        rv = findViewById(R.id.rv);

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

    //untuk finishnya biar bisa langsung ganti status belum terisi jd sudah terisi
    @Override
    protected void onResume() {
        super.onResume();
        ApiService.services_get.getKuisionerStatus(idsiswabelajar).enqueue(new Callback<KuisionerStatusResultModel>() {
            @Override
            public void onResponse(Call<KuisionerStatusResultModel> call, Response<KuisionerStatusResultModel> response) {
                KuisionerStatusResultModel resultModel = response.body();

                kuisionerStatusAdapter = new KuisionerStatusAdapter(KuisionerStatus.this, resultModel.getResults());
                rv.setLayoutManager(new LinearLayoutManager(KuisionerStatus.this));
                rv.setAdapter(kuisionerStatusAdapter);
                rv.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<KuisionerStatusResultModel> call, Throwable t) {

            }
        });
    }
}
