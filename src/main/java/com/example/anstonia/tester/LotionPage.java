package com.example.anstonia.tester;


import android.content.Intent;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;


public class LotionPage extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lotion_page);

        ImageButton l1 = (ImageButton) findViewById(R.id.lotion1);
        ImageButton l2= (ImageButton) findViewById(R.id.lotion2);
        ImageButton l3 = (ImageButton) findViewById(R.id.lotion3);

        l1.setOnClickListener(this);
        l2.setOnClickListener(this);
        l3.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.lotion1:
                Intent intent = new Intent(this, Lotion1.class);
                startActivity(intent);
                break;
            case R.id.lotion2:
                startActivity(new Intent(this, Lotion2.class));
                break;
            case R.id.lotion3:
                startActivity(new Intent(this, Lotion3.class));
                break;
        }
    }
}

