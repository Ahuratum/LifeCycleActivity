package com.example.lifecycle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button increment, decrement, reset;
    TextView display;

    int clicks = 0;

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("clickValue", clicks);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        clicks = savedInstanceState.getInt("clickValue");
        display = findViewById(R.id.display);
        display.setText(Integer.toString(clicks));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Lifecyclefilter", "App is started");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Lifecyclefilter", "App is stopped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Lifecyclefilter", "App is destroyed");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Lifecyclefilter", "App is restarted");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Lifecyclefilter", "App is paused");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Lifecyclefilter", "App is resumed");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        increment = findViewById(R.id.increment);
        display = findViewById(R.id.display);
        decrement = findViewById(R.id.decrement);
        reset = findViewById(R.id.reset);


        display.setText("0");

        increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicks++;
                display.setText(Integer.toString(clicks));
            }
        });

        decrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicks--;
                display.setText(Integer.toString(clicks));
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicks = 0;
                display.setText("0");
            }
        });



    }
}