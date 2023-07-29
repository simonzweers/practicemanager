package com.simon.metronome;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TickingThread tickingThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tickingThread = new TickingThread(getApplicationContext());
        Thread thread = new Thread(tickingThread);
        thread.start();
        TextView metronomeMark = findViewById(R.id.textView);
        metronomeMark.setText("Text View");
    }

    @Override
    protected void onStop() {
        super.onStop();
        tickingThread.playSound(false);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        tickingThread.playSound(true);
    }
}