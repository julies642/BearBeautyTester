package com.example.anstonia.tester;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Cleanser extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cleanser);

        ImageButton s1 = (ImageButton) findViewById(R.id.scrub1);
        ImageButton s2 = (ImageButton) findViewById(R.id.scrub2);
        ImageButton s3 = (ImageButton) findViewById(R.id.scrub3);

        s1.setOnClickListener(this);
        s2.setOnClickListener(this);
        s3.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.scrub1:
                Intent intent = new Intent(this, Scrub1.class);
                startActivity(intent);
                break;
            case R.id.scrub2:
                startActivity(new Intent(this, Scrub2.class));
                break;
            case R.id.scrub3:
                startActivity(new Intent(this, Scrub3.class));
                break;
        }
    }
}

