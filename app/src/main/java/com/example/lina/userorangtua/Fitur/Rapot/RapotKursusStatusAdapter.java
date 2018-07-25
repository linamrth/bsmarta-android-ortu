package com.example.lina.userorangtua.Fitur.Rapot;

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

import com.example.lina.userorangtua.Model.Rapot.RapotKursusStatusModel;
import com.example.lina.userorangtua.R;

import java.util.ArrayList;

public class RapotKursusStatusAdapter extends RecyclerView.Adapter<RapotKursusStatusAdapter.ItemRowHolder> {
    ArrayList<RapotKursusStatusModel> dataRapotkursus;
    private Context activity;

    public RapotKursusStatusAdapter(Context activity, ArrayList<RapotKursusStatusModel> dataRapotkursus){
        this.dataRapotkursus = dataRapotkursus;
        this.activity = activity;
    }

    @Override
    public RapotKursusStatusAdapter.ItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_rapot_kursus_statuscardview, viewGroup, false);
        RapotKursusStatusAdapter.ItemRowHolder mh = new RapotKursusStatusAdapter.ItemRowHolder(view);
        return mh;
    }

    @Override
    public void onBindViewHolder(RapotKursusStatusAdapter.ItemRowHolder holder, int i) {
        final RapotKursusStatusModel rapotKursusStatusModel = dataRapotkursus.get(i);

        holder.tvPertemuanke.setText("Pertemuan Ke "+ String.valueOf(i + 1));
        holder.tvHari.setText(dataRapotkursus.get(i).getHari());
        holder.tvTanggal.setText(dataRapotkursus.get(i).getTanggal());
        holder.tvNamaguru.setText(dataRapotkursus.get(i).getNamaguru());
        String status;
        if(dataRapotkursus.get(i).getStatusrapotkursus().equals("S")){
            status = "Sudah Terisi";
            holder.logo.setBackgroundResource(R.drawable.ic_check_circle_black_24dp);
        } else {
            status = "Belum Terisi";
            holder.logo.setBackgroundResource(R.drawable.ic_error_black_24dp);
        }
        holder.tvStatus.setText(status);
        holder.cvStatusrapot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rapotKursusStatusModel.getStatusrapotkursus().equals("S")){
                    Intent intent = new Intent(activity, RapotKursus.class);
                    intent.putExtra("idgenerate", rapotKursusStatusModel.getIdgenerate());
                    activity.startActivity(intent);
                } else {
                    Toast.makeText(activity, "Rapot Belum Terisi", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return (null != dataRapotkursus ? dataRapotkursus.size() : 0);
    }

    public class ItemRowHolder extends RecyclerView.ViewHolder {
        protected TextView tvPertemuanke, tvHari, tvTanggal, tvNamaguru, tvStatus;
        protected ImageView logo;
        protected LinearLayout cvStatusrapot;
        public ItemRowHolder(View view) {
            super(view);

            this.tvPertemuanke = (TextView) view.findViewById(R.id.tvpertemuanke);
            this.tvHari = (TextView) view.findViewById(R.id.tvhari);
            this.tvTanggal = (TextView) view.findViewById(R.id.tvtanggal);
            this.tvNamaguru = (TextView) view.findViewById(R.id.tvnamaguru);
            this.tvStatus = (TextView) view.findViewById(R.id.tvstatusrapot);
            this.logo = (ImageView) view.findViewById(R.id.logostatus);
            this.cvStatusrapot = (LinearLayout) view.findViewById(R.id.cvstatusrapot);
        }
    }
}
