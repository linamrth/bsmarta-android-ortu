package com.example.lina.userorangtua.Fitur.Jadwal;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lina.userorangtua.Model.Jadwal.DetailJadwalKursusModel;
import com.example.lina.userorangtua.R;

import java.util.ArrayList;

public class DetailJadwalKursusAdapter extends RecyclerView.Adapter<DetailJadwalKursusAdapter.ItemRowHolder> {
    ArrayList<DetailJadwalKursusModel> dataDetailjadwal;
    private Context activity;

    public DetailJadwalKursusAdapter(Context activity, ArrayList<DetailJadwalKursusModel> dataDetailjadwal){
        this.dataDetailjadwal = dataDetailjadwal;
        this.activity = activity;
    }

    @Override
    public DetailJadwalKursusAdapter.ItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_detail_jadwal_kursuscardview, viewGroup, false);
        DetailJadwalKursusAdapter.ItemRowHolder mh = new DetailJadwalKursusAdapter.ItemRowHolder(view);
        return mh;
    }

    @Override
    public void onBindViewHolder(DetailJadwalKursusAdapter.ItemRowHolder holder, int i) {
        final DetailJadwalKursusModel detailJadwalKursusModel = dataDetailjadwal.get(i);

        holder.tvNama.setText(dataDetailjadwal.get(i).getNamalengkap());
        holder.tvKelas.setText(dataDetailjadwal.get(i).getKelas());
        holder.tvProgramlevel.setText(dataDetailjadwal.get(i).getNamaprogram());
        holder.tvLevel.setText("Level " + dataDetailjadwal.get(i).getLevel());
        holder.cvDetailjadwalkursus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, JadwalKursus.class);
                intent.putExtra("idsiswabelajar", detailJadwalKursusModel.getIdsiswabelajar());
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return (null != dataDetailjadwal ? dataDetailjadwal.size() : 0);
    }

    public class ItemRowHolder extends RecyclerView.ViewHolder {
        protected TextView tvNama, tvKelas, tvProgramlevel, tvLevel;
        protected CardView cvDetailjadwalkursus;

        public ItemRowHolder(View view) {
            super(view);

            this.tvNama = (TextView) view.findViewById(R.id.tvnama);
            this.tvKelas = (TextView) view.findViewById(R.id.tvkelas);
            this.tvProgramlevel = (TextView) view.findViewById(R.id.tvprogram);
            this.tvLevel = (TextView) view.findViewById(R.id.tvlevel);
            this.cvDetailjadwalkursus = (CardView) view.findViewById(R.id.cvdetailjadwalkursus);
        }
    }
}
