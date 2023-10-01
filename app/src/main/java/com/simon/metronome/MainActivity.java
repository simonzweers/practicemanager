package com.simon.metronome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public static String MAIN_ACTIVITY = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button addButton = findViewById(R.id.button_add);
        Button removeButton = findViewById(R.id.button_remove);
        addButton.setOnClickListener(view -> {
            Log.i(MAIN_ACTIVITY, "Add Button Pressed");
        });
        removeButton.setOnClickListener(view -> {
            Log.i(MAIN_ACTIVITY, "Remove button pressed");
        });
        Intent switchActivityIntent = new Intent(this, RoutineListActivity.class);
        startActivity(switchActivityIntent);
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