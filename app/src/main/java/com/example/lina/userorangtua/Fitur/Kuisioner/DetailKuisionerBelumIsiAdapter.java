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

public class DetailKuisionerBelumIsiAdapter extends RecyclerView.Adapter<DetailKuisionerBelumIsiAdapter.ItemRowHolder> {
    ArrayList<KuisionerModel> dataKuisioner;
    private Activity activity;

    public DetailKuisionerBelumIsiAdapter(Activity activity, ArrayList<KuisionerModel> dataKuisioner){
        this.dataKuisioner = dataKuisioner;
        this.activity = activity;
    }

    @Override
    public DetailKuisionerBelumIsiAdapter.ItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_detail_kuisioner_belum_isicardview, viewGroup, false);
        DetailKuisionerBelumIsiAdapter.ItemRowHolder mh = new DetailKuisionerBelumIsiAdapter.ItemRowHolder(view);
        return mh;
    }

    @Override
    public void onBindViewHolder(DetailKuisionerBelumIsiAdapter.ItemRowHolder holder, int i) {
        holder.tvTanggal.setText(dataKuisioner.get(i).getTanggal());
        holder.tvNamaguru.setText(dataKuisioner.get(i).getNamaguru());
        holder.tvStatusbelumterisi.setText(dataKuisioner.get(i).getStatusbelumisi());
    }

    @Override
    public int getItemCount() {
        return (null != dataKuisioner ? dataKuisioner.size() : 0);
    }

    public class ItemRowHolder extends RecyclerView.ViewHolder {
        protected TextView tvTanggal, tvNamaguru, tvStatusbelumterisi;
        public ItemRowHolder(View view) {
            super(view);

            this.tvTanggal = (TextView) view.findViewById(R.id.tvtanggal);
            this.tvNamaguru = (TextView) view.findViewById(R.id.tvnamaguru);
            this.tvStatusbelumterisi = (TextView) view.findViewById(R.id.tvstatusrapot);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(v.getContext(), KuisionerBelumIsi.class);
                    v.getContext().startActivity(intent);
                }
            });
        }
    }
}
