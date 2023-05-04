package com.soni5.pizzabro.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.soni5.pizzabro.Adapter.HomeAdapter;
import com.soni5.pizzabro.Adapter.OfferAdapter;
import com.soni5.pizzabro.Model.HomeModel;
import com.soni5.pizzabro.Model.OfferModel;
import com.soni5.pizzabro.R;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }

    FirebaseFirestore db;

    HomeAdapter adapter;
    RecyclerView recyclerView,recyclerView2;
    ArrayList<HomeModel> datalist;


    OfferAdapter adapter2;
    ArrayList<OfferModel> datalist2;






    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);





        recyclerView2 = view.findViewById(R.id.offerrecylerview);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, true));
      //  recyclerView2.setLayoutManager(new LinearLayoutManager.HORIZONTAL,true ));

        recyclerView = view.findViewById(R.id.homerecyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext() ));

        datalist = new ArrayList<>();
        datalist2 = new ArrayList<>();

        db = FirebaseFirestore.getInstance();

        adapter= new HomeAdapter(datalist);
        recyclerView.setAdapter(adapter);

        adapter2= new OfferAdapter(datalist2);
        recyclerView2.setAdapter(adapter2);


        db.collection("Pizzas").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots)
            {
                List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                for (DocumentSnapshot d:list)
                {
                    HomeModel obj = d.toObject(HomeModel.class);
                    datalist.add(obj);

                }
                adapter.notifyDataSetChanged();
            }
        });


        db.collection("Offer").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots)
            {
                List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                for (DocumentSnapshot d:list)
                {
                    OfferModel obj = d.toObject(OfferModel.class);
                    datalist2.add(obj);

                }
                adapter2.notifyDataSetChanged();
            }
        });



        return  view;
    }
}