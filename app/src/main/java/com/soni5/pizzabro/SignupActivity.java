package com.soni5.pizzabro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.soni5.pizzabro.Fragment.C_MainActivity;

import java.util.HashMap;

public class SignupActivity extends AppCompatActivity {



    EditText e1,e2,e3,e4;
    Button btn;
    TextView textViews;
    FirebaseFirestore firestore;


    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        e1 = findViewById(R.id.sname);
        e2 = findViewById(R.id.sPassword);
        e3 = findViewById(R.id.sNumber);
        e4 = findViewById(R.id.sadress);

        btn = findViewById(R.id.ssignup);

        textViews = findViewById(R.id.slogin);

        firestore =  FirebaseFirestore.getInstance();


        HashMap<String,String> r = new HashMap<>();

        textViews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        });

        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {



                String email = e4.getText().toString();





                FirebaseAuth firebaseAuth;
                firebaseAuth = FirebaseAuth.getInstance();



                firebaseAuth.createUserWithEmailAndPassword(email ,e2.getText().toString()).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult)
                    {
                        r.put("Name",e1.getText().toString());
                        r.put("Password",e2.getText().toString());
                        r.put("Number",e3.getText().toString());
                        r.put("Email",e4.getText().toString());
                        r.put("Uid",firebaseAuth.getUid());
                        r.put("type","User");


                        firestore.collection("Customers").document(firebaseAuth.getUid()).set(r).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused)
                            {

                                Intent i = new Intent(SignupActivity.this, C_MainActivity.class);
                                startActivity(i);
                                finish();

                                Toast.makeText(SignupActivity.this, "User Created", Toast.LENGTH_SHORT).show();
                            }
                        });

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(SignupActivity.this, e.toString(), Toast.LENGTH_SHORT).show();

                        Log.d("TAG", e.toString());
                    }
                });



            }
        });







    }
}