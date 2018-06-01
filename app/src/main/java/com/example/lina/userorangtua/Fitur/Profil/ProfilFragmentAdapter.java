package com.example.lina.userorangtua.Fitur.Profil;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lina.userorangtua.Model.Profil.ProfileSiswaModel;
import com.example.lina.userorangtua.R;

import java.util.ArrayList;

public class ProfilFragmentAdapter extends RecyclerView.Adapter<ProfilFragmentAdapter.ItemRowHolder> {
    ArrayList<ProfileSiswaModel> dataSiswa;
    private Context activity;

    public ProfilFragmentAdapter (Context activity, ArrayList<ProfileSiswaModel> dataSiswa){
        this.dataSiswa = dataSiswa;
        this.activity = activity;
    }

    @Override
    public ItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_profil_siswa, viewGroup, false);
        ProfilFragmentAdapter.ItemRowHolder mh = new ProfilFragmentAdapter.ItemRowHolder(view);
        return mh;
    }

    @Override
    public void onBindViewHolder(ItemRowHolder holder, int i) {
        final ProfileSiswaModel profileSiswaModel = dataSiswa.get(i);

        holder.tvNama.setText(dataSiswa.get(i).getNamalengkap());
        holder.tvKelas.setText(dataSiswa.get(i).getKelas());
    }

    @Override
    public int getItemCount() {
        return (null != dataSiswa ? dataSiswa.size() : 0);
    }

    public class ItemRowHolder extends RecyclerView.ViewHolder {
        protected TextView tvNama, tvKelas;
        public ItemRowHolder(View view) {
            super(view);

            this.tvNama = (TextView) view.findViewById(R.id.tvnamasiswa);
            this.tvKelas = (TextView) view.findViewById(R.id.tvkelas);
        }
    }
}
