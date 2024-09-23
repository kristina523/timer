package com.example.mobilki2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.widget.Toast;

public class Alarm extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String type = intent.getStringExtra("type");

        if ("alarm".equals(type)) {
            Toast.makeText(context, "Будильник сработал!", Toast.LENGTH_LONG).show();
        } else if ("timer".equals(type)) {
            Toast.makeText(context, "Таймер завершен!", Toast.LENGTH_LONG).show();
        }

        Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        if (vibrator != null) {
            vibrator.vibrate(1000);
        }
    }
}