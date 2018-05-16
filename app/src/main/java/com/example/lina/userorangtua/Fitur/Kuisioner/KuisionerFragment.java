package com.example.lina.userorangtua.Fitur.Kuisioner;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lina.userorangtua.Model.Kuisioner.KuisionerModel;
import com.example.lina.userorangtua.R;

import java.util.ArrayList;

public class KuisionerFragment extends Fragment {
    private ArrayList<KuisionerModel> dataKuisioner = new ArrayList<>();
    private RecyclerView rv;
    private KuisionerAdapter kuisioner;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_kuisioner, null);
        rv = (RecyclerView) view.findViewById(R.id.rv);
        createDataKuisioner();
        kuisioner = new KuisionerAdapter(getActivity(), dataKuisioner);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(kuisioner);
        return view;
    }

    private void createDataKuisioner() {
        for (int i=0; i<4; i++){
            KuisionerModel kuisioner = new KuisionerModel("Lina Meritha", "TK A", "Cinta Baca - Level 1");
            dataKuisioner.add(kuisioner);
        }
    }
}
