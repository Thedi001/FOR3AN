package com.example.for3an;

// MainActivity.java

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class physics extends AppCompatActivity {

    private EditText editTextMarks, editTextDate;
    private Button btnAdd;
    private LineChart lineChart;

    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physics);

        editTextMarks = findViewById(R.id.editTextMarks);
        editTextDate = findViewById(R.id.editTextDate);
        btnAdd = findViewById(R.id.btnAddP6);
        lineChart = findViewById(R.id.lineChart);

        // Initialize Firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("user_progress");

        // Set up click listener for the "Add Entry" button
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addEntry();
            }
        });

        // Retrieve and update chart data
        retrieveDataAndUpdateChart();
    }

    private void addEntry() {
        String marks = editTextMarks.getText().toString();
        String date = editTextDate.getText().toString();

        // Check if both fields are not empty
        if (!marks.isEmpty() && !date.isEmpty()) {
            // Create a new entry
            ProgressEntry entry = new ProgressEntry(marks, date);

            // Save the entry to Firebase
            databaseReference.push().setValue(entry);

            // Clear input fields
            editTextMarks.getText().clear();
            editTextDate.getText().clear();
        }
    }

    private void retrieveDataAndUpdateChart() {
        // Attach a listener to read the data
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // Iterate through the data and collect entries
                List<ProgressEntry> entries = new ArrayList<>();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    ProgressEntry entry = snapshot.getValue(ProgressEntry.class);
                    entries.add(entry);
                }

                // Use entries to update the chart
                updateChart(entries);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle errors
            }
        });
    }

    private void updateChart(List<ProgressEntry> entries) {
        // Convert entries to chart data
        List<Entry> chartEntries = new ArrayList<>();
        for (int i = 0; i < entries.size(); i++) {
            chartEntries.add(new Entry(i, Float.parseFloat(entries.get(i).getMarks())));
        }

        // Create a data set and update the chart
        LineDataSet dataSet = new LineDataSet(chartEntries, "Marks Progress");
        LineData lineData = new LineData(dataSet);
        lineChart.setData(lineData);
        lineChart.invalidate(); // Refresh the chart
    }
}
