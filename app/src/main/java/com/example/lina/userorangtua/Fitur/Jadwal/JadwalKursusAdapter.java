package com.example.lina.userorangtua.Fitur.Jadwal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lina.userorangtua.Model.Jadwal.JadwalKursusGenerateModel;
import com.example.lina.userorangtua.R;

import java.util.ArrayList;

public class JadwalKursusAdapter extends RecyclerView.Adapter<JadwalKursusAdapter.ItemRowHolder> {
    ArrayList<JadwalKursusGenerateModel> dataJadwal;
    private Context activity;

    public JadwalKursusAdapter (Context activity, ArrayList<JadwalKursusGenerateModel> dataJadwal){
        this.dataJadwal = dataJadwal;
        this.activity = activity;
    }

    @Override
    public JadwalKursusAdapter.ItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_jadwal_kursuscardview, viewGroup, false);
        JadwalKursusAdapter.ItemRowHolder mh = new JadwalKursusAdapter.ItemRowHolder(view);
        return mh;
    }

    @Override
    public void onBindViewHolder(ItemRowHolder holder, int i) {
        JadwalKursusGenerateModel model = dataJadwal.get(i);

        holder.tvPertemuan.setText("Pertemuan "+ String.valueOf(i + 1));
        holder.tvHari.setText(model.getHari());
        holder.tvTanggal.setText(model.getTanggal());
        holder.tvNamaguru.setText(model.getNamaguru());

        if(model.getJam().equals("1")){
            holder.tvJam.setText("10.00 - 11.00");
        } else if (model.getJam().equals("2") ){
            holder.tvJam.setText("11.00 - 12.00");
        } else if (model.getJam().equals("3")){
            holder.tvJam.setText("13.00 - 14.00");
        } else if (model.getJam().equals("4")){
            holder.tvJam.setText("14.00 - 15.00");
        } else if (model.getJam().equals("5")){
            holder.tvJam.setText("15.00 - 16.00");
        } else if (model.getJam().equals("6")){
            holder.tvJam.setText("16.00 - 17.00");
        } else if (model.getJam().equals("7")){
            holder.tvJam.setText("18.00 - 19.00");
        }
    }

    @Override
    public int getItemCount() {
        return (null != dataJadwal ? dataJadwal.size() : 0);
    }

    public class ItemRowHolder extends RecyclerView.ViewHolder {
        protected TextView tvHari, tvTanggal, tvJam, tvNamaguru, tvPertemuan;
        @SuppressLint("CutPasteId")
        public ItemRowHolder(View view) {
            super(view);

            this.tvPertemuan = (TextView) view.findViewById(R.id.tvpertemuan);
            this.tvHari = (TextView) view.findViewById(R.id.tvhari);
            this.tvTanggal = (TextView) view.findViewById(R.id.tvtanggal);
            this.tvJam = (TextView) view.findViewById(R.id.tvjam);
            this.tvNamaguru = (TextView) view.findViewById(R.id.tvnamaguru);
        }
    }
}
