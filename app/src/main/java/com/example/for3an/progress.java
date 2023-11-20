package com.example.for3an;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class progress extends AppCompatActivity {
    CardView physicscard;
    CardView chemistrycard;

    CardView biocard;
    CardView ITCard;
    CardView purecard;
    CardView appliedcard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);


        physicscard = findViewById(R.id.physicscard);
        physicscard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(progress.this, physics.class);
                startActivity(intent1);

            }
        });


        chemistrycard = findViewById(R.id.chemistrycard);
        chemistrycard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(progress.this, chemistry.class);
                startActivity(intent1);

            }
        });

        appliedcard= findViewById(R.id.appliedcard);
        appliedcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(progress.this, applied.class);
                startActivity(intent1);

            }
        });
        purecard= findViewById(R.id.purecard);
        purecard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(progress.this, pure.class);
                startActivity(intent1);

            }

        });
        biocard= findViewById(R.id.biocard);
        biocard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(progress.this, bio.class);
                startActivity(intent1);


            }

        });
        ITCard= findViewById(R.id.ITCard);
        ITCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(progress.this, IT.class);
                startActivity(intent1);


            }

        });


    }
}

