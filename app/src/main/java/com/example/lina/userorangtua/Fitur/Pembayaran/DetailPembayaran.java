package com.example.lina.userorangtua.Fitur.Pembayaran;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.example.lina.userorangtua.Model.Pembayaran.PembayaranModel;
import com.example.lina.userorangtua.R;

import java.util.ArrayList;

public class DetailPembayaran extends AppCompatActivity {
    private ArrayList<PembayaranModel> dataPembayaran = new ArrayList<>();
    private RecyclerView rv;
    private DetailPembayaranAdapter belumBayarAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pembayaran);
        setTitle("Pembayaran Kursus");

        rv = (RecyclerView) findViewById(R.id.rv);

        createBelumBayar();

        belumBayarAdapter = new DetailPembayaranAdapter(this, dataPembayaran);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(belumBayarAdapter);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void createBelumBayar() {
        for (int i=0; i<10; i++){
//            PembayaranModel belumbayar = new PembayaranModel("Rabu, 16 Mei 2018", "Belum Bayar");
  //          dataPembayaran.add(belumbayar);
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
