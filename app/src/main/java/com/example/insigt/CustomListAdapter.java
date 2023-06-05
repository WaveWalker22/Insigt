package com.example.insigt;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.List;

public class CustomListAdapter  extends BaseAdapter {

    private List<Job> listData;
    private LayoutInflater layoutInflater;
    private Context context;


    public CustomListAdapter(Context aContext,  List<Job> listData) {
        this.context = aContext;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("SetTextI18n")
    public View getView(int position, View convertView, ViewGroup parent) {
        System.out.println("11");
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_item_layout, null);
            holder = new ViewHolder();
            holder.JobNameView = (TextView) convertView.findViewById(R.id.textView_jobName);
            holder.totalTimeView = (TextView) convertView.findViewById(R.id.textView_totalTime);
            holder.play_pause_button_item = (ToggleButton)convertView.findViewById(R.id.play_pause_button_item);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Job Job = this.listData.get(position);
        holder.JobNameView.setText(Job.getJobName());
        holder.totalTimeView.setText("total time: " + Job.getTotalTime());
        holder.play_pause_button_item.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Кнопка в режиме Pause
                    holder.play_pause_button_item.setBackgroundResource(R.drawable.stop_icon);

                    // выполнить действия при нажатии на кнопку Pause
                    long elapsedRealtime = SystemClock.elapsedRealtime();
//        // Set the time that the count-up timer is in reference to.
                } else {
                    // Кнопка в режиме Play
                    holder.play_pause_button_item.setBackgroundResource(R.drawable.play_icon);
                    // выполнить действия при нажатии на кнопку Play
                }
            }
        });

        return convertView;
    }


    static class ViewHolder {
        TextView JobNameView;
        TextView totalTimeView;

        ToggleButton play_pause_button_item;
    }

}