package com.example.lina.userorangtua.Fitur.Rapot;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lina.userorangtua.Model.Rapot.RapotTrialModel;
import com.example.lina.userorangtua.R;

import java.util.ArrayList;

public class RapotTrialAdapter extends RecyclerView.Adapter<RapotTrialAdapter.ItemRowHolder> {
    ArrayList<RapotTrialModel> dataRapottrial;
    private Context activity;

    public RapotTrialAdapter(Context activity, ArrayList<RapotTrialModel> dataRapottrial){
        this.dataRapottrial = dataRapottrial;
        this.activity = activity;
    }

    @Override
    public RapotTrialAdapter.ItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_rapot_trialcardview, viewGroup, false);
        RapotTrialAdapter.ItemRowHolder mh = new RapotTrialAdapter.ItemRowHolder(view);
        return mh;
    }

    @Override
    public void onBindViewHolder(RapotTrialAdapter.ItemRowHolder holder, int i) {
        RapotTrialModel model = dataRapottrial.get(i);

//        holder.tvPertemuan.setText("Pertemuan "+ String.valueOf(i + 1));
//        holder.tvHari.setText(model.getHari());
//        holder.tvTanggal.setText(model.getTanggal());
//        holder.tvNamaguru.setText(model.getNamaguru());
    }

    @Override
    public int getItemCount() {
        return (null != dataRapottrial ? dataRapottrial.size() : 0);
    }

    public class ItemRowHolder extends RecyclerView.ViewHolder {
        protected TextView tvSoal, tvJawaban;
        public ItemRowHolder(View view) {
            super(view);

            this.tvSoal = (TextView) view.findViewById(R.id.tvsoal);
            this.tvJawaban = (TextView) view.findViewById(R.id.tvjawaban);
        }
    }
}
