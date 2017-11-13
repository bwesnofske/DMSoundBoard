package com.example.me.dmsoundboard;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mplayer;
    AudioManager audioManager;
    Boolean playing = false;
    SeekBar scrubber;
    int curPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mplayer = MediaPlayer.create(this, R.raw.hell);

        audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);

        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int curVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        int audioLength = mplayer.getDuration();
        curPosition = mplayer.getCurrentPosition();



        SeekBar volumeControl = (SeekBar)findViewById(R.id.seekBar);
        volumeControl.setMax(maxVolume);
        volumeControl.setProgress(curVolume);



        /*
        scrubber = (SeekBar)findViewById(R.id.seekBarScrubber);
        scrubber.setMax(audioLength);


        //create loop to update scrubber position as audiofile changes?
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                scrubber.setProgress(mplayer.getCurrentPosition());
            }
        }, 0, 1000);



        scrubber.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                mplayer.seekTo(progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                mplayer.pause();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mplayer.start();
            }
        });

        */


        volumeControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {

                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



    }

    public void soundPicker(View view) {
        if (view.getId() == R.id.button00) {
            mplayer = MediaPlayer.create(this, R.raw.thunder);
        } else if (view.getId() == R.id.button01) {
            mplayer = MediaPlayer.create(this, R.raw.chains);
        } else if (view.getId() == R.id.button02) {
            mplayer = MediaPlayer.create(this, R.raw.birdscream);
        } else if (view.getId() == R.id.button10) {
            mplayer = MediaPlayer.create(this, R.raw.clock);
        } else if (view.getId() == R.id.button11) {
            mplayer = MediaPlayer.create(this, R.raw.demongirls);
        } else if (view.getId() == R.id.button12) {
            mplayer = MediaPlayer.create(this, R.raw.hell);
        } else if (view.getId() == R.id.button20) {
            mplayer = MediaPlayer.create(this, R.raw.squekdoor);
        } else if (view.getId() == R.id.button21) {
            mplayer = MediaPlayer.create(this, R.raw.water);
        } else if (view.getId() == R.id.button22) {
            mplayer = MediaPlayer.create(this, R.raw.vinesgrowing);
        }
    }

    public void startAudio(View view) {
        mplayer.start();
        //playing = true;
    }

    public void pauseAudio(View view) {
        mplayer.pause();
        //playing = false;
    }


}

