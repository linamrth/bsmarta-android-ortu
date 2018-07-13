package com.example.lina.userorangtua.Fitur.Jadwal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.lina.userorangtua.Api.ApiService;
import com.example.lina.userorangtua.Model.Jadwal.JadwalKursusResultModel;
import com.example.lina.userorangtua.R;

import java.util.ArrayList;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JadwalKursus extends AppCompatActivity {
    private ArrayList<JadwalKursusResultModel> dataJadwal = new ArrayList<>();
    private RecyclerView rv;
    private JadwalKursusAdapter jadwalKursusAdapter;
    private TextView tvHari, tvTanggal, tvJam, tvNamaguru;
    private TextView tvNama, tvKelas, tvProgram, tvLevel;
//    private Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadwal_kursus);
        setTitle("Jadwal Kursus");

        Intent intent = getIntent();
        Integer idsiswabelajar = intent.getIntExtra("idsiswabelajar", 0);
        Log.d("terserah", String.valueOf(idsiswabelajar));

        tvNama = (TextView) findViewById(R.id.tvnama);
        tvKelas = (TextView) findViewById(R.id.tvkelas);
        tvProgram = (TextView) findViewById(R.id.tvprogram);
        tvLevel = (TextView) findViewById(R.id.tvlevel);

        rv = (RecyclerView) findViewById(R.id.rv);

        ApiService.services_get.getJadwalKursus(idsiswabelajar).enqueue(new Callback<JadwalKursusResultModel>() {
            @Override
            public void onResponse(Call<JadwalKursusResultModel> call, Response<JadwalKursusResultModel> response) {
                JadwalKursusResultModel resultModel = response.body();

                //Untuk Informasi Data Siswa
                tvNama.setText(resultModel.getSiswabelajar().get(0).getNamalengkap());
                tvKelas.setText(resultModel.getSiswabelajar().get(0).getKelas());
                tvProgram.setText(resultModel.getSiswabelajar().get(0).getNamaprogram());
                tvLevel.setText("Level " + resultModel.getSiswabelajar().get(0).getLevel());

                //Untuk Looping Data Jadwal Generate
                jadwalKursusAdapter = new JadwalKursusAdapter(JadwalKursus.this, resultModel.getJadwalgenerate());
                rv.setLayoutManager(new LinearLayoutManager(JadwalKursus.this));
                rv.setAdapter(jadwalKursusAdapter);
                rv.getAdapter().notifyDataSetChanged();

                ArrayList<Calendar> calendars = new ArrayList<Calendar>();
                ArrayList<String> jamnyas = new ArrayList<String>();
                Calendar calendar = Calendar.getInstance();
                for (int i = 0; i < resultModel.getJadwalgenerate().size(); i++) {
                    String[] tanggal = resultModel.getJadwalgenerate().get(i).getTanggal().split("-");
                    int tahun = Integer.parseInt(tanggal[0]);
                    int bulan = Integer.parseInt(tanggal[1]);
                    int tgll = Integer.parseInt(tanggal[2]);
                    int jamm = Integer.parseInt(new ChangeJam(resultModel.getJadwalgenerate().get(i).getJam()).getJamNoSpace());

                    Calendar now = Calendar.getInstance();
                    now.set(tahun, (bulan-1), tgll, (jamm-13), 5, 00);

                    if(now.compareTo(calendar) > 0){
                        calendars.add(now);
                        jamnyas.add(new ChangeJam(resultModel.getJadwalgenerate().get(i).getJam()).getJam());
                    }
                }
                setAlarm(calendars, resultModel.getSiswabelajar().get(0).getNamalengkap(), jamnyas);

//                NotificationScheduler.cancelReminder(JadwalKursus.this);
//                for (JadwalKursusGenerateModel model : resultModel.getJadwalgenerate()) {
////                    NotificationScheduler.setReminder(JadwalKursus.this, AlarmReceiver.class, 17, 15, getDateDay(model.getTanggal()), getDateMonth(model.getTanggal()));
//                    NotificationScheduler.setReminder(JadwalKursus.this, AlarmReceiver.class, 18, 18, 6, 7);
//                    Context context = null;
//                    NotificationScheduler.showNotification(context, JadwalKursus.class,
//                            "Kamu punya tugas", "Kerjakan tugas sekarang?");
//                }

            }

            @Override
            public void onFailure(Call<JadwalKursusResultModel> call, Throwable t) {

            }
        });

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == android.R.id.home){
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }

//    public int getDateDay(String s) {
//        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-mm-dd");
//        try {
//            Date date = myFormat.parse(s);
//            return date.getDay();
//        } catch (ParseException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            return 1;
//        }
//    }
//
//    public int getDateMonth(String s) {
//        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-mm-dd");
//        try {
//            Date date = myFormat.parse(s);
//            return date.getMonth();
//        } catch (ParseException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            return 1;
//        }
//    }
    private void setAlarm(ArrayList<Calendar> targetCal, String nama, ArrayList<String> jam){
        AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        for (int i=0; i<targetCal.size(); i++){
            Intent intent = new Intent(getBaseContext(), AlarmReceiver.class);
            intent.putExtra("siswa", nama);
            intent.putExtra("jams", jam.get(i));
            PendingIntent pendingIntent = PendingIntent.getBroadcast(getBaseContext(), i, intent, 0);
            alarmManager.set(AlarmManager.RTC_WAKEUP, targetCal.get(i).getTimeInMillis(), pendingIntent);
        }
    }
}
