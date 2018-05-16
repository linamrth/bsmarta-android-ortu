package com.example.lina.userorangtua.Fitur.Rapot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.example.lina.userorangtua.Model.Rapot.RapotModel;
import com.example.lina.userorangtua.R;

import java.util.ArrayList;

public class RapotTrial extends AppCompatActivity {
    private ArrayList<RapotModel> dataRapottrial = new ArrayList<>();
    private RecyclerView rv;
    private RapotTrialAdapter rapotTrialAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rapot_trial);
        setTitle("Rapot Trial");

        rv = (RecyclerView) findViewById(R.id.rv);

        createRapotTrial();

        rapotTrialAdapter = new RapotTrialAdapter(this, dataRapottrial);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(rapotTrialAdapter);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void createRapotTrial() {
        for (int i=0; i<10; i++){
            RapotModel rapottrial = new RapotModel("Pernah mengikuti program baca dan tulis", "Iya");
            dataRapottrial.add(rapottrial);
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
