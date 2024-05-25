package com.xiteb.calendar;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.xiteb.calendar.databinding.ActivityCreateEventBinding;
import com.xiteb.calendar.databinding.ActivityMainBinding;

import java.util.List;

public class CreateEvent extends AppCompatActivity {

     String titleInput;
     String dateInput;
//    private EditText startTimeInput;
//    private EditText endTimeInput;
     String noteInput;
    String selectedDate;
    ActivityCreateEventBinding binding;
    FirebaseDatabase db;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCreateEventBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.dateInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
        binding.createEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                titleInput = binding.title.getText().toString();
                noteInput = binding.note.getText().toString();


                dateInput = binding.dateInput.getText().toString();

                Event event = new Event(titleInput, noteInput, dateInput);

                db = FirebaseDatabase.getInstance();
                reference = db.getReference("Events");
                reference.child(titleInput).setValue(event).addOnCompleteListener(new OnCompleteListener<Void>() {

                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        binding.title.setText("");
                        binding.note.setText("");
                        binding.dateInput.setText("");
                        Toast.makeText(CreateEvent.this, "Added",Toast.LENGTH_SHORT).show();

                    }
                });


            }
        });
        
    }

    private void openDialog() {
        DatePickerDialog dialog =new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String selectedDate = String.format("%04d/%02d/%02d", year, month, dayOfMonth);
                binding.dateInput.setText(selectedDate);
            }
        }, 2024, 05, 24);
        dialog.show();

    }


}
