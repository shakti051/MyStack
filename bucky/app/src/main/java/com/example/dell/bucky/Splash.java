package com.example.dell.bucky;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class Splash extends Activity {
    MediaPlayer ourSong;
    @Override
    protected void onCreate(Bundle TravisLoveBacon) {
        super.onCreate(TravisLoveBacon);
        setContentView(R.layout.splash);
    //    MediaPlayer ourSong = MediaPlayer.create(this,R.raw.airhorn);
    //    ourSong.start();
        Thread timer = new Thread(){
            public void run(){
                try {
                    sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    Intent openStartingPoint = new Intent("com.example.dell.bucky.MENU");
                    startActivity(openStartingPoint);
                }
            }
        };
        timer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
    //    ourSong.release();
        finish();
    }
}
