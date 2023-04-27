package com.soni5.pizzabro.Manager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.soni5.pizzabro.Fragment.C_MainActivity;
import com.soni5.pizzabro.R;
import com.soni5.pizzabro.SignupActivity;

import java.util.HashMap;
import java.util.Random;


public class AddProductFragment extends Fragment {
    private String mParam2;

    public AddProductFragment() {
        // Required empty public constructor
    }


    EditText e1,e2,e3,e4;
    Button btn;
    FirebaseFirestore firestore;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_product, container, false);

        e1 = view.findViewById(R.id.NamePizza);
        e2 = view.findViewById(R.id.Description);
        e3 = view.findViewById(R.id.Price);
        e4 = view.findViewById(R.id.id);
        btn = view.findViewById(R.id.savepizza);

        firestore =  FirebaseFirestore.getInstance();

        HashMap<String,String> r = new HashMap<>();

        Random rand = new Random();
        int rand_int1 = rand.nextInt(1000);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                r.put("NamePizza",e1.getText().toString());
                r.put("Description",e2.getText().toString());
                r.put("Number",e3.getText().toString());
                r.put("Price",e4.getText().toString());
                r.put("id", String.valueOf(rand_int1));

                firestore.collection("Pizzas").document().set(r).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused)
                    {


                        Toast.makeText(getActivity(), "abc", Toast.LENGTH_SHORT).show();

                    }
                });

            }
        });


        return  view;

    }
}