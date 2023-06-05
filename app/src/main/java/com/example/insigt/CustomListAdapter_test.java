package com.example.insigt;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class CustomListAdapter_test extends ArrayAdapter {

    private List<Job> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomListAdapter_test(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        resource = android.R.layout.simple_list_item_1;
    }


//    public CustomListAdapter_test(Context aContext, List<Job> listData) {
//        this.context = aContext;
//        this.listData = listData;
//        layoutInflater = LayoutInflater.from(aContext);
//    }

//    @Override
//    public int getCount() {
//        return listData.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return listData.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @SuppressLint("SetTextI18n")
//    public View getView(int position, View convertView, ViewGroup parent) {
//        System.out.println("11");
//        ViewHolder holder;
//        if (convertView == null) {
//            convertView = layoutInflater.inflate(R.layout.list_item_layout, null);
//            holder = new ViewHolder();
//            holder.JobNameView = (TextView) convertView.findViewById(R.id.textView_jobName);
//            holder.totalTimeView = (TextView) convertView.findViewById(R.id.textView_totalTime);
//            convertView.setTag(holder);
//        } else {
//            holder = (ViewHolder) convertView.getTag();
//        }
//
//        Job Job = this.listData.get(position);
//        holder.JobNameView.setText(Job.getJobName());
//        holder.totalTimeView.setText("total time: " + Job.getTotalTime());
//
//
//        return convertView;
//    }


    static class ViewHolder {
        TextView JobNameView;
        TextView totalTimeView;
    }

}