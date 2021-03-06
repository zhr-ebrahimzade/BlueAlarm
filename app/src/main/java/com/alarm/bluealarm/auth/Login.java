package com.alarm.bluealarm.auth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alarm.bluealarm.MainActivity;
import com.alarm.bluealarm.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    private EditText email, password;
    private Button login, forgotPass, signUp;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userEmail = email.getText().toString();
                String userPass = password.getText().toString();
                boolean check = checkInputBox(userEmail, userPass);
                if(check) {
                    userSignin(userEmail, userPass);
                }
            }
        });


        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, SignUp.class);
                startActivity(intent);
                finish();
            }
        });



        forgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Confirmation.class);
                startActivity(intent);
//                finish();
            }
        });
    }

    /**
     * initialize activity !
     */
    private void init(){
        email = findViewById(R.id.emailAddress);
        password = findViewById(R.id.password);
        login = findViewById(R.id.loginbutton2);
        forgotPass = findViewById(R.id.forgotpassbutton);
        signUp = findViewById(R.id.signupbutton2);
        firebaseAuth = FirebaseAuth.getInstance();
    }

    /**
     * Sign in with firebaseAuth
     * @param email user email
     * @param password user password
     */
    public void userSignin(String email, String password){
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        // if login is successful then open the main page !
                        Intent intent = new Intent(Login.this, MainActivity.class);
                        Toast.makeText(Login.this, "Login is Successful !" , Toast.LENGTH_LONG).show();
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(Login.this, " Invalid Email or Password !" , Toast.LENGTH_LONG).show();

                    }
            }
        });
    }

    /**
     * some condition that checks input box content
     * @param userEmail
     * @param userPass
     */
    public boolean checkInputBox(String userEmail, String userPass){
        if(userEmail.isEmpty()){
            email.setError("Email is should be entered!");
            email.requestFocus();
            return false;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()){
            email.setError("Please provide valid email!");
            email.requestFocus();
            return false;
        }
        if(userPass.isEmpty()){
            password.setError("Password is should be entered!");
            password.requestFocus();
            return false;
        }
        if(userPass.length() < 6){
            password.setError("Min password length should be 6 character !");
            password.requestFocus();
            return false;
        }
        return true;
    }

    public void onBackPressed() {
        Intent intent = new Intent (Login.this , Welcome.class);
        startActivity(intent);
        finish();
    }


}