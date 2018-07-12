package com.example.lina.userorangtua.Fitur.Jadwal;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import com.example.lina.userorangtua.R;

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context arg0, Intent arg1) {
//        Toast.makeText(arg0, "Alarm received!", Toast.LENGTH_LONG).show();

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(arg0)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Reminder Orang Tua")
                        .setContentText("Waktunya kursus untuk siswa " + arg1.getStringExtra("siswa") + " jam " + arg1.getStringExtra("jams"));

        NotificationManager mNotificationManager = (NotificationManager) arg0.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(1, mBuilder.build());
    }

}
