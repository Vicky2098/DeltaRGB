package com.example.android.rgbsetter;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Set;

import static android.R.attr.defaultValue;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class MainActivity extends AppCompatActivity {
    int redValue = 0, blueValue = 0, greenValue = 0;
    String prefer = "Pref_Name";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        SharedPreferences settings = getSharedPreferences(prefer,0);
        int redValue=settings.getInt("redCount",0);
        int greenValue=settings.getInt("greenCount",0);
        int blueValue=settings.getInt("blueCount",0);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayRedValue(redValue);
        displayGreenValue(greenValue);
        displayBlueValue(blueValue);
        View someView = findViewById(R.id.blue_value);
        View root = someView.getRootView();
        root.setBackgroundColor(Color.rgb(redValue,greenValue,blueValue));
    }



    @Override
    protected void onStop() {
        super.onStop();

        SharedPreferences settings = getSharedPreferences(prefer,0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("redCount",redValue);
        editor.putInt("greenCount",greenValue);
        editor.putInt("blueCount",blueValue);
        editor.commit();
    }

    public void incrementRed(View v) {
        if(redValue==255)
            redValue=0;
        else
        redValue = redValue + 17;
        displayRedValue(redValue);
        View someView = findViewById(R.id.red_value);
        View root = someView.getRootView();
        root.setBackgroundColor(Color.rgb(redValue, greenValue, blueValue));

    }
    public void incrementGreen(View v) {
        if(greenValue==255)
           greenValue=0;
        else
            greenValue = greenValue + 17;
        displayGreenValue(greenValue);
        View someView = findViewById(R.id.green_value);
        View root = someView.getRootView();
        root.setBackgroundColor(Color.rgb(redValue,greenValue,blueValue));

    }

    public void incrementBlue(View v) {
        if(blueValue==255)
            blueValue=0;
        else
        blueValue = blueValue + 17;
        displayBlueValue(blueValue);
        View someView = findViewById(R.id.blue_value);
        View root = someView.getRootView();
        root.setBackgroundColor(Color.rgb(redValue,greenValue,blueValue));

    }


    public void displayRedValue(int redCount) {
        TextView redView = (TextView) findViewById(R.id.red_value);
        redView.setText(String.valueOf(redCount));
    }
    public void displayGreenValue(int greenCount) {
        TextView greenView = (TextView) findViewById(R.id.green_value);
        greenView.setText(String.valueOf(greenCount));
    }
    public void displayBlueValue(int blueCount) {
        TextView blueView = (TextView) findViewById(R.id.blue_value);
        blueView.setText(String.valueOf(blueCount));
    }
    public void resetBackground(View  v){
        redValue=0;
        greenValue=0;
        blueValue=0;
        displayRedValue(redValue);
        displayGreenValue(greenValue);
        displayBlueValue(blueValue);
        View someView = findViewById(R.id.blue_value);
        View root = someView.getRootView();
        root.setBackgroundColor(Color.rgb(redValue,greenValue,blueValue));

    }
}