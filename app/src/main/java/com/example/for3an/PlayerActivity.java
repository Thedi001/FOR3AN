package com.example.for3an;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.Locale;

public class PlayerActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private Button playPauseButton;
    private Handler handler = new Handler();
    SeekBar seekbar;
    private TextView textCurrentTime,textTotalTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        int audioResource = getIntent().getIntExtra("audioResource", -1);

        mediaPlayer = MediaPlayer.create(this, audioResource);

        playPauseButton = findViewById(R.id.playPauseButton);

        seekbar = findViewById(R.id.seekBar);

        textCurrentTime = findViewById(R.id.txtSongStart);
        textTotalTime = findViewById(R.id.txtSongEnd);
        playPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    playPauseButton.setBackgroundResource(R.drawable.baseline_play_arrow_m);
                } else {
                    mediaPlayer.start();
                    playPauseButton.setBackgroundResource(R.drawable.baseline_pause_mu);
                }
            }
        });

        try {
            mediaPlayer.setDataSource("audioResource");
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }


        // Set the maximum value of the seek bar to the duration of the audio
        seekbar.setMax(mediaPlayer.getDuration());

        // Update seek bar progress as the audio plays
        updateSeekBar();

        // Seek bar change listener to seek to a specific position in the audio
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mediaPlayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Do nothing
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Do nothing
            }
        });
    }

    private void updateSeekBar() {
        // Update seek bar progress and time display every 100 milliseconds
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int currentProgress = mediaPlayer.getCurrentPosition();
                seekbar.setProgress(currentProgress);
                textCurrentTime.setText(formatTime(currentProgress));
                textTotalTime.setText(formatTime(mediaPlayer.getDuration()));
                handler.postDelayed(this, 100);
            }
        };
        handler.postDelayed(runnable, 100);
    }

    private String formatTime(int milliseconds) {
        int seconds = (milliseconds / 1000) % 60;
        int minutes = (milliseconds / 1000) / 60;
        return String.format(Locale.getDefault(), "%d:%02d", minutes, seconds);
    }






    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
            handler.removeCallbacksAndMessages(null);
        }
    }
}