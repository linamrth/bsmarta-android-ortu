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

public class DetailKuisionerAdapter extends RecyclerView.Adapter<DetailKuisionerAdapter.ItemRowHolder> {
    ArrayList<KuisionerModel> dataKuisioner;
    private Activity activity;

    public DetailKuisionerAdapter(Activity activity, ArrayList<KuisionerModel> dataKuisioner){
        this.dataKuisioner = dataKuisioner;
        this.activity = activity;
    }

    @Override
    public DetailKuisionerAdapter.ItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_detail_kuisionercardview, viewGroup, false);
        DetailKuisionerAdapter.ItemRowHolder mh = new DetailKuisionerAdapter.ItemRowHolder(view);
        return mh;
    }

    @Override
    public void onBindViewHolder(DetailKuisionerAdapter.ItemRowHolder holder, int i) {
        holder.tvTanggal.setText(dataKuisioner.get(i).getTanggal());
        holder.tvNamaguru.setText(dataKuisioner.get(i).getNamaguru());
        holder.tvStatussudahisi.setText(dataKuisioner.get(i).getStatussudahisi());
    }

    @Override
    public int getItemCount() {
        return (null != dataKuisioner ? dataKuisioner.size() : 0);
    }

    public class ItemRowHolder extends RecyclerView.ViewHolder {
        protected TextView tvTanggal, tvNamaguru, tvStatussudahisi;
        public ItemRowHolder(View view) {
            super(view);

            this.tvTanggal = (TextView) view.findViewById(R.id.tvtanggal);
            this.tvNamaguru = (TextView) view.findViewById(R.id.tvnamaguru);
            this.tvStatussudahisi = (TextView) view.findViewById(R.id.tvstatusrapot);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(v.getContext(), KuisionerSudahIsi.class);
                    v.getContext().startActivity(intent);
                }
            });
        }
    }
}
