package com.example.lina.userorangtua.Fitur.Kuisioner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.lina.userorangtua.Api.ApiService;
import com.example.lina.userorangtua.Model.Kuisioner.KuisionerIsiResultModel;
import com.example.lina.userorangtua.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KuisionerIsi extends AppCompatActivity {
    private KuisionerIsiResultModel kuisionerIsiResultModel;
    private RadioGroup penguasaanmateri, kemampuanmengajar, kedisiplinan, tanggungjawabdantingkahlaku, kerjasama;
    private RadioButton penguasaanmateri1, penguasaanmateri2, penguasaanmateri3, penguasaanmateri4, penguasaanmateri5;
    private RadioButton kemampuanmengajar1, kemampuanmengajar2, kemampuanmengajar3, kemampuanmengajar4, kemampuanmengajar5;
    private RadioButton kedisiplinan1, kedisiplinan2, kedisiplinan3, kedisiplinan4, kedisiplinan5;
    private RadioButton tanggungjawabdantingkahlaku1, tanggungjawabdantingkahlaku2, tanggungjawabdantingkahlaku3, tanggungjawabdantingkahlaku4, tanggungjawabdantingkahlaku5;
    private RadioButton kerjasama1, kerjasama2, kerjasama3, kerjasama4, kerjasama5;
    private RadioButton radioButton;
    Integer nilai1, nilai2, nilai3, nilai4, nilai5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuisioner_isi);
        setTitle("Form Kuisioner");

        Intent intent = getIntent();
        final Integer idkuisioner = intent.getIntExtra("idkuisioner", 0);
        Log.d("terserah", String.valueOf(idkuisioner));

        penguasaanmateri1 = (RadioButton) findViewById(R.id.penguasaanmateri1);
        penguasaanmateri2 = (RadioButton) findViewById(R.id.penguasaanmateri2);
        penguasaanmateri3 = (RadioButton) findViewById(R.id.penguasaanmateri3);
        penguasaanmateri4 = (RadioButton) findViewById(R.id.penguasaanmateri4);
        penguasaanmateri5 = (RadioButton) findViewById(R.id.penguasaanmateri5);

        kemampuanmengajar1 = (RadioButton) findViewById(R.id.kemampuanmengajar1);
        kemampuanmengajar2 = (RadioButton) findViewById(R.id.kemampuanmengajar2);
        kemampuanmengajar3 = (RadioButton) findViewById(R.id.kemampuanmengajar3);
        kemampuanmengajar4 = (RadioButton) findViewById(R.id.kemampuanmengajar4);
        kemampuanmengajar5 = (RadioButton) findViewById(R.id.kemampuanmengajar5);

        kedisiplinan1 = (RadioButton) findViewById(R.id.kedisiplinan1);
        kedisiplinan2 = (RadioButton) findViewById(R.id.kedisiplinan2);
        kedisiplinan3 = (RadioButton) findViewById(R.id.kedisiplinan3);
        kedisiplinan4 = (RadioButton) findViewById(R.id.kedisiplinan4);
        kedisiplinan5 = (RadioButton) findViewById(R.id.kedisiplinan5);

        tanggungjawabdantingkahlaku1 = (RadioButton) findViewById(R.id.tanggungjawabdantingkahlaku1);
        tanggungjawabdantingkahlaku2 = (RadioButton) findViewById(R.id.tanggungjawabdantingkahlaku2);
        tanggungjawabdantingkahlaku3 = (RadioButton) findViewById(R.id.tanggungjawabdantingkahlaku3);
        tanggungjawabdantingkahlaku4 = (RadioButton) findViewById(R.id.tanggungjawabdantingkahlaku4);
        tanggungjawabdantingkahlaku5 = (RadioButton) findViewById(R.id.tanggungjawabdantingkahlaku5);

        kerjasama1 = (RadioButton) findViewById(R.id.kerjasama1);
        kerjasama2 = (RadioButton) findViewById(R.id.kerjasama2);
        kerjasama3 = (RadioButton) findViewById(R.id.kerjasama3);
        kerjasama4 = (RadioButton) findViewById(R.id.kerjasama4);
        kerjasama5 = (RadioButton) findViewById(R.id.kerjasama5);

        penguasaanmateri            = (RadioGroup) findViewById(R.id.penguasaanmateri);
        kemampuanmengajar           = (RadioGroup) findViewById(R.id.kemampuanmengajar);
        kedisiplinan                = (RadioGroup) findViewById(R.id.kedisiplinan);
        tanggungjawabdantingkahlaku = (RadioGroup) findViewById(R.id.tanggungjawabdantingkahlaku);
        kerjasama                   = (RadioGroup) findViewById(R.id.kerjasama);


        Button bt = (Button) findViewById(R.id.bt);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(penguasaanmateri1.isChecked()){
                    nilai1 = Integer.parseInt(penguasaanmateri1.getText().toString());
                    //Toast.makeText(KuisionerIsi.this, "nilai 1 :  " + Integer.parseInt(penguasaanmateri1.getText().toString()), Toast.LENGTH_SHORT).show();
                } else if (penguasaanmateri2.isChecked()){
                    nilai1 = Integer.parseInt(penguasaanmateri2.getText().toString());
                } else if (penguasaanmateri3.isChecked()){
                    nilai1 = Integer.parseInt(penguasaanmateri3.getText().toString());
                } else if (penguasaanmateri4.isChecked()){
                    nilai1 = Integer.parseInt(penguasaanmateri4.getText().toString());
                } else if (penguasaanmateri5.isChecked()){
                    nilai1 = Integer.parseInt(penguasaanmateri5.getText().toString());
                }

                if (kemampuanmengajar1.isChecked()){
                    nilai2 = Integer.parseInt(kemampuanmengajar1.getText().toString());
                } else if (kemampuanmengajar2.isChecked()){
                    nilai2 = Integer.parseInt(kemampuanmengajar2.getText().toString());
                } else if (kemampuanmengajar3.isChecked()){
                    nilai2 = Integer.parseInt(kemampuanmengajar3.getText().toString());
                } else if (kemampuanmengajar4.isChecked()){
                    nilai2 = Integer.parseInt(kemampuanmengajar4.getText().toString());
                } else if (kemampuanmengajar5.isChecked()){
                    nilai2 = Integer.parseInt(kemampuanmengajar5.getText().toString());
                }

                if (kedisiplinan1.isChecked()){
                    nilai3 = Integer.parseInt(kedisiplinan1.getText().toString());
                } else if (kedisiplinan2.isChecked()){
                    nilai3 = Integer.parseInt(kedisiplinan2.getText().toString());
                } else if (kedisiplinan3.isChecked()){
                    nilai3 = Integer.parseInt(kedisiplinan3.getText().toString());
                } else if (kedisiplinan4.isChecked()){
                    nilai3 = Integer.parseInt(kedisiplinan4.getText().toString());
                } else if (kedisiplinan5.isChecked()){
                    nilai3 = Integer.parseInt(kedisiplinan5.getText().toString());
                }

                if (tanggungjawabdantingkahlaku1.isChecked()){
                    nilai4 = Integer.parseInt(tanggungjawabdantingkahlaku1.getText().toString());
                } else if (tanggungjawabdantingkahlaku2.isChecked()){
                    nilai4 = Integer.parseInt(tanggungjawabdantingkahlaku2.getText().toString());
                } else if (tanggungjawabdantingkahlaku3.isChecked()){
                    nilai4 = Integer.parseInt(tanggungjawabdantingkahlaku3.getText().toString());
                } else if (tanggungjawabdantingkahlaku4.isChecked()){
                    nilai4 = Integer.parseInt(tanggungjawabdantingkahlaku4.getText().toString());
                } else if (tanggungjawabdantingkahlaku5.isChecked()){
                    nilai4 = Integer.parseInt(tanggungjawabdantingkahlaku5.getText().toString());
                }

                if (kerjasama1.isChecked()){
                    nilai5 = Integer.parseInt(kerjasama1.getText().toString());
                } else if (kerjasama2.isChecked()){
                    nilai5 = Integer.parseInt(kerjasama2.getText().toString());
                } else if (kerjasama3.isChecked()){
                    nilai5 = Integer.parseInt(kerjasama3.getText().toString());
                } else if (kerjasama4.isChecked()){
                    nilai5 = Integer.parseInt(kerjasama4.getText().toString());
                } else if (kerjasama5.isChecked()){
                    nilai5 = Integer.parseInt(kerjasama5.getText().toString());
                }

                //Toast.makeText(KuisionerIsi.this, ""+nilai1+","+nilai2+","+nilai3+","+nilai4+","+nilai5, Toast.LENGTH_SHORT).show();

               ApiService.services_post.kuisioner(nilai1, nilai2, nilai3, nilai4, nilai5, idkuisioner).enqueue(new Callback<KuisionerIsiResultModel>() {
                    @Override
                    public void onResponse(Call<KuisionerIsiResultModel> call, Response<KuisionerIsiResultModel> response) {
                        if (response.isSuccessful()){
                            String status = response.body().getStatus();
                            Toast.makeText(KuisionerIsi.this, "" + status, Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }

                    @Override
                    public void onFailure(Call<KuisionerIsiResultModel> call, Throwable t) {
                        Toast.makeText(KuisionerIsi.this, "Lengkapi Kuisioner !", Toast.LENGTH_SHORT).show();
                    }
                });
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
