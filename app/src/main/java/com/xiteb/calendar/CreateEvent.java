package com.xiteb.calendar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class CreateEvent extends AppCompatActivity {

    private EditText titleInput;
    private EditText dateInput;
    private EditText startTimeInput;
    private EditText endTimeInput;
    private EditText noteInput;
    private Button createEventButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        titleInput = findViewById(R.id.titleInput);
        dateInput = findViewById(R.id.dateInput);
        startTimeInput = findViewById(R.id.startTimeInput);
        endTimeInput = findViewById(R.id.endTimeInput);
        noteInput = findViewById(R.id.noteInput);
        createEventButton = findViewById(R.id.createEventButton);

    }
}
