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

public class PhrasesActivity extends AppCompatActivity {

    MediaPlayer mmediaplayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent result=getIntent();
        final String lang=result.getStringExtra("lan");

        final ArrayList<word> words = new ArrayList<word>();

        if(lang.equals("marathi")) {

            words.add(new word("Monday","सोमवार",R.drawable.ic_today_black_24dp,R.raw.monday_marathi));
            words.add(new word("Tuesday","मंगळवार",R.drawable.ic_today_black_24dp,R.raw.tuesday_marathi));
            words.add(new word("Wednesday","बुधवार",R.drawable.ic_today_black_24dp,R.raw.wednesday_marathi));
            words.add(new word("Thursday","गुरुवार",R.drawable.ic_today_black_24dp,R.raw.thursday_marathi));
            words.add(new word("Friday","शुक्रवार",R.drawable.ic_today_black_24dp,R.raw.friday_marathi));
            words.add(new word("Saturday","शनिवार",R.drawable.ic_today_black_24dp,R.raw.saturday_marathi));
            words.add(new word("Sunday","रविवारी",R.drawable.ic_today_black_24dp,R.raw.sunday_marathi));

        }else {

            words.add(new word("Monday","सोमवार",R.drawable.ic_today_black_24dp,R.raw.monday_english));
            words.add(new word("Tuesday","मंगळवार",R.drawable.ic_today_black_24dp,R.raw.tuesday_english));
            words.add(new word("Wednesday","बुधवार",R.drawable.ic_today_black_24dp,R.raw.wednesday_english));
            words.add(new word("Thursday","गुरुवार",R.drawable.ic_today_black_24dp,R.raw.thursday_english));
            words.add(new word("Friday","शुक्रवार",R.drawable.ic_today_black_24dp,R.raw.friday_english));
            words.add(new word("Saturday","शनिवार",R.drawable.ic_today_black_24dp,R.raw.saturday_english));
            words.add(new word("Sunday","रविवारी",R.drawable.ic_today_black_24dp,R.raw.sunday_english));

        }


        WordAdapter wordAdapter =new WordAdapter(this,words,R.color.body_phrases    );


        ListView listView = (ListView) findViewById(R.id.listViewPhrases);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                word nword=words.get(position);
                mmediaplayer= MediaPlayer.create(PhrasesActivity.this,nword.getmAudioResourceId());
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
        listView.setAdapter(wordAdapter);
    }
}
