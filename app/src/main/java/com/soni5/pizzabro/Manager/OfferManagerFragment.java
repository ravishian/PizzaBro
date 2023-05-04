package com.soni5.pizzabro.Manager;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.soni5.pizzabro.R;

import java.util.HashMap;


public class OfferManagerFragment extends Fragment {


    EditText name , oldprice , newprice;
    Button btn;
    HashMap<String , String> vs = new HashMap<>();

    FirebaseFirestore firestore;


    public OfferManagerFragment() {
        // Required empty public constructor
    }





    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_offer_manager, container, false);


        name = view.findViewById(R.id.ospizzaname);
        oldprice = view.findViewById(R.id.osoldprice);
        newprice =  view.findViewById(R.id.osnewprice);
        btn = view.findViewById(R.id.osbutton);

        firestore = FirebaseFirestore.getInstance();

        int a = (int) Math.random();

        String b = String.valueOf(a);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                vs.put("Name",name.getText().toString());
                vs.put("old",oldprice.getText().toString());
                vs.put("New",newprice.getText().toString());
                vs.put("id",b);


                firestore.collection("Offer").add(vs).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference)
                    {
                        Toast.makeText(getContext(), "Hogya Update", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });




        return  view;

    }
}