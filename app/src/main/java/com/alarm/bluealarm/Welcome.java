package com.alarm.bluealarm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Welcome extends AppCompatActivity implements View.OnClickListener{

    Button logIn, signUp, guest;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        init();
        logIn.setOnClickListener(this);
        signUp.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
       Intent intent;

       switch (v.getId()){
           case (R.id.loginbutton1):
               intent = new Intent(Welcome.this, Login.class);
               break;
           case (R.id.signupbutton1):
               intent = new Intent(Welcome.this, SignUp.class);
               break;
           default:
               throw new IllegalStateException("Unexpected value: " + v.getId());
       }
       startActivity(intent);
       finish();
    }

    private void init(){
        logIn=findViewById(R.id.loginbutton1);
        signUp=findViewById(R.id.signupbutton1);
       /* guest=findViewById(R.id.loginasguest);*/
    }
}
