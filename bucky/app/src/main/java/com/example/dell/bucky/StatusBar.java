package com.example.dell.bucky;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StatusBar extends Activity implements View.OnClickListener {
    NotificationManager nm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statusbar);
        Button stat = (Button)findViewById(R.id.bStatusBar);
        stat.setOnClickListener(this);
        nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this,StatusBar.class);
        PendingIntent pi = PendingIntent.getActivity(this,0, intent,0);
        String body = "This is a message from Shakti, thanks for your support ";
        String title = "Shakti.C";
        Notification n = new Notification(R.drawable.rode,body,System.currentTimeMillis());
    }
}
