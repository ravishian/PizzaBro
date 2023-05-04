package com.soni5.pizzabro.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.soni5.pizzabro.Model.OfferModel;
import com.soni5.pizzabro.R;

import java.util.ArrayList;

public class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.offerholder>
{

    public OfferAdapter(ArrayList<OfferModel> datalist) {
        this.datalist = datalist;
    }

    ArrayList<OfferModel> datalist;

    @NonNull
    @Override
    public offerholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_offer_pizza,parent,false);
        return new OfferAdapter.offerholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull offerholder holder, int position)
    {

         holder.t1.setText(datalist.get(position).getNew());
        holder.t2.setText(datalist.get(position).getOld());
        holder.t3.setText(datalist.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return  datalist.size();
    }


    class offerholder extends RecyclerView.ViewHolder {
        ConstraintLayout cs;
        TextView t1,t2,t3,t4;
        public offerholder(@NonNull View itemView) {
            super(itemView);



            t1 = itemView.findViewById(R.id.nprice);
            t2 = itemView.findViewById(R.id.oprice);
            t3 = itemView.findViewById(R.id.opizzaname);
            cs = itemView.findViewById(R.id.oconstraintpizza);


        }
    }
}
