package com.example.lina.userorangtua.Fitur.Pembayaran;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lina.userorangtua.Model.Pembayaran.PembayaranModel;
import com.example.lina.userorangtua.R;

import java.util.ArrayList;

public class PembayaranAdapter extends RecyclerView.Adapter<PembayaranAdapter.ItemRowHolder> {
    ArrayList<PembayaranModel> dataPembayaran;
    private Activity activity;

    public PembayaranAdapter (Activity activity, ArrayList<PembayaranModel> dataPembayaran){
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
        holder.tvNama.setText(dataPembayaran.get(i).getNama());
        holder.tvKelas.setText(dataPembayaran.get(i).getKelas());
        holder.tvProgramlevel.setText(dataPembayaran.get(i).getProgramlevel());
    }

    @Override
    public int getItemCount() {
        return (null != dataPembayaran ? dataPembayaran.size() : 0);
    }

    public class ItemRowHolder extends RecyclerView.ViewHolder {
        protected TextView tvNama, tvKelas, tvProgramlevel;
        public ItemRowHolder(View view) {
            super(view);

            this.tvNama = (TextView) view.findViewById(R.id.tvnama);
            this.tvKelas = (TextView) view.findViewById(R.id.tvkelas);
            this.tvProgramlevel = (TextView) view.findViewById(R.id.tvprogramlevel);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(v.getContext(), BelumBayar.class);
                    v.getContext().startActivity(intent);
                }
            });
        }
    }
}
