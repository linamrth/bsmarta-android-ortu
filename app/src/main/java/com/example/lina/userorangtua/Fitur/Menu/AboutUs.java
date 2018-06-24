package com.example.lina.userorangtua.Fitur.Menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.lina.userorangtua.R;

public class AboutUs extends AppCompatActivity {
    private TextView tvAplikasi, tvBSmart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        setTitle("About Us");

        tvAplikasi = (TextView) findViewById(R.id.tentangaplikasi);
        tvBSmart = (TextView) findViewById(R.id.tentangbsmart);

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
