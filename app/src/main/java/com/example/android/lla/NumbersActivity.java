package com.example.android.lla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    MediaPlayer mmediaplayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Intent result=getIntent();
        final String lang=result.getStringExtra("lan");

        final ArrayList<word> words = new ArrayList<word>();

        if(lang.equals("marathi")) {
            words.add(new word("One", "एक", R.drawable.number_one, R.raw.one_marathi));
            words.add(new word("Two", "दोन", R.drawable.number_two, R.raw.two_marathi));
            words.add(new word("Three", "तीन", R.drawable.number_three, R.raw.three_marathi));
            words.add(new word("Four", "चार", R.drawable.number_four, R.raw.four_marathi));
            words.add(new word("Five", "पाच", R.drawable.number_five, R.raw.five_marathi));
            words.add(new word("Six", "सहा", R.drawable.number_six, R.raw.six_marathi));
            words.add(new word("Seven", "सात", R.drawable.number_seven, R.raw.seven_marathi));
            words.add(new word("Eight", "आठ", R.drawable.number_eight, R.raw.eight_marathi));
            words.add(new word("Nine", "नऊ", R.drawable.number_nine, R.raw.nine_marathi));
        }else{
            words.add(new word("One", "एक", R.drawable.number_one, R.raw.one_english));
            words.add(new word("Two", "दोन", R.drawable.number_two, R.raw.two_english));
            words.add(new word("Three", "तीन", R.drawable.number_three, R.raw.three_english));
            words.add(new word("Four", "चार", R.drawable.number_four, R.raw.four_english));
            words.add(new word("Five", "पाच", R.drawable.number_five, R.raw.five_english));
            words.add(new word("Six", "सहा", R.drawable.number_six, R.raw.six_english));
            words.add(new word("Seven", "सात", R.drawable.number_seven, R.raw.seven_english));
            words.add(new word("Eight", "आठ", R.drawable.number_eight, R.raw.eight_english));
            words.add(new word("Nine", "नऊ", R.drawable.number_nine, R.raw.nine_english));
        }
        WordAdapter wordAdapter =new WordAdapter(this,words,R.color.body_number);


        ListView listView = (ListView) findViewById(R.id.listViewNumbers);
        listView.setAdapter(wordAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                word nword=words.get(position);
                mmediaplayer= MediaPlayer.create(NumbersActivity.this,nword.getmAudioResourceId());
                mmediaplayer.start();

                mmediaplayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mmediaplayer.stop();
                        mmediaplayer.release();
                        mmediaplayer=null;
                    }
                });

            }
        });
    }
}
