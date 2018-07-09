package com.example.lina.userorangtua.Fitur.Rapot;

import android.animation.PropertyValuesHolder;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.Toast;

import com.db.chart.animation.Animation;
import com.db.chart.model.LineSet;
import com.db.chart.renderer.AxisRenderer;
import com.db.chart.tooltip.Tooltip;
import com.db.chart.util.Tools;
import com.db.chart.view.LineChartView;
import com.example.lina.userorangtua.Api.ApiService;
import com.example.lina.userorangtua.Model.Rapot.GrafikPerkembanganModel;
import com.example.lina.userorangtua.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GrafikPerkembangan extends AppCompatActivity {
    private boolean isStop = true;
    private GrafikPerkembanganModel grafikPerkembanganModel = new GrafikPerkembanganModel();
    private LineChartView mChart;
    private Tooltip mTip;
    private Runnable mBaseAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafik_perkembangan);
        setTitle("Grafik Perkembangan");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        Integer idsiswabelajar = intent.getIntExtra("idsiswabelajar", 0);
        Log.d("idsiswabelajar", String.valueOf(idsiswabelajar));
        Toast.makeText(this, "ID Siswa : " + idsiswabelajar, Toast.LENGTH_SHORT).show();

        mChart = (LineChartView) findViewById(R.id.chart);

        // Tooltip
        mTip = new Tooltip(this, R.layout.tooltip, R.id.value);
        mTip.setVerticalAlignment(Tooltip.Alignment.BOTTOM_TOP);
        mTip.setDimensions((int) Tools.fromDpToPx(58), (int) Tools.fromDpToPx(25));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {

            mTip.setEnterAnimation(PropertyValuesHolder.ofFloat(View.ALPHA, 1),
                    PropertyValuesHolder.ofFloat(View.SCALE_Y, 1f),
                    PropertyValuesHolder.ofFloat(View.SCALE_X, 1f)).setDuration(200);

            mTip.setExitAnimation(PropertyValuesHolder.ofFloat(View.ALPHA, 0),
                    PropertyValuesHolder.ofFloat(View.SCALE_Y, 0f),
                    PropertyValuesHolder.ofFloat(View.SCALE_X, 0f)).setDuration(200);

            mTip.setPivotX(Tools.fromDpToPx(65) / 2);
            mTip.setPivotY(Tools.fromDpToPx(25));
        }

        ApiService.services_get.getGrafikPerkembangan(idsiswabelajar).enqueue(new Callback<GrafikPerkembanganModel>() {
            @Override
            public void onResponse(Call<GrafikPerkembanganModel> call, Response<GrafikPerkembanganModel> response) {
                grafikPerkembanganModel = response.body();
                Toast.makeText(GrafikPerkembangan.this,  "Code : " + response.code(), Toast.LENGTH_SHORT).show();
                Toast.makeText(GrafikPerkembangan.this, "Hasil Target : " + grafikPerkembanganModel.getHasiltarget().get(0), Toast.LENGTH_SHORT).show();

                String[] mLabels = new String[grafikPerkembanganModel.getPertemuan().size()];
                float[] mValues = new float[grafikPerkembanganModel.getTarget().size()];

                for (int i = 0; i < grafikPerkembanganModel.getPertemuan().size(); i++) {
                    mLabels[i] = ""+ grafikPerkembanganModel.getPertemuan().get(i);
                }
                for (int i = 0; i < grafikPerkembanganModel.getTarget().size(); i++) {
                    mValues[i] = grafikPerkembanganModel.getTarget().get(i);
                }
                Toast.makeText(GrafikPerkembangan.this, "mLabels: "+ mLabels.length +", mValues: "+ mValues.length, Toast.LENGTH_SHORT).show();

                // Data
                LineSet dataset = new LineSet(mLabels, mValues);
                dataset.setColor(Color.parseColor("#758cbb"))
                        .setFill(Color.parseColor("#2d374c"))
                        .setDotsColor(Color.parseColor("#758cbb"))
                        .setThickness(4)
                        .beginAt(0);
                mChart.addData(dataset);

                dataset = new LineSet(mLabels, mValues);
                dataset.setColor(Color.parseColor("#b3b5bb"))
                        .setFill(Color.parseColor("#2d374c"))
                        .setThickness(4)
                        .endAt(2);
                mChart.addData(dataset);

                mBaseAction = new Runnable() {
                    @Override
                    public void run() {
                        new Handler().postDelayed(new Runnable() {
                            public void run() {
                            }
                        }, 500);
                    }
                };

                Runnable chartAction = new Runnable() {
                    @Override
                    public void run() {

                        mBaseAction.run();
                        mChart.showTooltip(mTip, true);
                    }
                };

                mChart.setAxisBorderValues(0, 180)
                        .setYLabels(AxisRenderer.LabelPosition.OUTSIDE)
                        .setTooltips(mTip)
                        .show(new Animation().setInterpolator(new BounceInterpolator())
                                .fromAlpha(0)
                                .withEndAction(chartAction));
            }

            @Override
            public void onFailure(Call<GrafikPerkembanganModel> call, Throwable t) {

            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == android.R.id.home){
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
