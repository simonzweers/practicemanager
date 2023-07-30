package com.simon.metronome;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;

public class MetronomeContext {
    private Context context;
    private int bpm = 60;
    private MediaPlayer mediaPlayer;
    private Handler handler = new Handler();
    private boolean playNext = true;

    private Runnable playTickSound = new Runnable() {
        @Override
        public void run() {
            mediaPlayer.seekTo(0);
            mediaPlayer.start();
            if (playNext) {
                handler.postDelayed(this, getIntervalMillis(bpm));
            }
        }
    };

    public MetronomeContext(Context appContext) {
        this.context = appContext;
        mediaPlayer = MediaPlayer.create(appContext, R.raw.metronome);
    }

    public void startMetronome() {
        if (!playNext) playNext = true;
        handler.postDelayed(playTickSound, getIntervalMillis(bpm));
    }

    public void stopMetronome() {
        playNext = false;
    }

    public void setBpm(int bpm) {
        this.bpm = bpm;
    }

    public boolean getMetronomeOn() {
        return this.playNext;
    }

    private int getIntervalMillis(int bpm) {
        return Math.round(60000f / bpm);
    }
}
