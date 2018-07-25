package com.example.lina.userorangtua.Fitur.Kuisioner;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lina.userorangtua.Model.Kuisioner.KuisionerModel;
import com.example.lina.userorangtua.R;

import java.util.ArrayList;

public class KuisionerAdapter extends RecyclerView.Adapter<KuisionerAdapter.ItemRowHolder> {
    ArrayList<KuisionerModel> dataKuisioner;
    private Context activity;

    public KuisionerAdapter(Context activity, ArrayList<KuisionerModel> dataKuisioner){
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
        final KuisionerModel kuisionerModel = dataKuisioner.get(i);

        holder.tvNama.setText(dataKuisioner.get(i).getNamalengkap());
        holder.tvKelas.setText(dataKuisioner.get(i).getKelas());
        holder.tvProgram.setText(dataKuisioner.get(i).getNamaprogram());
        holder.tvLevel.setText("Level " + dataKuisioner.get(i).getLevel());
        holder.cvKuisioner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, KuisionerStatus.class);
                intent.putExtra("idsiswabelajar", kuisionerModel.getIdsiswabelajar());
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return (null != dataKuisioner ? dataKuisioner.size() : 0);
    }

    public class ItemRowHolder extends RecyclerView.ViewHolder {
        protected TextView tvNama, tvKelas, tvProgram, tvLevel;
        protected ImageView imgnama, imgkelas, imgprogram, imglevel;
        protected CardView cvKuisioner;
        public ItemRowHolder(View view) {
            super(view);

            this.tvNama = (TextView) view.findViewById(R.id.tvnama);
            this.tvKelas = (TextView) view.findViewById(R.id.tvkelas);
            this.tvProgram = (TextView) view.findViewById(R.id.tvprogram);
            this.tvLevel = (TextView) view.findViewById(R.id.tvlevel);
            this.imgnama = (ImageView) view.findViewById(R.id.imgnama2);
            this.imgkelas = (ImageView) view.findViewById(R.id.imgkelas2);
            this.imgprogram = (ImageView) view.findViewById(R.id.imgprogram2);
            this.imglevel = (ImageView) view.findViewById(R.id.imglevel2);
            this.cvKuisioner = (CardView) view.findViewById(R.id.cvkuisioner);
        }
    }
}
