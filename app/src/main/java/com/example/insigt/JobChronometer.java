package com.example.insigt;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

public class JobChronometer {
    private TextView textViewInfo;
    private Chronometer chronometer;
    private Button buttonStart;
    private Button buttonStop;
    private Button buttonResetBaseTime;

    public JobChronometer(View view) {
        this.textViewInfo = (TextView) view.findViewById(R.id.textView_info);
        this.chronometer = (Chronometer) view.findViewById(R.id.chronometer);

        this.buttonStart = (Button)view.findViewById(R.id.button_start);
        this.buttonStop = (Button)view.findViewById(R.id.button_stop);
        this.buttonResetBaseTime = (Button)view.findViewById(R.id.button_resetBaseTime);

        this.buttonStop.setEnabled(false);
        this.buttonResetBaseTime.setEnabled(false);

        this.buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doStart();
            }
        });

        this.buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doStop();
            }
        });


        this.buttonResetBaseTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doResetBaseTime();
            }
        });
    }

    // @totalMilliseconds: milliseconds since system boot, including time spent in sleep.
    @SuppressLint("SetTextI18n")
    private void showInfo(long totalMilliseconds)  {
        // Seconds
        long totalSecs = totalMilliseconds / 1000;
        // Show Info
        long hours = totalSecs / 3600;
        long minutes = (totalSecs % 3600) / 60;
        long seconds = totalSecs % 60;

        this.textViewInfo.setText("Base Time: " + totalSecs +" ~ " + hours + " hours " + minutes+" minutes " + seconds + " seconds");
    }

    private void doStart()  {
        // Returns milliseconds since system boot, including time spent in sleep.
        long elapsedRealtime = SystemClock.elapsedRealtime();
        // Set the time that the count-up timer is in reference to.
        this.chronometer.setBase(elapsedRealtime - 10000);
        this.chronometer.start();
        this.showInfo(elapsedRealtime);
        //
        this.buttonStart.setEnabled(false);
        this.buttonStop.setEnabled(true);
        this.buttonResetBaseTime.setEnabled(true);
    }

    private void doStop()  {
        this.chronometer.stop();
        //
        this.buttonStart.setEnabled(true);
        this.buttonStop.setEnabled(false);
        this.buttonResetBaseTime.setEnabled(false);
    }

    private void doResetBaseTime()  {
        // Returns milliseconds since system boot, including time spent in sleep.
        long elapsedRealtime = SystemClock.elapsedRealtime();
        // Set the time that the count-up timer is in reference to.
        this.chronometer.setBase(elapsedRealtime);
        this.showInfo(elapsedRealtime);
    }
}