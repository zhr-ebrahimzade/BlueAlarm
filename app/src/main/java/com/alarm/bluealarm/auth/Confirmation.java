package com.alarm.bluealarm.auth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alarm.bluealarm.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class Confirmation extends AppCompatActivity {
    private static final String TAG="Confirmation";

    Button resetPassBtn;
    EditText editTextEmail;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);
        init();


        resetPassBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userEmail = editTextEmail.getText().toString().trim();
                auth.sendPasswordResetEmail(userEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Confirmation.this, "Check your Email reset your password", Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(Confirmation.this, "Some problem occurred ", Toast.LENGTH_LONG).show();
                        }
                    }
                });
//                finish();
            }
        });


    }

    private void init(){
        resetPassBtn = findViewById(R.id.reset_btn);
        editTextEmail = findViewById(R.id.email);
        auth = FirebaseAuth.getInstance();
    }
    public void onBackPressed() {
        Intent intent = new Intent (Confirmation.this , Login.class);
        startActivity(intent);
        finish();
    }



}