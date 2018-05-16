package com.example.lina.userorangtua.Fitur.Profil;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lina.userorangtua.Api.ApiService;
import com.example.lina.userorangtua.Model.Profil.ProfileResultModel;
import com.example.lina.userorangtua.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfilFragment extends Fragment {
    private ProfileResultModel profileResultModel;
    private TextView tvNamaortu,tvGender, tvTelepon;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_profil,null);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("bsmart", Context.MODE_PRIVATE);
        Log.d("idorangtua", String.valueOf(sharedPreferences.getInt("idorangtua",0)));

        tvNamaortu = view.findViewById(R.id.tv_namaortu);
        tvGender = view.findViewById(R.id.tvgender);
        tvTelepon = view.findViewById(R.id.tvtelepon);

        ApiService.services_get.getProfile(sharedPreferences.getInt("idorangtua",0)).enqueue(new Callback<ProfileResultModel>() {
            @Override
            public void onResponse(Call<ProfileResultModel> call, Response<ProfileResultModel> response) {
                profileResultModel = response.body();

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
}
