package com.example.lina.userorangtua.Fitur.Rapot;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.lina.userorangtua.Api.ApiService;
import com.example.lina.userorangtua.Model.Rapot.DetailRapotTrialResultModel;
import com.example.lina.userorangtua.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailRapotTrial extends AppCompatActivity {
    private ArrayList<DetailRapotTrialResultModel> dataDetailrapot;
    private RecyclerView rv;
    private DetailRapotTrialAdapter detailRapotTrialAdapter;
    private TextView tvNama, tvKelas, tvProgram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_rapot_trial);
        setTitle("Daftar Siswa");

        SharedPreferences sharedPreferences = getSharedPreferences("bsmart", MODE_PRIVATE);
        rv = (RecyclerView) findViewById(R.id.rv);

        ApiService.services_get.getDetailRapotTrial(sharedPreferences.getInt("idorangtua",0)).enqueue(new Callback<DetailRapotTrialResultModel>() {
            @Override
            public void onResponse(Call<DetailRapotTrialResultModel> call, Response<DetailRapotTrialResultModel> response) {
                DetailRapotTrialResultModel resultModel = response.body();

                detailRapotTrialAdapter = new DetailRapotTrialAdapter(DetailRapotTrial.this, resultModel.getResults());
                rv.setLayoutManager(new LinearLayoutManager(DetailRapotTrial.this));
                rv.setAdapter(detailRapotTrialAdapter);
                rv.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<DetailRapotTrialResultModel> call, Throwable t) {

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
