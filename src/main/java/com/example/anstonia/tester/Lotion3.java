package com.example.anstonia.tester;

import co.tanvas.haptics.service.app.*;
import co.tanvas.haptics.service.adapter.*;
import co.tanvas.haptics.service.model.*;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ImageView;

import static com.example.anstonia.tester.R.layout.activity_lotion3;


public class Lotion3 extends AppCompatActivity{

    private HapticView mHapticView;
    private HapticTexture mHapticTexture;
    private HapticMaterial mHapticMaterial;
    private HapticSprite mHapticSprite;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_lotion3);
        initHaptics();
    }

    public void initHaptics() {
        try {

            HapticServiceAdapter serviceAdapter =
                    HapticApplication.getHapticServiceAdapter();

            mHapticView = HapticView.create(serviceAdapter);
            mHapticView.activate();

            Display display = ((WindowManager)
                    getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
            int rotation = display.getRotation();
            HapticView.Orientation orientation =
                    HapticView.getOrientationFromAndroidDisplayRotation(rotation);
            mHapticView.setOrientation(orientation);

            Bitmap hapticBitmap = BitmapFactory.decodeResource(getResources(),
                    R.drawable.lotion3);
            byte[] textureData =
                    HapticTexture.createTextureDataFromBitmap(hapticBitmap);

            mHapticTexture = HapticTexture.create(serviceAdapter);
            int textureDataWidth = hapticBitmap.getRowBytes() / 4;
            int textureDataHeight = hapticBitmap.getHeight();
            mHapticTexture.setSize(textureDataWidth, textureDataHeight);
            mHapticTexture.setData(textureData);

            mHapticMaterial = HapticMaterial.create(serviceAdapter);
            mHapticMaterial.setTexture(0, mHapticTexture);

            mHapticSprite = HapticSprite.create(serviceAdapter);
            mHapticSprite.setMaterial(mHapticMaterial);

            mHapticView.addSprite(mHapticSprite);
        } catch (Exception e) {
            Log.e(null, e.toString());
        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        if (hasFocus) {
            try {

                ImageView view = (ImageView) findViewById(R.id.lotion3);
                int[] location = new int[2];
                view.getLocationOnScreen(location);
                mHapticSprite.setSize(view.getWidth(), view.getHeight());
                mHapticSprite.setPosition(location[0], location[1]);
            } catch (Exception e) {
                Log.e(null, e.toString());
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        try {
            mHapticView.deactivate();
        } catch (Exception e) {
            Log.e(null, e.toString());
        }
    }

}