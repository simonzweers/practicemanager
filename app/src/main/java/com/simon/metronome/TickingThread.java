package com.simon.metronome;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;

public class TickingThread implements Runnable {
    private static String TAG = "TickingThread";
    Context appContext;
    MediaPlayer mediaPlayer;

    public TickingThread(Context context) {
        this.appContext = context;
        this.mediaPlayer = MediaPlayer.create(appContext, R.raw.metronome);
    }

    @Override
    public void run() {
        int counter = 0;
        while (true) {
            Log.i(TAG, String.valueOf(counter));
            counter++;
            Thread playSoundThread = new Thread(mediaPlayer::start);
            playSoundThread.start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
