package com.example.lina.userorangtua.Fitur.Kuisioner;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
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
    public void onBindViewHolder(KuisionerStatusAdapter.ItemRowHolder holder, final int i) {
        final KuisionerStatusModel kuisionerStatusModel = dataKuisioner.get(i);

        Glide.with(activity).load(dataKuisioner.get(i).getFoto()).into(holder.ivGuru);
        holder.tvTanggal.setText(dataKuisioner.get(i).getTanggal());
        holder.tvNamaguru.setText(dataKuisioner.get(i).getNamaguru());
        String status;
        if(dataKuisioner.get(i).getStatuskuisioner().equals("S")){
            status = "Sudah Terisi";
            holder.logo.setBackgroundResource(R.drawable.ic_check_circle_black_24dp);
        } else {
            status = "Belum Terisi";
            holder.logo.setBackgroundResource(R.drawable.ic_highlight_off_black_24dp);
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
                    if(DateParser.now().after(DateParser.parseToDate(dataKuisioner.get(i).getTanggal()))){
                        Intent intent = new Intent(activity, KuisionerIsi.class);
                        intent.putExtra("idkuisioner", kuisionerStatusModel.getIdkuisioner());
                        activity.startActivity(intent);
                    } else {
                        Toast.makeText(activity, "Belum Saatnya Mengisi Kuisioner", Toast.LENGTH_SHORT).show();
                    }
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
        protected ImageView logo, ivGuru;
        protected LinearLayout cvStatuskuisioner;
        public ItemRowHolder(View view) {
            super(view);

            this.tvTanggal = (TextView) view.findViewById(R.id.tvtanggal);
            this.tvNamaguru = (TextView) view.findViewById(R.id.tvnamaguru);
            this.tvStatus = (TextView) view.findViewById(R.id.tvstatuskuisioner);
            this.logo = (ImageView) view.findViewById(R.id.logostatus);
            this.ivGuru = (ImageView) view.findViewById(R.id.ivguru);
            this.cvStatuskuisioner = (LinearLayout) view.findViewById(R.id.cvstatuskuisioner);
        }
    }
}
