package com.example.lina.userorangtua.Fitur.Pembayaran;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lina.userorangtua.Model.Pembayaran.PembayaranModel;
import com.example.lina.userorangtua.R;

import java.util.ArrayList;

public class PembayaranAdapter extends RecyclerView.Adapter<PembayaranAdapter.ItemRowHolder> {
    ArrayList<PembayaranModel> dataPembayaran;
    private Context activity;

    public PembayaranAdapter (Context activity, ArrayList<PembayaranModel> dataPembayaran){
        this.dataPembayaran = dataPembayaran;
        this.activity = activity;
    }

    @Override
    public ItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_pembayaran_cardview, viewGroup, false);
        ItemRowHolder mh = new ItemRowHolder(view);
        return mh;
    }

    @Override
    public void onBindViewHolder(ItemRowHolder holder, int i) {
        final PembayaranModel pembayaranModel = dataPembayaran.get(i);

        Glide.with(activity).load(dataPembayaran.get(i).getFoto()).into(holder.ivSiswa);
        holder.tvNama.setText(dataPembayaran.get(i).getNamalengkap());
        holder.tvKelas.setText(dataPembayaran.get(i).getKelas());
        holder.tvProgram.setText(dataPembayaran.get(i).getNamaprogram());
        holder.tvLevel.setText("Level " + dataPembayaran.get(i).getLevel());
        holder.cvPembayaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, DetailPembayaran.class);
                intent.putExtra("idsiswabelajar", pembayaranModel.getIdsiswabelajar());
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return (null != dataPembayaran ? dataPembayaran.size() : 0);
    }

    public class ItemRowHolder extends RecyclerView.ViewHolder {
        protected TextView tvNama, tvKelas, tvProgram, tvLevel;
        protected ImageView ivSiswa;
        protected CardView cvPembayaran;
        public ItemRowHolder(View view) {
            super(view);

            this.tvNama = (TextView) view.findViewById(R.id.tvnama);
            this.tvKelas = (TextView) view.findViewById(R.id.tvkelas);
            this.tvProgram = (TextView) view.findViewById(R.id.tvprogram);
            this.tvLevel = (TextView) view.findViewById(R.id.tvlevel);
            this.ivSiswa = (ImageView) view.findViewById(R.id.ivsiswa);
            this.cvPembayaran = (CardView) view.findViewById(R.id.cvpembayaran);
        }
    }
}
