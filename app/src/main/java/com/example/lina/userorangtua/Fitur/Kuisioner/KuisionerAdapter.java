package com.example.lina.userorangtua.Fitur.Kuisioner;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lina.userorangtua.Model.Kuisioner.KuisionerModel;
import com.example.lina.userorangtua.R;

import java.util.ArrayList;

public class KuisionerAdapter extends RecyclerView.Adapter<KuisionerAdapter.ItemRowHolder> {
    ArrayList<KuisionerModel> dataKuisioner;
    private Activity activity;

    public KuisionerAdapter(Activity activity, ArrayList<KuisionerModel> dataKuisioner){
        this.dataKuisioner = dataKuisioner;
        this.activity = activity;
    }

    @Override
    public ItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_kuisioner_cardview, viewGroup, false);
        ItemRowHolder mh = new ItemRowHolder(view);
        return mh;
    }

    @Override
    public void onBindViewHolder(ItemRowHolder holder, int i) {
        holder.tvNama.setText(dataKuisioner.get(i).getNama());
        holder.tvKelas.setText(dataKuisioner.get(i).getKelas());
        holder.tvProgramlevel.setText(dataKuisioner.get(i).getProgramlevel());
    }

    @Override
    public int getItemCount() {
        return (null != dataKuisioner ? dataKuisioner.size() : 0);
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

                    Intent intent = new Intent(v.getContext(), DetailKuisionerSudahIsi.class);
                    v.getContext().startActivity(intent);
                }
            });
        }
    }
}
