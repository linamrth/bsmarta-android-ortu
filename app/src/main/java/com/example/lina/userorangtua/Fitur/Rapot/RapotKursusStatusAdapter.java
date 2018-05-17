package com.example.lina.userorangtua.Fitur.Rapot;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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

        holder.tvTanggal.setText(dataRapotkursus.get(i).getTanggal());
        holder.tvNamaguru.setText(dataRapotkursus.get(i).getNamaguru());
        holder.tvStatus.setText(dataRapotkursus.get(i).getStatusrapotkursus());
        holder.cvStatusrapot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, RapotKursus.class);
                intent.putExtra("idgenerate", rapotKursusStatusModel.getIdgenerate());
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return (null != dataRapotkursus ? dataRapotkursus.size() : 0);
    }

    public class ItemRowHolder extends RecyclerView.ViewHolder {
        protected TextView tvTanggal, tvNamaguru, tvStatus;
        protected CardView cvStatusrapot;
        public ItemRowHolder(View view) {
            super(view);

            this.tvTanggal = (TextView) view.findViewById(R.id.tvtanggal);
            this.tvNamaguru = (TextView) view.findViewById(R.id.tvnamaguru);
            this.tvStatus = (TextView) view.findViewById(R.id.tvstatusrapot);
            this.cvStatusrapot = (CardView) view.findViewById(R.id.cvstatusrapot);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(v.getContext(), RapotKursus.class);
                    v.getContext().startActivity(intent);
                }
            });
        }
    }
}
