package com.example.lina.userorangtua.Fitur.Rapot;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lina.userorangtua.Model.Rapot.DetailRapotKursusModel;
import com.example.lina.userorangtua.R;

import java.util.ArrayList;

public class DetailRapotKursusAdapter extends RecyclerView.Adapter<DetailRapotKursusAdapter.ItemRowHolder>{
    ArrayList<DetailRapotKursusModel> dataDetailrapot;
    private Context activity;

    public DetailRapotKursusAdapter(Context activity, ArrayList<DetailRapotKursusModel> dataDetailrapot){
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
        final DetailRapotKursusModel detailRapotKursusModel = dataDetailrapot.get(i);

        holder.tvNama.setText(dataDetailrapot.get(i).getNamalengkap());
        holder.tvKelas.setText(dataDetailrapot.get(i).getKelas());
        holder.tvProgram.setText(dataDetailrapot.get(i).getNamaprogram());
        holder.tvLevel.setText(dataDetailrapot.get(i).getLevel());
        holder.cvDetailrapotkursus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, RapotKursusSudahTerisi.class);
                intent.putExtra("idtrial", detailRapotKursusModel.getIdsiswabelajar());
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return (null != dataDetailrapot ? dataDetailrapot.size() : 0);
    }

    public class ItemRowHolder extends RecyclerView.ViewHolder {
        protected TextView tvNama, tvKelas, tvProgram, tvLevel;
        protected CardView cvDetailrapotkursus;
        public ItemRowHolder(View view) {
            super(view);

            this.tvNama = (TextView) view.findViewById(R.id.tvnama);
            this.tvKelas = (TextView) view.findViewById(R.id.tvkelas);
            this.tvProgram = (TextView) view.findViewById(R.id.tvprogram);
            this.tvLevel = (TextView) view.findViewById(R.id.tvlevel);
            this.cvDetailrapotkursus = (CardView) view.findViewById(R.id.cvdetailrapotkursus);
        }
    }
}
