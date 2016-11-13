package com.example.anstonia.tester;

import android.content.Intent;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;


public class Makeup extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makeup);

        ImageButton m1 = (ImageButton) findViewById(R.id.makeup1);
        ImageButton m2= (ImageButton) findViewById(R.id.makeup2);
        ImageButton m3 = (ImageButton) findViewById(R.id.makeup3);

        m1.setOnClickListener(this);
        m2.setOnClickListener(this);
        m3.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.makeup1:
                Intent intent = new Intent(this, Makeup1.class);
                startActivity(intent);
                break;
            case R.id.makeup2:
                startActivity(new Intent(this, Makeup2.class));
                break;
            case R.id.makeup3:
                startActivity(new Intent(this, Makeup3.class));
                break;
        }
    }
}

