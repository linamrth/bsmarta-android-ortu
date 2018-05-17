package com.example.lina.userorangtua.Fitur.Kuisioner;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lina.userorangtua.Api.ApiService;
import com.example.lina.userorangtua.Model.Kuisioner.KuisionerResultModel;
import com.example.lina.userorangtua.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KuisionerFragment extends Fragment {
    private ArrayList<KuisionerResultModel> dataKuisioner;
    private RecyclerView rv;
    private KuisionerAdapter kuisionerAdapter;
    private TextView tvNama, tvKelas, tvProgramlevel, tvLevel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_kuisioner, null);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("bsmart", Context.MODE_PRIVATE);
        rv = (RecyclerView) view.findViewById(R.id.rv);

        ApiService.services_get.getKuisioner(sharedPreferences.getInt("idorangtua", 0)).enqueue(new Callback<KuisionerResultModel>() {
            @Override
            public void onResponse(Call<KuisionerResultModel> call, Response<KuisionerResultModel> response) {
                KuisionerResultModel resultModel = response.body();

                kuisionerAdapter = new KuisionerAdapter(getActivity(), resultModel.getResults());
                rv.setLayoutManager(new LinearLayoutManager(getActivity()));
                rv.setAdapter(kuisionerAdapter);
                rv.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<KuisionerResultModel> call, Throwable t) {

            }
        });

        return view;
    }
}
