package com.example.lina.userorangtua.Fitur.Rapot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.example.lina.userorangtua.Model.Rapot.RapotModel;
import com.example.lina.userorangtua.R;

import java.util.ArrayList;

public class DetailRapotKursus extends AppCompatActivity {
    private ArrayList<RapotModel> dataDetailrapot = new ArrayList<>();
    private RecyclerView rv;
    private DetailRapotKursusAdapter detailRapotKursusAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_rapot_kursus);
        setTitle("Daftar Siswa");

        rv = (RecyclerView) findViewById(R.id.rv);

        createDetailRapot();

        detailRapotKursusAdapter = new DetailRapotKursusAdapter(this, dataDetailrapot);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(detailRapotKursusAdapter);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void createDetailRapot() {
        for (int i=0; i<5; i++){
            RapotModel detailrapot = new RapotModel("Lina Meritha", "TK A", "Cinta Baca - Level 1");
            dataDetailrapot.add(detailrapot);
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
