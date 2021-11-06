package com.alarm.bluealarm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Confirmation extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG="MainActivity";

    ImageView imageView;
    TextView txt1, txt2;
    EditText edit1,edit2,edit3,edit4;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);
        init();
        button.setOnClickListener(this);

    }
    private void init(){

        imageView.findViewById(R.id.emailImage);
        txt1.findViewById(R.id.txt_checck);
        txt2.findViewById(R.id.txt_enter);
        edit1.findViewById(R.id.txt1_code);
        edit2.findViewById(R.id.txt2_code);
        edit3.findViewById(R.id.txt3_code);
        edit4.findViewById(R.id.txt4_code);
        button.findViewById(R.id.login_btn);
    }

    @Override
    public void onClick(View v) {

    }

    /*checks the condition for every view*/
}