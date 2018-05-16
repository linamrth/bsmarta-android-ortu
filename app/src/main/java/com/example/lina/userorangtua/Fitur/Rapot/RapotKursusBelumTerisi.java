package com.example.lina.userorangtua.Fitur.Rapot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.example.lina.userorangtua.Model.Rapot.RapotModel;
import com.example.lina.userorangtua.R;

import java.util.ArrayList;

public class RapotKursusBelumTerisi extends AppCompatActivity {
    private ArrayList<RapotModel> dataRapotkursus = new ArrayList<>();
    private RecyclerView rv;
    private RapotKursusBelumTerisiAdapter rapotKursusBelumTerisiAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rapot_kursus_belum_terisi);
        setTitle("Daftar Rapot");

        rv = (RecyclerView) findViewById(R.id.rv);

        createRapotKursusBelumTerisi();

        rapotKursusBelumTerisiAdapter = new RapotKursusBelumTerisiAdapter(this, dataRapotkursus);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(rapotKursusBelumTerisiAdapter);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void createRapotKursusBelumTerisi() {
        for (int i=0; i<10; i++){
            RapotModel rapotkursus = new RapotModel("Senin, 14 Mei 2018", "Shifwatin", "Belum Terisi", "Sudah Terisi");
            dataRapotkursus.add(rapotkursus);
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
