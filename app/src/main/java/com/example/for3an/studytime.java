package com.example.for3an;

import static com.example.for3an.R.id.chronometer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

import androidx.appcompat.app.AppCompatActivity;

public class studytime extends AppCompatActivity {






        private Chronometer chronometer;
        private Button startButton, pauseButton, resetButton;

        private boolean isRunning = false;
        private long pauseOffset;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_studytime);

            chronometer = findViewById(R.id.chronometer);
            startButton = findViewById(R.id.startButton);
            pauseButton = findViewById(R.id.pauseButton);
            resetButton = findViewById(R.id.resetButton);

            startButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startChronometer();
                }
            });

            pauseButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    pauseChronometer();
                }
            });

            resetButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    resetChronometer();
                }
            });
        }

        private void startChronometer() {
            if (!isRunning) {
                chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
                chronometer.start();
                isRunning = true;
            }
        }

        private void pauseChronometer() {
            if (isRunning) {
                chronometer.stop();
                pauseOffset = SystemClock.elapsedRealtime() - chronometer.getBase();
                isRunning = false;
            }
        }

        private void resetChronometer() {
            chronometer.setBase(SystemClock.elapsedRealtime());
            pauseOffset = 0;
            if (isRunning) {
                chronometer.stop();
                isRunning = false;
            }
        }
    }
