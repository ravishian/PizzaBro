package com.soni5.pizzabro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.soni5.pizzabro.Fragment.C_MainActivity;

public class MainActivity extends AppCompatActivity {

    Button btn;

    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() != null)
        {
            Intent i = new Intent(MainActivity.this, C_MainActivity.class);
            startActivity(i);
            finish();
        }

        btn = findViewById(R.id.timepass);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(MainActivity.this, SignupActivity.class);
                startActivity(i);
                finish();

            }
        });


    }
}