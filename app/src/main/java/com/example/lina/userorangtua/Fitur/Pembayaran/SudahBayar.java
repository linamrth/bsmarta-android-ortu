package com.example.lina.userorangtua.Fitur.Pembayaran;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.example.lina.userorangtua.Model.Pembayaran.PembayaranModel;
import com.example.lina.userorangtua.R;

import java.util.ArrayList;

public class SudahBayar extends AppCompatActivity {
    private ArrayList<PembayaranModel> dataPembayaran = new ArrayList<>();
    private RecyclerView rv;
    private SudahBayarAdapter sudahBayarAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sudah_bayar);
        setTitle("Pembayaran Kursus");

        rv = (RecyclerView) findViewById(R.id.rv);

        createSudahBayar();

        sudahBayarAdapter = new SudahBayarAdapter(this, dataPembayaran);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(sudahBayarAdapter);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void createSudahBayar() {
        for (int i=0; i<10; i++){
            PembayaranModel sudahbayar = new PembayaranModel("Senin, 14 Mei 2018", "Sudah Bayar");
            dataPembayaran.add(sudahbayar);
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
