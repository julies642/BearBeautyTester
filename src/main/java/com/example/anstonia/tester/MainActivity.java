package com.example.anstonia.tester;

import android.content.Intent;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton lotionButton = (ImageButton) findViewById(R.id.lotionban);
        ImageButton scrubButton = (ImageButton) findViewById(R.id.cleanser);
        ImageButton makeupbutton = (ImageButton) findViewById(R.id.makeup);

        lotionButton.setOnClickListener(this);
        scrubButton.setOnClickListener(this);
        makeupbutton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.lotionban:
                Intent intent = new Intent(this, LotionPage.class);
                startActivity(intent);
                break;
            case R.id.cleanser:
                startActivity(new Intent(this, Cleanser.class));
                break;
            case R.id.makeup:
                startActivity(new Intent(this, Makeup.class));
                break;
        }
    }
}

