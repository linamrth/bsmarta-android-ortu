package com.example.lina.userorangtua.Fitur.Jadwal;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lina.userorangtua.Model.Jadwal.DetailJadwalTrialModel;
import com.example.lina.userorangtua.R;

import java.util.ArrayList;

public class DetailJadwalTrialAdapter extends RecyclerView.Adapter<DetailJadwalTrialAdapter.ItemRowHolder> {
    ArrayList<DetailJadwalTrialModel> dataDetailjadwal;
    private Context activity;

    public DetailJadwalTrialAdapter(Context activity, ArrayList<DetailJadwalTrialModel> dataDetailjadwal){
        this.dataDetailjadwal = dataDetailjadwal;
        this.activity = activity;
    }

    @Override
    public DetailJadwalTrialAdapter.ItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_detail_jadwal_trialcardview, viewGroup, false);
        DetailJadwalTrialAdapter.ItemRowHolder mh = new DetailJadwalTrialAdapter.ItemRowHolder(view);
        return mh;
    }

    @Override
    public void onBindViewHolder(DetailJadwalTrialAdapter.ItemRowHolder holder, int i) {
        final DetailJadwalTrialModel detailJadwalTrialModel = dataDetailjadwal.get(i);

        holder.tvNama.setText(dataDetailjadwal.get(i).getNamalengkap());
        holder.tvKelas.setText(dataDetailjadwal.get(i).getKelas());
        holder.tvProgramlevel.setText(dataDetailjadwal.get(i).getNamaprogram());
        holder.cvJadwaltrial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, JadwalTrial.class);
                intent.putExtra("idtrial", detailJadwalTrialModel.getIdtrial());
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return (null != dataDetailjadwal ? dataDetailjadwal.size() : 0);
    }

    public class ItemRowHolder extends RecyclerView.ViewHolder{
        protected TextView tvNama, tvKelas, tvProgramlevel;
        protected CardView cvJadwaltrial;
        public ItemRowHolder(View view) {
            super(view);

            this.tvNama = (TextView) view.findViewById(R.id.tvnama);
            this.tvKelas = (TextView) view.findViewById(R.id.tvkelas);
            this.tvProgramlevel = (TextView) view.findViewById(R.id.tvprogram);
            this.cvJadwaltrial = (CardView) view.findViewById(R.id.cvjadwaltrial);
        }
    }
}
