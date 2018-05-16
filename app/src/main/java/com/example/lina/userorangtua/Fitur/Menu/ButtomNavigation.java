package com.example.lina.userorangtua.Fitur.Menu;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.lina.userorangtua.Fitur.Jadwal.JadwalFragment;
import com.example.lina.userorangtua.Fitur.Kuisioner.KuisionerFragment;
import com.example.lina.userorangtua.Fitur.Pembayaran.PembayaranFragment;
import com.example.lina.userorangtua.Fitur.Profil.ProfilFragment;
import com.example.lina.userorangtua.Fitur.Rapot.RapotFragment;
import com.example.lina.userorangtua.R;

public class ButtomNavigation extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buttom_navigation);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);

        loadFragment(new JadwalFragment());
    }

    private boolean loadFragment(Fragment fragment){
        if (fragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()){
            case R.id.navigation_jadwal:
                fragment = new JadwalFragment();
                break;

            case R.id.navigation_rapot:
                fragment = new RapotFragment();
                break;

            case R.id.navigation_pembayaran:
                fragment = new PembayaranFragment();
                break;

            case R.id.navigation_kuisioner:
                fragment = new KuisionerFragment();
                break;

            case R.id.navigation_profil:
                fragment= new ProfilFragment();
                break;
        }
        return loadFragment(fragment);
    }
}
