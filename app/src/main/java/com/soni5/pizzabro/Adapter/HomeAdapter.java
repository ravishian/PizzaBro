package com.soni5.pizzabro.Adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;

import com.soni5.pizzabro.Fragment.BuyFragment;
import com.soni5.pizzabro.Model.HomeModel;
import com.soni5.pizzabro.R;

import java.util.ArrayList;
import java.util.jar.Attributes;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.homeholder>

{
    public HomeAdapter(ArrayList<HomeModel> datalist) {
        this.datalist = datalist;
    }

    ArrayList<HomeModel> datalist;

    @NonNull
    @Override
    public homeholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_pizza,parent,false);
        return new homeholder(view);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull homeholder holder, int position)
    {
        holder.t1.setText(datalist.get(position).getNamePizza());
        holder.t2.setText(datalist.get(position).getNumber());
        holder.t3.setText(datalist.get(position).getPrice());

        holder.cs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                AppCompatActivity appCompatActivity = (AppCompatActivity) v.getContext();
                //QuesFragment quesFragment = new QuesFragment();
                appCompatActivity.getSupportFragmentManager()
                        .beginTransaction().
                        replace(R.id.frameLayout2,new BuyFragment(datalist.get(position).getNamePizza(),
                                datalist.get(position).getNumber(),
                                datalist.get(position).getPrice(),
                                datalist.get(position).getId(),datalist.get(position).getDescription()))
                        //  replace(R.id.t_frame_layout,new T_StatusFragment(datalist.get(position).getComment_id(),datalist.get(position).getStatus(),datalist.get(position).getProblem(),datalist.get(position).getSubject())).addToBackStack(null)
                        .commit();


            }
        });
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    class homeholder extends RecyclerView.ViewHolder
    {

        TextView t1,t2,t3;
        ConstraintLayout cs;

        public homeholder(@NonNull View itemView) {
            super(itemView);

            t1 = itemView.findViewById(R.id.PizzaName);
            t2 = itemView.findViewById(R.id.pizzanumber);
            t3 = itemView.findViewById(R.id.price);
            cs = itemView.findViewById(R.id.constraintpizza);





        }
    }

}
