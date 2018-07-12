package com.example.lina.userorangtua.Model.Rapot;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.lina.userorangtua.Api.ApiService;
import com.example.lina.userorangtua.R;

import java.util.ArrayList;

import im.dacer.androidcharts.LineView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GrafikActivity extends AppCompatActivity {
    private GrafikPerkembanganModel grafikPerkembanganModel;
    private LineView lineView;
//    private RelativeLayout empty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafik2);

        Intent intent = getIntent();
        Integer idsiswabelajar = intent.getIntExtra("idsiswabelajar", 0);
        Log.d("idsiswabelajar", String.valueOf(idsiswabelajar));
        Toast.makeText(this, "ID Siswa : " + idsiswabelajar, Toast.LENGTH_SHORT).show();

        lineView = (LineView) findViewById(R.id.line_view);
//        empty = (RelativeLayout) findViewById(R.id.empty);

        ApiService.services_get.getGrafikPerkembangan(idsiswabelajar).enqueue(new Callback<GrafikPerkembanganModel>() {
            @Override
            public void onResponse(Call<GrafikPerkembanganModel> call, Response<GrafikPerkembanganModel> response) {
                grafikPerkembanganModel = response.body();
                //Toast.makeText(Grafik.this,  "Code : " + response.code(), Toast.LENGTH_SHORT).show();

                //Untuk Pertemuan
                Integer pertemuan = grafikPerkembanganModel.getPertemuan().size();
                ArrayList<String> mLabels = new ArrayList<String>();
                for (int i = 0; i < pertemuan; i++) {
                    mLabels.add("Pertemuan " + grafikPerkembanganModel.getPertemuan().get(i).toString());
                }
                lineView.setBottomTextList(mLabels);
                lineView.setColorArray(new int[] {
                        Color.parseColor("#F44336"), Color.parseColor("#9C27B0"),
                        Color.parseColor("#2196F3"), Color.parseColor("#009688")
                });
                lineView.setDrawDotLine(true);
                lineView.setShowPopup(LineView.SHOW_POPUPS_NONE);


                //Untuk Data Grafik
                Integer hasiltarget = grafikPerkembanganModel.getHasiltarget().size();
                ArrayList<Integer> dataList = new ArrayList<>();
                for (int i = 0; i < hasiltarget; i++){
                    int hasil = Integer.parseInt(grafikPerkembanganModel.getHasiltarget().get(i));
                    dataList.add(hasil);
                }

                dataList.add(100);

                ArrayList<Integer> targetlist = new ArrayList<>();
                for (int i = 0; i < grafikPerkembanganModel.getTarget().size(); i++){
                    targetlist.add(grafikPerkembanganModel.getTarget().get(i));
                }

                ArrayList<ArrayList<Integer>> dataLists = new ArrayList<>();
                dataLists.add(targetlist);
                dataLists.add(dataList);
                lineView.setDataList(dataLists);

//                if (pertemuan == 0) {
//                    empty.setVisibility(View.VISIBLE);
//                }
//                else if (hasiltarget == 0) {
//                    empty.setVisibility(View.VISIBLE);
//                }
//                else {
//                    empty.setVisibility(View.GONE);
//                }
            }

            @Override
            public void onFailure(Call<GrafikPerkembanganModel> call, Throwable t) {

            }
        });
    }
}
