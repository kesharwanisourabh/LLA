package com.example.android.lla;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class contentActivity extends AppCompatActivity {
    TextView colors;
    TextView numbers;
    TextView family;
    TextView weekday;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_activity);

        Intent result=getIntent();
        final String lang=result.getStringExtra("lan");


        colors =(TextView)findViewById(R.id.colors);
        colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent colorPage = new Intent(contentActivity.this,ColorsActivity.class);
                if(lang.equals("marathi")){
                    colorPage.putExtra("lan","marathi");
                }else {
                    colorPage.putExtra("lan","english");
                }

                startActivity(colorPage);
            }
        });

        numbers =(TextView)findViewById(R.id.numbers);
        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent numberPage = new Intent(contentActivity.this,NumbersActivity.class);
                if(lang.equals("marathi")){
                    numberPage.putExtra("lan","marathi");
                }else {
                    numberPage.putExtra("lan","english");
                }
                startActivity(numberPage);
            }
        });

        family =(TextView)findViewById(R.id.family);
        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fPage = new Intent(contentActivity.this,FamilyActivity.class);
                if(lang.equals("marathi")){
                    fPage.putExtra("lan","marathi");
                }else {
                    fPage.putExtra("lan","english");
                }
                startActivity(fPage);
            }
        });

        weekday =(TextView)findViewById(R.id.phrases);
        weekday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fPage = new Intent(contentActivity.this,PhrasesActivity.class);
                if(lang.equals("marathi")){
                    fPage.putExtra("lan","marathi");
                }else {
                    fPage.putExtra("lan","english");
                }
                startActivity(fPage);
            }
        });

        if(lang.equals("marathi")){
            numbers.setText("Numbers  -->  संख्या");
            colors.setText("Colours  -->  रंग");
            family.setText("Family  -->  कुटुंब");
            weekday.setText("Weekday  -->  आठवडा");
        }

        if(lang.equals("english")){
            numbers.setText("संख्या  -->  Numbers");
            colors.setText("रंग  -->  Colours");
            family.setText("कुटुंब  -->  Family");
            weekday.setText("आठवडा  -->  Weekday");
        }
    }

}