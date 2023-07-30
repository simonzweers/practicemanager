package com.simon.metronome;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    MetronomeContext metronome;
    Button startStopButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView metronomeMark = findViewById(R.id.textView);
        SeekBar speedSlider = findViewById(R.id.seekBar);
        metronome = new MetronomeContext(getApplicationContext());
        metronome.startMetronome();
        startStopButton = findViewById(R.id.start_stop_button);
        speedSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int value = speedSlider.getProgress();
                metronomeMark.setText("Value of slider: " + value);
                metronome.setBpm(value);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
        startStopButton.setOnClickListener(view -> {
            if (metronome.getMetronomeOn()) {
                metronome.stopMetronome();
            } else {
                metronome.startMetronome();
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        metronome.stopMetronome();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        metronome.startMetronome();
    }
}