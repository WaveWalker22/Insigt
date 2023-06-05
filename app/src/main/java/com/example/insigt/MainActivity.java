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
    private ToggleButton play_pause_button;
    private TextView tv;

    //@SuppressLint("MissingInflatedId")
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView)findViewById(R.id.textView_jobName) ;
        //Toast.makeText(MainActivity.this, "Selected :" + tv.getText().toString() + " ", Toast.LENGTH_LONG).show();
        chronometer = (Chronometer)findViewById(R.id.chronometer);
        play_pause_button = findViewById(R.id.play_pause_button);

        List<Job> image_details = getListData();
        final ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new CustomListAdapter(this, image_details));


//        play_pause_button_item.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (isChecked) {
//                    // Кнопка в режиме Pause
//                    play_pause_button_item.setBackgroundResource(R.drawable.stop_icon);
//
//                    // выполнить действия при нажатии на кнопку Pause
//                    long elapsedRealtime = SystemClock.elapsedRealtime();
////        // Set the time that the count-up timer is in reference to.
//                    chronometer.setBase(elapsedRealtime);
//                    chronometer.start();
//                } else {
//                    // Кнопка в режиме Play
//                    play_pause_button_item.setBackgroundResource(R.drawable.play_icon);
//                    // выполнить действия при нажатии на кнопку Play
//                    chronometer.stop();
//                }
//            }
//        });

        // When the user clicks on the ListItem
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

//            @Override
//            public void onItemClick(AdapterView<?> a, View v, int position, long id) {

//                Toast.makeText(MainActivity.this, "Selected :" + id + " ", Toast.LENGTH_LONG).show();
//                Job job = (Job) listView.getItemAtPosition(position);
                //Toast.makeText(MainActivity.this, "Selected :" + " " + job, Toast.LENGTH_LONG).show();
//            }
//
//        });


        // Нижняя панель




        play_pause_button.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Кнопка в режиме Pause
                    play_pause_button.setBackgroundResource(R.drawable.stop_icon);

                    // выполнить действия при нажатии на кнопку Pause
                    long elapsedRealtime = SystemClock.elapsedRealtime();
//        // Set the time that the count-up timer is in reference to.
                    chronometer.setBase(elapsedRealtime);
                    chronometer.start();
                } else {
                    // Кнопка в режиме Play
                    play_pause_button.setBackgroundResource(R.drawable.play_icon);
                    // выполнить действия при нажатии на кнопку Play
                    chronometer.stop();
                }
            }
        });

}

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