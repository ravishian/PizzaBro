package com.soni5.pizzabro.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.soni5.pizzabro.R;


public class BuyFragment extends Fragment {


    String namePizza,  number,  price,  id, description;

    public BuyFragment(String namePizza, String number, String price, String id, String description)
    {
        // Required empty public constructor
        this.namePizza = namePizza;
        this.number = number;
        this.price = price;
        this.id = id;
        this.description = description;
    }

    TextView t1,t2,t3,t4;
    Button btn;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_buy, container, false);


        t1 = view.findViewById(R.id.bnamepizza);
        t2 = view.findViewById(R.id.bnumber);
        t3= view.findViewById(R.id.bid);
        t4= view.findViewById(R.id.bdescription);

        t1.setText(namePizza);
        t2.setText(number);
        t3.setText(description);
        t4.setText(price);

        btn = view.findViewById(R.id.border);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                ConfirmFragment confirmFragment = new ConfirmFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameLayout2, confirmFragment).commit();


            }
        });

        return view;

    }
}