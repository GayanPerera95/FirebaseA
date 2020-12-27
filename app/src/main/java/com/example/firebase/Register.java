package com.example.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {

     private EditText email,password;
     private Button regbtn;
     private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_register );

        email = findViewById(R.id.emailReg);
        password = findViewById(R.id.passwordReg);
        regbtn = findViewById(R.id.Regbtn);

        auth = FirebaseAuth.getInstance();

        regbtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailtxt = email.getText().toString();
                String passwordtxt = password.getText().toString();

                if (TextUtils.isEmpty( emailtxt )||TextUtils.isEmpty( passwordtxt )){
                    Toast.makeText( Register.this,"Empty",Toast.LENGTH_SHORT );
                }else if (passwordtxt.length()<7){
                    Toast.makeText( Register.this,"Strong",Toast.LENGTH_SHORT );

                }else {
                    registerUser(emailtxt,passwordtxt);
                }
            }
        } );


    }

    private void registerUser(String email,String password){
        auth.createUserWithEmailAndPassword( email,password ).addOnCompleteListener( Register.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText( Register.this,"Registered Success!",Toast.LENGTH_SHORT ).show();
                }else {
                    Toast.makeText( Register.this,"Register failed",Toast.LENGTH_SHORT ).show();
                }
            }
        } );
    }
}