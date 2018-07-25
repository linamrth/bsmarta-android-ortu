package com.example.lina.userorangtua.Fitur.Rapot;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lina.userorangtua.Fitur.Login.LoginForm;
import com.example.lina.userorangtua.Fitur.Login.Session;
import com.example.lina.userorangtua.Fitur.Menu.AboutUs;
import com.example.lina.userorangtua.Fitur.Menu.EditPassword;
import com.example.lina.userorangtua.R;

public class RapotFragment extends Fragment {
    private TextView tvjudul1, tvjudul2, tvcaption1, tvcaption2;
    private CardView cv1, cv2;
    Session session;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rapot, null);

        Toolbar toolbar = view.findViewById(R.id.toolbar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);

        cv1 = (CardView) view.findViewById(R.id.cv1);
        cv2 = (CardView) view.findViewById(R.id.cv2);
        tvjudul1 = (TextView) view.findViewById(R.id.tvjudul1);
        tvcaption1 = (TextView) view.findViewById(R.id.tvcaption1);
        tvjudul2 = (TextView) view.findViewById(R.id.tvjudul2);
        tvcaption2 = (TextView) view.findViewById(R.id.tvcaption2);

        session = new Session(getActivity());
        if (!session.login()){
            logout();
        }

        cv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1 = new Intent(getActivity(), DetailRapotTrial.class);
                getActivity().startActivity(intent1);
            }
        });

        cv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent2 = new Intent(getActivity(), DetailRapotKursus.class);
                getActivity().startActivity(intent2);
            }
        });

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.aboutus:
                Intent intent1 = new Intent(getActivity(), AboutUs.class);
                getActivity().startActivity(intent1);
                return true;
            case R.id.logout:
                logout();
                return true;
            case R.id.editpassword:
                Intent intent3 = new Intent(getActivity(), EditPassword.class);
                getActivity().startActivity(intent3);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void logout(){
        session.setLogin(false,0, 0);
        getActivity().finish();
        startActivity(new Intent(getActivity(), LoginForm.class));
    }
}
