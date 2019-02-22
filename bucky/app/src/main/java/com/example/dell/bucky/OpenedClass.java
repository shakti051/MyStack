package com.example.dell.bucky;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class OpenedClass extends Activity implements View.OnClickListener ,RadioGroup.OnCheckedChangeListener {

    TextView question,test;
    Button returnData;
    RadioGroup selectionList;
    String gotBread,setData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send);
        initialize();
        //    Bundle gotBasket = getIntent().getExtras() ;
        //    gotBread = gotBasket.getString("key");
        //    question.setText(gotBread);
    }

    public void initialize(){
        question = (TextView)findViewById(R.id.tvQuestion);
        test = (TextView)findViewById(R.id.tvText);
        returnData = (Button)findViewById(R.id.bReturn);
        returnData.setOnClickListener(this);
        selectionList = (RadioGroup)findViewById(R.id.rgAnswers);
        selectionList.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent person = new Intent();
        Bundle backpack = new Bundle();
        backpack.putString("answer",setData);
        person.putExtras(backpack);
        setResult(RESULT_OK,person);
        finish();
    }

    @Override
    public void onCheckedChanged(RadioGroup arg0, int arg1) {
        switch (arg1){
            case R.id.rCrazy:
                setData = "Probabley right";
                break;
            case R.id.rSexy:
                setData = "Definatey right";
                break;
            case R.id.rBoth:
                setData = "Spot on!!!";
                break;
        }
        test.setText(setData);
    }
}
