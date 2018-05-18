package com.example.lina.userorangtua.Fitur.Kuisioner;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lina.userorangtua.Model.Kuisioner.KuisionerStatusModel;
import com.example.lina.userorangtua.R;

import java.util.ArrayList;

public class KuisionerStatusAdapter extends RecyclerView.Adapter<KuisionerStatusAdapter.ItemRowHolder> {
    ArrayList<KuisionerStatusModel> dataKuisioner;
    private Context activity;

    public KuisionerStatusAdapter(Context activity, ArrayList<KuisionerStatusModel> dataKuisioner){
        this.dataKuisioner = dataKuisioner;
        this.activity = activity;
    }

    @Override
    public KuisionerStatusAdapter.ItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_kuisioner_statuscardview, viewGroup, false);
        KuisionerStatusAdapter.ItemRowHolder mh = new KuisionerStatusAdapter.ItemRowHolder(view);
        return mh;
    }

    @Override
    public void onBindViewHolder(KuisionerStatusAdapter.ItemRowHolder holder, int i) {
        final KuisionerStatusModel kuisionerStatusModel = dataKuisioner.get(i);

        holder.tvTanggal.setText(dataKuisioner.get(i).getTanggal());
        holder.tvNamaguru.setText(dataKuisioner.get(i).getNamaguru());
        String status;
        if(dataKuisioner.get(i).getStatuskuisioner().equals("S")){
            status = "Sudah Terisi";
        } else {
            status = "Belum Terisi";
        }
        holder.tvStatus.setText(status);
        holder.cvStatuskuisioner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(kuisionerStatusModel.getStatuskuisioner().equals("S")){
                    Intent intent = new Intent(activity, KuisionerLihat.class);
                    intent.putExtra("idkuisioner", kuisionerStatusModel.getIdkuisioner());
                    activity.startActivity(intent);
                }
                else {
                    Intent intent = new Intent(activity, KuisionerIsi.class);
                    intent.putExtra("idkuisioner", kuisionerStatusModel.getIdkuisioner());
                    activity.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return (null != dataKuisioner ? dataKuisioner.size() : 0);
    }

    public class ItemRowHolder extends RecyclerView.ViewHolder {
        protected TextView tvTanggal, tvNamaguru, tvStatus;
        protected CardView cvStatuskuisioner;
        public ItemRowHolder(View view) {
            super(view);

            this.tvTanggal = (TextView) view.findViewById(R.id.tvtanggal);
            this.tvNamaguru = (TextView) view.findViewById(R.id.tvnamaguru);
            this.tvStatus = (TextView) view.findViewById(R.id.tvstatuskuisioner);
            this.cvStatuskuisioner = (CardView) view.findViewById(R.id.cvstatuskuisioner);
        }
    }
}
