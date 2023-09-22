package com.example.for3an;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    CardView studyTimeCard;
    CardView todolistCard;

    CardView pastpaperCard;
    CardView progressCard;
    CardView chatCard;
    CardView musicCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        studyTimeCard = findViewById(R.id.studytimecard);
        studyTimeCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this, studytime.class);
                startActivity(intent1);

            }
        });


        todolistCard = findViewById(R.id.todolistcard);
        todolistCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this, todolist.class);
                startActivity(intent1);

            }
        });

        pastpaperCard= findViewById(R.id.paperscard);
        pastpaperCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this, pastpaper.class);
                startActivity(intent1);

            }
        });
        progressCard= findViewById(R.id.progresscard);
        progressCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this, progress.class);
                startActivity(intent1);


            }

        });
        chatCard= findViewById(R.id.chatcard);
        chatCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this, chat.class);
                startActivity(intent1);


            }

        });
        musicCard= findViewById(R.id.musicCard);
       musicCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this, music.class);
                startActivity(intent1);


            }

        });


    }
}

