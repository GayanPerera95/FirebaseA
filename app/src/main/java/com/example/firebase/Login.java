package com.example.firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    private EditText email,password;
    private Button Loginbtn;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_login );

        email = findViewById(R.id.emailLogin);
        password = findViewById(R.id.passwordLogin);
        Loginbtn = findViewById(R.id.Loginbtn);

        auth = FirebaseAuth.getInstance();

        Loginbtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String emailtxt = email.getText().toString();
                String passwordtxt = password.getText().toString();

                LoginUser(emailtxt,passwordtxt);

            }
        } );
    }

    private void LoginUser(String email, String password){
        auth.signInWithEmailAndPassword( email,password ).addOnSuccessListener( new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText( Login.this, "Login Successful",Toast.LENGTH_SHORT ).show();
                startActivity( new Intent(Login.this, MainActivity.class) );
                finish();
            }
        } );
    }
}