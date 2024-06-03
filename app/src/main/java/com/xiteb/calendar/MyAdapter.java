package com.xiteb.calendar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<Event> list;

    public MyAdapter(Context context, ArrayList<Event> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.events, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Event event = list.get(position);
        holder.title.setText(event.getTitle());
        holder.date.setText(event.getDate());
        holder.startTime.setText(event.getStartTime());
        holder.endTime.setText(event.getEndTime());
        holder.note.setText(event.getNote());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView title, note, date, startTime, endTime;

        public MyViewHolder(@NonNull View eventView){
            super(eventView);

            title = eventView.findViewById(R.id.title);
            note = eventView.findViewById(R.id.note);
            date = eventView.findViewById(R.id.dateInput);
            startTime = eventView.findViewById(R.id.startTimeInput);
            endTime = eventView.findViewById(R.id.endTimeInput);

        }
    }
}