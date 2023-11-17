package com.example.for3an;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class music extends AppCompatActivity {

    private ListView listView;
    private int[] audioResources = { R.raw.sample, R.raw.sample1}; // Add your audio files

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        listView = findViewById(R.id.listView);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.audio_titles,
                android.R.layout.simple_list_item_1
        );

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startPlayerActivity(audioResources[position]);
            }
        });
    }

    private void startPlayerActivity(int audioResource) {
        Intent intent = new Intent(this, PlayerActivity.class);
        intent.putExtra("audioResource", audioResource);
        startActivity(intent);
    }
}