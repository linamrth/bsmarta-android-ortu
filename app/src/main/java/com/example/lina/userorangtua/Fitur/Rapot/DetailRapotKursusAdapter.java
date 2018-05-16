package com.example.lina.userorangtua.Fitur.Rapot;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lina.userorangtua.Model.Rapot.RapotModel;
import com.example.lina.userorangtua.R;

import java.util.ArrayList;

public class DetailRapotKursusAdapter extends RecyclerView.Adapter<DetailRapotKursusAdapter.ItemRowHolder>{
    ArrayList<RapotModel> dataDetailrapot;
    private Activity activity;

    public DetailRapotKursusAdapter(Activity activity, ArrayList<RapotModel> dataDetailrapot){
        this.dataDetailrapot = dataDetailrapot;
        this.activity = activity;
    }

    @Override
    public DetailRapotKursusAdapter.ItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_detail_rapot_kursuscardview, viewGroup, false);
        DetailRapotKursusAdapter.ItemRowHolder mh = new DetailRapotKursusAdapter.ItemRowHolder(view);
        return mh;
    }

    @Override
    public void onBindViewHolder(DetailRapotKursusAdapter.ItemRowHolder holder, int i) {
        holder.tvNama.setText(dataDetailrapot.get(i).getNama());
        holder.tvKelas.setText(dataDetailrapot.get(i).getKelas());
        holder.tvProgramlevel.setText(dataDetailrapot.get(i).getProgramlevel());
    }

    @Override
    public int getItemCount() {
        return (null != dataDetailrapot ? dataDetailrapot.size() : 0);
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

                    Intent intent = new Intent(v.getContext(), RapotKursusSudahTerisi.class);
                    v.getContext().startActivity(intent);
                }
            });
        }
    }
}
