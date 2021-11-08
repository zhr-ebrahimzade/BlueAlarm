package com.alarm.bluealarm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
                userSignin(userEmail, userPass);
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
                finish();
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
                        Toast.makeText(Login.this, "Login is Sucessful !" , Toast.LENGTH_LONG).show();
                        startActivity(intent);
                    }
                    else
                        {

                    }
            }
        });
    }
}