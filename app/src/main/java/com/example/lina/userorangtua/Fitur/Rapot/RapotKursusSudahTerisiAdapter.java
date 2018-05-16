package com.example.lina.userorangtua.Fitur.Rapot;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lina.userorangtua.Model.Rapot.RapotModel;
import com.example.lina.userorangtua.R;

import java.util.ArrayList;

public class RapotKursusSudahTerisiAdapter extends RecyclerView.Adapter<RapotKursusSudahTerisiAdapter.ItemRowHolder> {
    ArrayList<RapotModel> dataRapotkursus;
    private Activity activity;

    public RapotKursusSudahTerisiAdapter(Activity activity, ArrayList<RapotModel> dataRapotkursus){
        this.dataRapotkursus = dataRapotkursus;
        this.activity = activity;
    }

    @Override
    public RapotKursusSudahTerisiAdapter.ItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_rapot_kursus_sudah_terisicardview, viewGroup, false);
        RapotKursusSudahTerisiAdapter.ItemRowHolder mh = new RapotKursusSudahTerisiAdapter.ItemRowHolder(view);
        return mh;
    }

    @Override
    public void onBindViewHolder(RapotKursusSudahTerisiAdapter.ItemRowHolder holder, int i) {
        holder.tvTanggal.setText(dataRapotkursus.get(i).getTanggal());
        holder.tvNamaguru.setText(dataRapotkursus.get(i).getNamaguru());
        holder.tvStatussudahterisi.setText(dataRapotkursus.get(i).getStatussudahterisi());
    }

    @Override
    public int getItemCount() {
        return (null != dataRapotkursus ? dataRapotkursus.size() : 0);
    }

    public class ItemRowHolder extends RecyclerView.ViewHolder {
        protected TextView tvTanggal, tvNamaguru, tvStatussudahterisi;
        public ItemRowHolder(View view) {
            super(view);

            this.tvTanggal = (TextView) view.findViewById(R.id.tvtanggal);
            this.tvNamaguru = (TextView) view.findViewById(R.id.tvnamaguru);
            this.tvStatussudahterisi = (TextView) view.findViewById(R.id.tvstatusrapot);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(v.getContext(), RapotKursus.class);
                    v.getContext().startActivity(intent);
                }
            });
        }
    }
}
