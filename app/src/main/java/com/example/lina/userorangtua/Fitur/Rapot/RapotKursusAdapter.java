package com.example.lina.userorangtua.Fitur.Rapot;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lina.userorangtua.R;

public class RapotKursusAdapter extends BaseAdapter {
    Context context;
    String judul[];
    String caption[];
    LayoutInflater inflater;

    public RapotKursusAdapter(Context applicationContext, String[] judul, String[] caption){
        this.context = context;
        this.judul = judul;
        this.caption = caption;
        inflater = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return judul.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.activity_rapot_kursusisi, null);

        TextView titles = (TextView) view.findViewById(R.id.tvjudul);
        TextView deskripsi = (TextView) view.findViewById(R.id.tvcaption);

        titles.setText(judul[i]);
        deskripsi.setText(caption[i]);

        return view;
    }
}
