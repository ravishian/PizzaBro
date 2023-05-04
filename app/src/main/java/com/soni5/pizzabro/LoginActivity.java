package com.soni5.pizzabro;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.soni5.pizzabro.Fragment.C_MainActivity;

public class LoginActivity extends AppCompatActivity {


    EditText email,password;
    Button btn;
    TextView t1,t2;

    FirebaseAuth firebaseAuth;
    FirebaseFirestore firestore;




    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.uemail);
        password = findViewById(R.id.upassword);
        btn = findViewById(R.id.loginbutton);
        t1 = findViewById(R.id.lsignup);
        t2 = findViewById(R.id.lforgot);

        firebaseAuth = FirebaseAuth.getInstance();
        firestore =  FirebaseFirestore.getInstance();


        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(i);
                finish();
            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                String e , p ;

                e = email.getText().toString();
                p = password.getText().toString();


                firebaseAuth.signInWithEmailAndPassword(e,p).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult)
                    {
                        Intent i = new Intent(LoginActivity.this, C_MainActivity.class);
                        startActivity(i);
                        finish();
                    }
                });


            }
        });







    }
}