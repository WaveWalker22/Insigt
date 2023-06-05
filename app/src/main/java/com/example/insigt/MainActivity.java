package com.example.insigt;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Chronometer chronometer;
    private ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        List<Job> image_details = getListData();
        final ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new CustomListAdapter(this, image_details));

        // When the user clicks on the ListItem
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Job job = (Job) listView.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, "Selected :" + " " + job, Toast.LENGTH_LONG).show();
            }
        });


        // Нижняя панель
        this.chronometer = (Chronometer)findViewById(R.id.chronometer);

        toggleButton = findViewById(R.id.play_pause_button);

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Кнопка в режиме Pause
                    toggleButton.setBackgroundResource(R.drawable.stop_icon);

                    // выполнить действия при нажатии на кнопку Pause
                    long elapsedRealtime = SystemClock.elapsedRealtime();
//        // Set the time that the count-up timer is in reference to.
                    chronometer.setBase(elapsedRealtime);
                    chronometer.start();
                } else {
                    // Кнопка в режиме Play
                    toggleButton.setBackgroundResource(R.drawable.play_icon);
                    // выполнить действия при нажатии на кнопку Play
                    chronometer.stop();
                }
            }
        });

}

    // @totalMilliseconds: milliseconds since system boot, including time spent in sleep.
//    @SuppressLint("SetTextI18n")
//    private void showInfo(long totalMilliseconds)  {
//        // Seconds
//        long totalSecs = totalMilliseconds / 1000;
//        // Show Info
//        long hours = totalSecs / 3600;
//        long minutes = (totalSecs % 3600) / 60;
//        long seconds = totalSecs % 60;
//
//        //this.textViewInfo.setText("Base Time: " + totalSecs +" ~ " + hours + " hours " + minutes+" minutes " + seconds + " seconds");
//    }

    private  List<Job> getListData() {
        List<Job> list = new ArrayList<Job>();
        Job rab = new Job("Работа");
        Job zar = new Job("Зарядка");
        Job ang = new Job("Английский");


        list.add(rab);
        list.add(zar);
        list.add(ang);
        list.add(rab);
        list.add(zar);
        list.add(ang);
        list.add(rab);
        list.add(zar);
        list.add(ang);
        list.add(rab);
        list.add(zar);
        list.add(ang);
        list.add(rab);
        list.add(zar);
        list.add(ang);
        list.add(rab);
        list.add(zar);
        list.add(ang);
        list.add(rab);
        list.add(zar);
        list.add(ang);
        list.add(rab);
        list.add(zar);
        list.add(ang);

        return list;
    }

}