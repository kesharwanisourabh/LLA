package com.example.android.lla;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    MediaPlayer mmediaplayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);

        Intent result=getIntent();
        final String lang=result.getStringExtra("lan");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final ArrayList<word> words = new ArrayList<word>();

        if(lang.equals("marathi")){
            words.add(new word("Grand Mother","आजी",R.drawable.family_grandmother,R.raw.aaji_marathi));
            words.add(new word("Grand Father","आजोबा",R.drawable.family_grandfather,R.raw.ajoba_marathi));
            words.add(new word("Mother","आई",R.drawable.family_mother,R.raw.aaii_marathi));
            words.add(new word("Father","वडील",R.drawable.family_father,R.raw.vadil_marathi));
            words.add(new word("Brother","भाऊ",R.drawable.family_older_brother,R.raw.bhau_marathi));
            words.add(new word("Son","मुलगा",R.drawable.family_younger_brother,R.raw.mulga_marathi));
            words.add(new word("Sister","बहीण",R.drawable.family_older_sister,R.raw.bahin_marathi));
            words.add(new word("Daughter","मुलगी",R.drawable.family_younger_sister,R.raw.mulgi_marathi));
        }else {
            words.add(new word("Grand Mother","आजी",R.drawable.family_grandmother,R.raw.aaji_english));
            words.add(new word("Grand Father","आजोबा",R.drawable.family_grandfather,R.raw.ajoba_english));
            words.add(new word("Mother","आई",R.drawable.family_mother,R.raw.aaii_english));
            words.add(new word("Father","वडील",R.drawable.family_father,R.raw.vadil_english));
            words.add(new word("Brother","भाऊ",R.drawable.family_older_brother,R.raw.bhau_english));
            words.add(new word("Son","मुलगा",R.drawable.family_younger_brother,R.raw.mulga_english));
            words.add(new word("Sister","बहीण",R.drawable.family_older_sister,R.raw.bahin_english));
            words.add(new word("Daughter","मुलगी",R.drawable.family_younger_sister,R.raw.mulgi_english));
        }



        WordAdapter wordAdapter =new WordAdapter(this,words,R.color.body_family);


        ListView listView = (ListView) findViewById(R.id.listViewFamily);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                word nword=words.get(position);
                mmediaplayer= MediaPlayer.create(FamilyActivity.this,nword.getmAudioResourceId());
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


