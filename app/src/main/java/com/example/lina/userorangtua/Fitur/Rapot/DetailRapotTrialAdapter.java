package com.example.lina.userorangtua.Fitur.Rapot;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lina.userorangtua.Model.Rapot.DetailRapotTrialModel;
import com.example.lina.userorangtua.R;

import java.util.ArrayList;

public class DetailRapotTrialAdapter extends RecyclerView.Adapter<DetailRapotTrialAdapter.ItemRowHolder> {
    ArrayList<DetailRapotTrialModel> dataDetailrapot;
    private Context activity;

    public DetailRapotTrialAdapter(Context activity, ArrayList<DetailRapotTrialModel> dataDetailrapot){
        this.dataDetailrapot = dataDetailrapot;
        this.activity = activity;
    }

    @Override
    public DetailRapotTrialAdapter.ItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_detail_rapot_trialcardview, viewGroup, false);
        DetailRapotTrialAdapter.ItemRowHolder mh = new DetailRapotTrialAdapter.ItemRowHolder(view);
        return mh;
    }

    @Override
    public void onBindViewHolder(DetailRapotTrialAdapter.ItemRowHolder holder, int i) {
        holder.tvNama.setText(dataDetailrapot.get(i).getNamalengkap());
        holder.tvKelas.setText(dataDetailrapot.get(i).getKelas());
        holder.tvProgram.setText(dataDetailrapot.get(i).getNamaprogram());
    }

    @Override
    public int getItemCount() {
        return (null != dataDetailrapot ? dataDetailrapot.size() : 0);
    }

    public class ItemRowHolder extends RecyclerView.ViewHolder {
        protected TextView tvNama, tvKelas, tvProgram;
        public ItemRowHolder(View view) {
            super(view);

            this.tvNama = (TextView) view.findViewById(R.id.tvnama);
            this.tvKelas = (TextView) view.findViewById(R.id.tvkelas);
            this.tvProgram = (TextView) view.findViewById(R.id.tvprogram);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(v.getContext(), RapotTrial.class);
                    v.getContext().startActivity(intent);
                }
            });
        }
    }
}
