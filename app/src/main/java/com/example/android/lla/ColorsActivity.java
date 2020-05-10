package com.example.android.lla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
    MediaPlayer mmediaplayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent result=getIntent();
        final String lang=result.getStringExtra("lan");

        final ArrayList<word> words = new ArrayList<word>();

        if(lang.equals("marathi")) {
            words.add(new word("Red", "लाल", R.drawable.color_red, R.raw.red_marathi));
            words.add(new word("Green", "हिरवा", R.drawable.color_green, R.raw.green_marathi));
            words.add(new word("Black", "काळा", R.drawable.color_black, R.raw.black_marathi));
            words.add(new word("Brown", "तपकिरी", R.drawable.color_brown, R.raw.brown_marathi));
            words.add(new word("Gray", "राखाडी", R.drawable.color_gray, R.raw.grey_marathi));
            words.add(new word("White", "पांढरा", R.drawable.color_white, R.raw.white_marathi));
            words.add(new word("Yellow", "पिवळे", R.drawable.color_mustard_yellow, R.raw.yellow_marathi));
        }else {
            words.add(new word("Red", "लाल", R.drawable.color_red, R.raw.red_english));
            words.add(new word("Green", "हिरवा", R.drawable.color_green, R.raw.green_english));
            words.add(new word("Black", "काळा", R.drawable.color_black, R.raw.black_english));
            words.add(new word("Brown", "तपकिरी", R.drawable.color_brown, R.raw.brown_english));
            words.add(new word("Gray", "राखाडी", R.drawable.color_gray, R.raw.grey_engliah));
            words.add(new word("White", "पांढरा", R.drawable.color_white, R.raw.white_english));
            words.add(new word("Yellow", "पिवळे", R.drawable.color_mustard_yellow, R.raw.yellow_english));
        }

        WordAdapter wordAdapter = new WordAdapter(this, words, R.color.body_colors);

        ListView listView = (ListView) findViewById(R.id.listViewColors);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                word nword = words.get(position);

                mmediaplayer = MediaPlayer.create(ColorsActivity.this, nword.getmAudioResourceId());
                mmediaplayer.start();

                mmediaplayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mmediaplayer.stop();
                        mmediaplayer.release();
                        mmediaplayer = null;

                    }
                });

            }
        });

        listView.setAdapter(wordAdapter);

    }

}
