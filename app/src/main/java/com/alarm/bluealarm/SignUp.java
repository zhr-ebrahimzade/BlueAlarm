package com.alarm.bluealarm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG="SignUp";
    EditText name, user,email, pass, confirm;

    Button sign_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        init();

        sign_btn.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {

       /* if (check()){*/
            Intent intent = new Intent(SignUp.this, Confirmation.class);
            startActivity(intent);
        /*}*/
    }


    private void init(){
        name=findViewById(R.id.fullName);
        user=findViewById(R.id.emailAddress);
        email=findViewById(R.id.email);
        pass=findViewById(R.id.password);
        confirm=findViewById(R.id.confirmPass);
        sign_btn=findViewById(R.id.signUp_btn);
    }

    /*checks every view to not be empty*/
    private boolean check(){
        boolean isOk=true;
        if (name.getText().toString().trim().isEmpty()
                || user.getText().toString().trim().isEmpty()
                || email.getText().toString().trim().isEmpty()
                || pass.getText().toString().trim().isEmpty()
                || confirm.getText().toString().trim().isEmpty()) {

            Toast.makeText(this,"Please fill all the boxes",Toast.LENGTH_SHORT).show();
                isOk=false;
        }
        else {//returns the number of characters
            if (name.getText().toString().trim().length()<2) {
                Toast.makeText(this, "Not enough char", Toast.LENGTH_SHORT).show();
                isOk=false;
            }
            if (user.getText().toString().trim().length()<2) {
                Toast.makeText(this, "Not enough char", Toast.LENGTH_SHORT).show();
                isOk=false;
            }
            if (email.getText().toString().trim().length()<12){
                Toast.makeText(this,"",Toast.LENGTH_SHORT).show();
                isOk=false;
            }
            else {
                if (!email.getText().toString().contains("@")) {
                    Toast.makeText(this, "Invalid email", Toast.LENGTH_SHORT).show();
                    isOk=false;
                }
            }
            if (pass.getText().toString().trim().length()<8) {
                Toast.makeText(this, "Not enough char", Toast.LENGTH_SHORT).show();
                isOk=false;
            }
            if (confirm.getText().toString().equals(pass.getText().toString())){
                Toast.makeText(this,"Not matched",Toast.LENGTH_SHORT).show();
                isOk=false;
            }

        }
        return isOk;
    }



}