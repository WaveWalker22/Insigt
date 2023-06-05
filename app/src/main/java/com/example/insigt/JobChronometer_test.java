package com.example.insigt;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class JobChronometer_test extends AppCompatActivity {
    private Chronometer chronometer;
    private Button buttonStart;
    private Button buttonStop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chronometer = (Chronometer) findViewById(R.id.chronometer);
        buttonStart = (Button) findViewById(R.id.button_start);
        buttonStop = (Button) findViewById(R.id.button_stop);
        buttonStop.setEnabled(false);
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doStart();
            }
        });

        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doStop();
            }
        });
    }

    private void doStart() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        chronometer.setBase(elapsedRealtime);
        chronometer.start();
        buttonStart.setEnabled(false);
        buttonStop.setEnabled(true);
    }

    private void doStop() {
        chronometer.stop();
        buttonStart.setEnabled(true);
        buttonStop.setEnabled(false);
    }

    public Chronometer getChronometer() {
        return chronometer;
    }
}

