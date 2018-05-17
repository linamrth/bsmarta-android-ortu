package com.example.lina.userorangtua.Fitur.Pembayaran;


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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pembayaran, null);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("bsmart", Context.MODE_PRIVATE);
        rv = (RecyclerView) view.findViewById(R.id.rv);

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
}
