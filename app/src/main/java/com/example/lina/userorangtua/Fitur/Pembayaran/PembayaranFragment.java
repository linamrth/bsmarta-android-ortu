package com.example.lina.userorangtua.Fitur.Pembayaran;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lina.userorangtua.Model.Pembayaran.PembayaranModel;
import com.example.lina.userorangtua.R;

import java.util.ArrayList;

public class PembayaranFragment extends Fragment {
    private ArrayList<PembayaranModel> dataPembayaran = new ArrayList<>();
    private RecyclerView rv;
    private PembayaranAdapter pembayaran;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pembayaran, null);
        rv = (RecyclerView) view.findViewById(R.id.rv);
        createDataPembayaran();
        pembayaran = new PembayaranAdapter(getActivity(), dataPembayaran);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(pembayaran);
        return view;
    }

    private void createDataPembayaran() {
        for (int i=0; i<4; i++){
            PembayaranModel pembayaran = new PembayaranModel("Lina Meritha", "TK A", "Cinta Baca - Level 1");
            dataPembayaran.add(pembayaran);
        }
    }
}
