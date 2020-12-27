package com.example.firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {

    private Button Regbtn,Loginbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_start );

        Regbtn = findViewById( R.id.Regbtn );
        Loginbtn = findViewById( R.id.Loginbtn );

        Regbtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent( StartActivity.this, Register.class));
                finish();
            }
        } );
        Loginbtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity( new Intent(StartActivity.this,Login.class) );

            }
        } );


    }
}