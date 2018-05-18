package com.example.lina.userorangtua.Fitur.Pembayaran;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lina.userorangtua.Model.Pembayaran.DetailPembayaranBayarModel;
import com.example.lina.userorangtua.R;

import java.util.ArrayList;

public class DetailPembayaranAdapter extends RecyclerView.Adapter<DetailPembayaranAdapter.ItemRowHolder> {
    ArrayList<DetailPembayaranBayarModel> dataPembayaran;
    private Context activity;

    public DetailPembayaranAdapter(Context activity, ArrayList<DetailPembayaranBayarModel> dataPembayaran){
        this.dataPembayaran = dataPembayaran;
        this.activity = activity;
    }

    @Override
    public DetailPembayaranAdapter.ItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_detail_pembayarancardview, viewGroup, false);
        DetailPembayaranAdapter.ItemRowHolder mh = new DetailPembayaranAdapter.ItemRowHolder(view);
        return mh;
    }

    @Override
    public void onBindViewHolder(DetailPembayaranAdapter.ItemRowHolder holder, int i) {
        DetailPembayaranBayarModel detailPembayaranBayarModel = dataPembayaran.get(i);

        holder.tvPembayaranke.setText("Pembayaran Ke "+ String.valueOf(i + 1));
        holder.tvTanggal.setText(dataPembayaran.get(i).getTanggal());
        String status;
        if(dataPembayaran.get(i).getStatuspembayaran().equals("S")){
            status = "Sudah Bayar";
        } else {
            status = "Belum Bayar";
        }
        holder.tvStatus.setText(status);
    }

    @Override
    public int getItemCount() {
        return (null != dataPembayaran ? dataPembayaran.size() : 0);
    }

    public class ItemRowHolder extends RecyclerView.ViewHolder {
        protected TextView tvPembayaranke, tvTanggal, tvStatus;
        public ItemRowHolder(View view) {
            super(view);

            this.tvPembayaranke = (TextView) view.findViewById(R.id.tvpembayaranke);
            this.tvTanggal = (TextView) view.findViewById(R.id.tvtanggal);
            this.tvStatus = (TextView) view.findViewById(R.id.tvstatuspembayaran);
        }
    }
}
