package com.example.lina.userorangtua.Fitur.Kuisioner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.example.lina.userorangtua.Model.Kuisioner.KuisionerModel;
import com.example.lina.userorangtua.R;

import java.util.ArrayList;

public class DetailKuisionerSudahIsi extends AppCompatActivity {
    private ArrayList<KuisionerModel> dataKuisioner = new ArrayList<>();
    private RecyclerView rv;
    private DetailKuisionerSudahIsiAdapter detailKuisionerSudahIsiAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_kuisioner_sudah_isi);
        setTitle("Daftar Kuisioner");

        rv = (RecyclerView) findViewById(R.id.rv);

        createDetailKuisionerSudahIsi();

        detailKuisionerSudahIsiAdapter = new DetailKuisionerSudahIsiAdapter(this, dataKuisioner);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(detailKuisionerSudahIsiAdapter);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void createDetailKuisionerSudahIsi() {
        for (int i=0; i<10; i++){
            KuisionerModel kuisioner = new KuisionerModel("Kamis, 17 Mei 2018", "Shifwatin", "Belum Terisi", "Sudah Terisi");
            dataKuisioner.add(kuisioner);
        }
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == android.R.id.home){
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
