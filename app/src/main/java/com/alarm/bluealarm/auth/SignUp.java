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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG="SignUp";
    EditText editTextName, editTextUser,editTextEmail, editTextPass, editTextConfirm;
    Button sign_btn;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        init();

        sign_btn.setOnClickListener(this);

    }





    @Override
    public void onClick(View v) {
        String userName = editTextName.getText().toString().trim();
        String userPass = editTextPass.getText().toString().trim();
        String userConfirm = editTextConfirm.getText().toString().trim();
        String userEmail = editTextEmail.getText().toString().trim();

        boolean checked = check(userName, userEmail, userPass, userConfirm);
        if (checked){
            signUp(userName, userEmail, userPass);
        }
    }


    /**
     * Get ui component & valuation !!
     */
    private void init(){
        editTextName = findViewById(R.id.fullName);
        editTextUser = findViewById(R.id.emailAddress);
        editTextEmail = findViewById(R.id.email);
        editTextPass = findViewById(R.id.password);
        editTextConfirm = findViewById(R.id.confirmPass);
        sign_btn = findViewById(R.id.signUp_btn);


        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    /**
     * Check input boxes
     * @return boolean , user expression  is valid or not !
     */
    private boolean check(String username, String useremail, String userpass, String userpassconfirm){
        boolean isOk=true;
            //not null check
            if (username.length() < 2 ) {
                editTextName.setError("Name should be entered!");
                editTextName.requestFocus();
                isOk=false;
            }
            if(useremail.isEmpty()){
                editTextEmail.setError("Email is required!");
                editTextEmail.requestFocus();
                isOk = false;
            }
            if(!Patterns.EMAIL_ADDRESS.matcher(useremail).matches()){
                editTextEmail.setError("Please provide valid email!");
                editTextEmail.requestFocus();
                isOk = false;
            }
            if(userpass.isEmpty()){
                editTextPass.setError("Password is should be entered!");
                editTextPass.requestFocus();
                isOk = false;
            }
            if(userpass.length() < 6){
                editTextPass.setError("Min password length should be 6 character !");
                editTextPass.requestFocus();
                isOk = false;
            }

            //confirm check
            if(!userpassconfirm.equals(userpass)){
                editTextConfirm.setError("should be equal to password!");
                editTextPass.requestFocus();
                isOk = false;
            }

        return isOk;
    }


    /**
     * Signup method , use realtime database and authentication!
     * @param username
     * @param useremail
     * @param userpass
     */
    private void signUp(String username, String useremail, String userpass){
        firebaseAuth.createUserWithEmailAndPassword(useremail, userpass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    databaseReference.child("Users").child(firebaseAuth.getCurrentUser().getUid()).child("userName").setValue(username);
                    Toast.makeText(SignUp.this, " register successfully !" , Toast.LENGTH_LONG).show();

                    //if successful go to main page
                    Intent intent = new Intent (SignUp.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(SignUp.this, " not registered !" , Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void onBackPressed() {
        Intent intent = new Intent (SignUp.this , Welcome.class);
        startActivity(intent);
        finish();
    }


}