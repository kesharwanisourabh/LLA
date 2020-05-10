package com.example.android.lla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button MButton;
    Button EButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MButton =(Button)findViewById(R.id.marathi);
        EButton =(Button)findViewById(R.id.english);

        MButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent contentPage = new Intent(MainActivity.this,contentActivity.class);
                contentPage.putExtra("lan","marathi");
                startActivity(contentPage);
            }
        });

        EButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent contentPage = new Intent(MainActivity.this,contentActivity.class);
                contentPage.putExtra("lan","english");
                startActivity(contentPage);
            }
        });

    }
}
