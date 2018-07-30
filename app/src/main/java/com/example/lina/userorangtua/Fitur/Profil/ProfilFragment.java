package com.example.lina.userorangtua.Fitur.Profil;

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
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lina.userorangtua.Api.ApiService;
import com.example.lina.userorangtua.Fitur.Login.LoginForm;
import com.example.lina.userorangtua.Fitur.Login.Session;
import com.example.lina.userorangtua.Fitur.Menu.AboutUs;
import com.example.lina.userorangtua.Fitur.Menu.EditPassword;
import com.example.lina.userorangtua.Model.Profil.ProfileResultModel;
import com.example.lina.userorangtua.Model.Profil.ProfileSiswaModel;
import com.example.lina.userorangtua.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfilFragment extends Fragment {
    private ProfileResultModel profileResultModel;
    private ProfilFragmentAdapter profilFragmentAdapter;
    private TextView tvNamaortu,tvGender, tvTelepon;
    private ImageView ivProfilortu;
    private RecyclerView rv;
    Session session;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_profil,null);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("bsmart", Context.MODE_PRIVATE);
        Log.d("idorangtua", String.valueOf(sharedPreferences.getInt("idorangtua",0)));
        rv = (RecyclerView) view.findViewById(R.id.rv);

        Toolbar toolbar = view.findViewById(R.id.toolbar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);

        ivProfilortu = view.findViewById(R.id.ivprofilortu);
        tvNamaortu = view.findViewById(R.id.tv_namaortu);
        tvGender = view.findViewById(R.id.tvgender);
        tvTelepon = view.findViewById(R.id.tvtelepon);

        session = new Session(getActivity());
        if (!session.login()){
            logout();
        }

        ApiService.services_get.getProfile(sharedPreferences.getInt("idorangtua",0)).enqueue(new Callback<ProfileResultModel>() {
            @Override
            public void onResponse(Call<ProfileResultModel> call, Response<ProfileResultModel> response) {
                profileResultModel = response.body();

                profilFragmentAdapter = new ProfilFragmentAdapter(getActivity(), (ArrayList<ProfileSiswaModel>) profileResultModel.getResults().getSiswa());
                rv.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
                rv.setAdapter(profilFragmentAdapter);
                rv.getAdapter().notifyDataSetChanged();

                Glide.with(view).load(profileResultModel.getResults().getFoto()).into(ivProfilortu);
                tvNamaortu.setText(profileResultModel.getResults().getNamaortu());
                String gender;
                if(profileResultModel.getResults().getJeniskelamin().equals("L")){
                    gender = "Laki - Laki";
                }
                else {
                    gender = "Perempuan";
                }
                tvGender.setText(gender);
                tvTelepon.setText(profileResultModel.getResults().getTelepon());
            }

            @Override
            public void onFailure(Call<ProfileResultModel> call, Throwable t) {

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