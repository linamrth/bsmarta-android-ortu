package com.example.lina.userorangtua.Fitur.Rapot;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.example.lina.userorangtua.Api.ApiService;
import com.example.lina.userorangtua.Model.Rapot.DetailRapotKursusResultModel;
import com.example.lina.userorangtua.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailRapotKursus extends AppCompatActivity {
    private ArrayList<DetailRapotKursusResultModel> dataDetailrapot = new ArrayList<>();
    private RecyclerView rv;
    private DetailRapotKursusAdapter detailRapotKursusAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_rapot_kursus);
        setTitle("Daftar Siswa");

        SharedPreferences sharedPreferences = getSharedPreferences("bsmart", MODE_PRIVATE);
        rv = (RecyclerView) findViewById(R.id.rv);

        ApiService.services_get.getDetailRapotKursus(sharedPreferences.getInt("idorangtua", 0)).enqueue(new Callback<DetailRapotKursusResultModel>() {
            @Override
            public void onResponse(Call<DetailRapotKursusResultModel> call, Response<DetailRapotKursusResultModel> response) {
                DetailRapotKursusResultModel resultModel = response.body();

                detailRapotKursusAdapter = new DetailRapotKursusAdapter(DetailRapotKursus.this, resultModel.getResults());
                rv.setLayoutManager(new LinearLayoutManager(DetailRapotKursus.this));
                rv.setAdapter(detailRapotKursusAdapter);
                rv.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<DetailRapotKursusResultModel> call, Throwable t) {

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
