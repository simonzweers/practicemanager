package com.simon.metronome;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TickingThread tickingThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView metronomeMark = findViewById(R.id.textView);
        SeekBar speedSlider = findViewById(R.id.seekBar);
        speedSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                metronomeMark.setText("Value of slider: " + speedSlider.getProgress());
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
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