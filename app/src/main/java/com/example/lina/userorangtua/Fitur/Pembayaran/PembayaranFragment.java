package com.example.lina.userorangtua.Fitur.Pembayaran;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lina.userorangtua.Api.ApiService;
import com.example.lina.userorangtua.Fitur.Login.LoginForm;
import com.example.lina.userorangtua.Fitur.Login.Session;
import com.example.lina.userorangtua.Fitur.Menu.AboutUs;
import com.example.lina.userorangtua.Fitur.Menu.EditPassword;
import com.example.lina.userorangtua.Model.Pembayaran.PembayaranResultModel;
import com.example.lina.userorangtua.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PembayaranFragment extends Fragment {
    private ArrayList<PembayaranResultModel> dataPembayaran;
    private RecyclerView rv;
    private PembayaranAdapter pembayaranAdapter;
    private TextView tvNama, tvKelas, tvProgramlevel, tvLevel;
    Session session;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pembayaran, null);

        Toolbar toolbar = view.findViewById(R.id.toolbar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("bsmart", Context.MODE_PRIVATE);
        rv = (RecyclerView) view.findViewById(R.id.rv);

        session = new Session(getActivity());
        if (!session.login()){
            logout();
        }

        ApiService.services_get.getPembayaran(sharedPreferences.getInt("idorangtua", 0)).enqueue(new Callback<PembayaranResultModel>() {
            @Override
            public void onResponse(Call<PembayaranResultModel> call, Response<PembayaranResultModel> response) {
                PembayaranResultModel resultModel = response.body();

                pembayaranAdapter = new PembayaranAdapter(getActivity(), resultModel.getResults());
                rv.setLayoutManager(new LinearLayoutManager(getActivity()));
                rv.setAdapter(pembayaranAdapter);
                rv.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<PembayaranResultModel> call, Throwable t) {

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
        session.setLogin(false,0);
        getActivity().finish();
        startActivity(new Intent(getActivity(), LoginForm.class));
    }
}
