package com.example.lina.userorangtua.Fitur.Rapot;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lina.userorangtua.Fitur.Jadwal.DetailJadwalKursus;
import com.example.lina.userorangtua.Fitur.Jadwal.DetailJadwalTrial;
import com.example.lina.userorangtua.R;

public class RapotFragment extends Fragment {
    private TextView tvjudul1, tvjudul2, tvcaption1, tvcaption2;
    private CardView cv1, cv2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rapot, null);

        cv1 = (CardView) view.findViewById(R.id.cv1);
        cv2 = (CardView) view.findViewById(R.id.cv2);
        tvjudul1 = (TextView) view.findViewById(R.id.tvjudul1);
        tvcaption1 = (TextView) view.findViewById(R.id.tvcaption1);
        tvjudul2 = (TextView) view.findViewById(R.id.tvjudul2);
        tvcaption2 = (TextView) view.findViewById(R.id.tvcaption2);

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
}
