package com.example.dell.bucky;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;

public class GFX extends Activity {
    MyBringBack ourView;
    PowerManager.WakeLock wL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    //wake-lock

        PowerManager pM = (PowerManager)getSystemService(Context.POWER_SERVICE);
        wL = pM.newWakeLock(PowerManager.FULL_WAKE_LOCK,"whatever");

        super.onCreate(savedInstanceState);
        wL.acquire();
        ourView = new MyBringBack(this);
        setContentView(ourView);
    }

    @Override
    protected void onPause() {
        super.onPause();
        wL.release();
    }
}
