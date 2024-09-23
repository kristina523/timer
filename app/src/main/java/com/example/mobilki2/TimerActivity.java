package com.example.mobilki2;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class TimerActivity extends AppCompatActivity {

    EditText edtSeconds;
    Button btnStartTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timer_activity);

        edtSeconds = findViewById(R.id.edtSeconds);
        btnStartTimer = findViewById(R.id.btnStartTimer);

        btnStartTimer.setOnClickListener(view -> {
            int seconds = Integer.parseInt(edtSeconds.getText().toString());

            Intent intent = new Intent(TimerActivity.this, Alarm.class);
            intent.putExtra("type", "timer"); // Указываю, что это таймер
            PendingIntent pendingIntent = PendingIntent.getBroadcast(
                    TimerActivity.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT
            );


            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
            if (alarmManager != null) {
                alarmManager.set(
                        AlarmManager.RTC_WAKEUP,
                        System.currentTimeMillis() + seconds * 1000L,
                        pendingIntent
                );
            }


        });
    }
}