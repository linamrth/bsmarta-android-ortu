package com.example.lina.userorangtua.Fitur.Rapot;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.lina.userorangtua.Model.Rapot.GrafikPerkembanganModel;
import com.example.lina.userorangtua.R;

import java.util.ArrayList;

import im.dacer.androidcharts.LineView;

public class Grafik extends AppCompatActivity {
    private GrafikPerkembanganModel grafikPerkembanganModel;
    private LineView lineView;
    int randomint = 9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafik);

        Intent intent = getIntent();
        Integer idsiswabelajar = intent.getIntExtra("idsiswabelajar", 0);
        Log.d("idsiswabelajar", String.valueOf(idsiswabelajar));
        Toast.makeText(this, "ID Siswa : " + idsiswabelajar, Toast.LENGTH_SHORT).show();

        lineView = (LineView) findViewById(R.id.line_view);

        initLineView(lineView);
//        Button lineButton = (Button) findViewById(R.id.line_button);
//        lineButton.setOnClickListener(new View.OnClickListener() {
//            @Override public void onClick(View view) {
//                randomSet(lineView);
//            }
//        });
//
        randomSet(lineView);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initLineView(LineView lineView) {
        ArrayList<String> test = new ArrayList<String>();
        for (int i = 0; i < randomint; i++) {
            test.add(String.valueOf(i + 1));
        }
        lineView.setBottomTextList(test);
        lineView.setColorArray(new int[] {
                Color.parseColor("#F44336"), Color.parseColor("#9C27B0"),
                Color.parseColor("#2196F3"), Color.parseColor("#009688")
        });
        lineView.setDrawDotLine(true);
        lineView.setShowPopup(LineView.SHOW_POPUPS_NONE);
    }

    private void randomSet(LineView lineView) {
        ArrayList<Integer> dataList = new ArrayList<>();
        float random = (float) (Math.random() * 9 + 1);
        for (int i = 0; i < randomint; i++) {
            dataList.add((int) (Math.random() * random));
        }

        ArrayList<ArrayList<Integer>> dataLists = new ArrayList<>();
        dataLists.add(dataList);

        lineView.setDataList(dataLists);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == android.R.id.home){
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
