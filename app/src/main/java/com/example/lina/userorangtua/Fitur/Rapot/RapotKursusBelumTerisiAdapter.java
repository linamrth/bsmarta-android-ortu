package com.example.lina.userorangtua.Fitur.Rapot;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lina.userorangtua.Model.Rapot.RapotModel;
import com.example.lina.userorangtua.R;

import java.util.ArrayList;

public class RapotKursusBelumTerisiAdapter extends RecyclerView.Adapter<RapotKursusBelumTerisiAdapter.ItemRowHolder> {
    ArrayList<RapotModel> dataRapotkursus;
    private Activity activity;

    public RapotKursusBelumTerisiAdapter(Activity activity, ArrayList<RapotModel> dataRapotkursus){
        this.dataRapotkursus = dataRapotkursus;
        this.activity = activity;
    }

    @Override
    public RapotKursusBelumTerisiAdapter.ItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_rapot_kursus_belum_terisicardview, viewGroup, false);
        RapotKursusBelumTerisiAdapter.ItemRowHolder mh = new RapotKursusBelumTerisiAdapter.ItemRowHolder(view);
        return mh;
    }

    @Override
    public void onBindViewHolder(RapotKursusBelumTerisiAdapter.ItemRowHolder holder, int i) {
        holder.tvTanggal.setText(dataRapotkursus.get(i).getTanggal());
        holder.tvNamaguru.setText(dataRapotkursus.get(i).getNamaguru());
        holder.tvStatusbelumterisi.setText(dataRapotkursus.get(i).getStatusbelumterisi());
    }

    @Override
    public int getItemCount() {
        return (null != dataRapotkursus ? dataRapotkursus.size() : 0);
    }

    public class ItemRowHolder extends RecyclerView.ViewHolder {
        protected TextView tvTanggal, tvNamaguru, tvStatusbelumterisi;
        public ItemRowHolder(View view) {
            super(view);

            this.tvTanggal = (TextView) view.findViewById(R.id.tvtanggal);
            this.tvNamaguru = (TextView) view.findViewById(R.id.tvnamaguru);
            this.tvStatusbelumterisi = (TextView) view.findViewById(R.id.tvstatusrapot);
        }
    }
}
