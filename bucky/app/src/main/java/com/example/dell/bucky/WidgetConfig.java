package com.example.dell.bucky;

import android.app.Activity;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RemoteViews;

public class WidgetConfig extends Activity implements View.OnClickListener {
    EditText info;
    AppWidgetManager awm;
    Context c;
    int awID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.widgetconfig);
        Button b = (Button)findViewById(R.id.bwidgetconfig);
        b.setOnClickListener(this);
        c = WidgetConfig.this;
        info = (EditText)findViewById(R.id.etwidgetconfig);

        //Getting info about the widget
        Intent i = getIntent();
        Bundle extras = i.getExtras();
        if (extras!= null){
            awID = extras.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID,AppWidgetManager.INVALID_APPWIDGET_ID);
        }
        awm = AppWidgetManager.getInstance(c);
    }

    @Override
    public void onClick(View v) {
        String e = info.getText().toString();
        RemoteViews views = new RemoteViews(c.getPackageName(),R.layout.widget);
        views.setTextViewText(R.id.tvConfigInput,e);
        Intent in = new Intent(c,Splash.class);
        PendingIntent pi = PendingIntent.getActivities(c,0, new Intent[]{in},0);
        views.setOnClickPendingIntent(R.id.bwidgetOpen,pi);
        awm.updateAppWidget(awID,views);
        Intent result = new Intent();
        result.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,awID);
        setResult(RESULT_OK,result);
        finish();
    }
}
