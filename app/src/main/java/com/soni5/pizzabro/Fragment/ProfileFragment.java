package com.soni5.pizzabro.Fragment;

import static android.content.ContentValues.TAG;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.soni5.pizzabro.MainActivity;
import com.soni5.pizzabro.R;


public class ProfileFragment extends Fragment {



    public ProfileFragment() {
        // Required empty public constructor
    }


    TextView t1 ,t2,t3;
    Button btn;


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
          View view = inflater.inflate(R.layout.fragment_profile, container, false);


        t1 = view.findViewById(R.id.namel);
        t2 = view.findViewById(R.id.emaill);
        t3 = view.findViewById(R.id.Numberl);

        btn = view.findViewById(R.id.logout);

        FirebaseAuth firebaseAuth;
        firebaseAuth = FirebaseAuth.getInstance();

        FirebaseFirestore firebaseFirestore;

        firebaseFirestore = FirebaseFirestore.getInstance();

        firebaseFirestore.collection("Customers").document(firebaseAuth.getUid()).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
           if (task.getResult().exists())
           {
               t1.setText(task.getResult().getString("Name"));
               t2.setText(task.getResult().getString("Email"));
               t3.setText(task.getResult().getString("Number"));



           }
            }
        });








            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    firebaseAuth.signOut();
                    Intent i = new Intent(getActivity(), MainActivity.class);
                    startActivity(i);



                }
            });

            return  view;
    }
}