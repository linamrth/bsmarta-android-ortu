package com.example.lina.userorangtua.Fitur.Pembayaran;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lina.userorangtua.Model.Pembayaran.PembayaranModel;
import com.example.lina.userorangtua.R;

import java.util.ArrayList;

public class BelumBayarAdapter extends RecyclerView.Adapter<BelumBayarAdapter.ItemRowHolder> {
    ArrayList<PembayaranModel> dataPembayaran;
    private Activity activity;

    public BelumBayarAdapter (Activity activity, ArrayList<PembayaranModel> dataPembayaran){
        this.dataPembayaran = dataPembayaran;
        this.activity = activity;
    }

    @Override
    public BelumBayarAdapter.ItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_belum_bayarcardview, viewGroup, false);
        BelumBayarAdapter.ItemRowHolder mh = new BelumBayarAdapter.ItemRowHolder(view);
        return mh;
    }

    @Override
    public void onBindViewHolder(BelumBayarAdapter.ItemRowHolder holder, int i) {
        holder.tvTanggal.setText(dataPembayaran.get(i).getTanggal());
        holder.tvStatus.setText(dataPembayaran.get(i).getStatus());
    }

    @Override
    public int getItemCount() {
        return (null != dataPembayaran ? dataPembayaran.size() : 0);
    }

    public class ItemRowHolder extends RecyclerView.ViewHolder {
        protected TextView tvTanggal, tvStatus;
        public ItemRowHolder(View view) {
            super(view);

            this.tvTanggal = (TextView) view.findViewById(R.id.tvtanggal);
            this.tvStatus = (TextView) view.findViewById(R.id.tvstatus);
        }
    }
}
