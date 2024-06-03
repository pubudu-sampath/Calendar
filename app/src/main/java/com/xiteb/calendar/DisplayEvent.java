package com.xiteb.calendar;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.xiteb.calendar.databinding.ActivityDisplayEventBinding;
//import com.xiteb.calendar.databinding.ActivityCreateEventBinding;
//import com.xiteb.calendar.databinding.ActivityDisplayEventBinding;

import java.util.ArrayList;

public class DisplayEvent extends AppCompatActivity {

    private ActivityDisplayEventBinding binding;
    private ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDisplayEventBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        listView = binding.listView;
        ArrayList<String> list = new ArrayList<>();
        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Events").child("");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    Event event = snapshot.getValue(Event.class);
                    String eventsCreated = "Title: " + event.getTitle() + "\n" + "Date: " + event.getDate() + "\n" + "Start Time: " + event.getStartTime() + "\n" + "End Time: " + event.getEndTime() + "\n" + "Note: " + event.getNote();
                    list.add(eventsCreated);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
