package com.example.lina.userorangtua.Fitur.Rapot;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.lina.userorangtua.Api.ApiService;
import com.example.lina.userorangtua.Model.Rapot.GrafikPerkembanganModel;
import com.example.lina.userorangtua.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Grafikbaru extends AppCompatActivity {

    private int idSiswa;
    private LineChart chart;
    private TextView materi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafikbaru);
        setTitle("Grafik Perkembangan Belajar");
        chart = findViewById(R.id.chart);
        materi = findViewById(R.id.materi);

        idSiswa = getIntent().getIntExtra("idsiswabelajar", 0);

        ApiService.services_get.getGrafikPerkembangan(idSiswa).enqueue(new Callback<GrafikPerkembanganModel>() {
            @Override
            public void onResponse(Call<GrafikPerkembanganModel> call, final Response<GrafikPerkembanganModel> response) {
                if (response.isSuccessful()){
                    if (response.body().getStatus().equals("OK")){
                        List<Entry> entries = new ArrayList<Entry>();
                        for (int i = 0; i < response.body().getHasiltarget().size(); i++){
                            entries.add(new Entry(response.body().getPertemuan().get(i).floatValue(), response.body().getTarget().get(i).floatValue()));
                        }
                        LineDataSet dataSet = new LineDataSet(entries, "Nilai yang harus dicapai");
                        dataSet.setLineWidth(3);
                        dataSet.setColor(R.color.colorPrimary);

                        List<Entry> hasilEntry = new ArrayList<Entry>();
                        for (int i = 0; i < response.body().getHasiltarget().size(); i++){
                            hasilEntry.add(new Entry(response.body().getPertemuan().get(i).floatValue(), Float.parseFloat(response.body().getHasiltarget().get(i))));
                        }
                        LineDataSet hasilDataset = new LineDataSet(hasilEntry, "Ketercapaian hasil belajar");
                        hasilDataset.setLineWidth(6);
                        hasilDataset.setColor(Color.rgb(255, 40, 0));

                        List<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();

                        dataSets.add(hasilDataset);
                        dataSets.add(dataSet);

                        LineData lineHasilData = new LineData(dataSets);

                        chart.setData(lineHasilData);
                        chart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
                        chart.getDescription().setText("Pertemuan");
                        chart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
                            @Override
                            public void onValueSelected(Entry e, Highlight h) {
                                Integer t = Math.round(h.getX()) - 1;
                                materi.setText(response.body().getMateri().get(t));
                            }

                            @Override
                            public void onNothingSelected() {

                            }
                        });
                        chart.invalidate();
                    }
                }
            }

            @Override
            public void onFailure(Call<GrafikPerkembanganModel> call, Throwable t) {

            }
        });
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
