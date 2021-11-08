package com.alarm.bluealarm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Welcome extends AppCompatActivity implements View.OnClickListener{

    Button logIn, signUp, guest;
    FirebaseAuth auth = FirebaseAuth.getInstance();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        init();
        logIn.setOnClickListener(this);
        signUp.setOnClickListener(this);

    }

    @Override
    protected void onStart() {
        super.onStart();

        //check user login or not
        FirebaseUser user = auth.getCurrentUser();
        if(user != null){
            Intent intent = new Intent(Welcome.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

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
