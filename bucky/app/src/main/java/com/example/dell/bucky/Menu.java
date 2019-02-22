package com.example.dell.bucky;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity {
    String classes[] ={"MainActivity","TextPlay","Email","Camera",
                         "Data","GFX","GFXSurface","SoundStuff","Slider","Tabs","SimpleBrowser"
                         ,"Flipper","SharedPrefs","InternalData","SQLiteExample","Accelerate","Maps"
                           ,"GLExample","GLCubeEx","Voice","TextVoice","SeekBarVolume"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
            //fullScreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setListAdapter(new ArrayAdapter<String>(Menu.this,android.R.layout.simple_list_item_1,classes));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Class ourClass = null;
        String cheese = classes[position];
        try {
            ourClass = Class.forName("com.example.dell.bucky."+cheese);
            Intent ourIntent = new Intent(Menu.this,ourClass);
            startActivity(ourIntent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
