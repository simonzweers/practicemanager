package com.simon.metronome;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public static String BUTTON_PRESS_TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button addButton = (Button) findViewById(R.id.button_add);
        Button removeButton = (Button) findViewById(R.id.button_remove);
        addButton.setOnClickListener(view -> {
            Log.i(BUTTON_PRESS_TAG, "Add Button Pressed");
        });
        removeButton.setOnClickListener(view -> {
            Log.i(BUTTON_PRESS_TAG, "Remove button pressed");
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }
}