package com.example.covid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<data> dataModelArrayList;

    public Adapter(Context ctx, ArrayList<data> dataModelArrayList){

        inflater = LayoutInflater.from(ctx);
        this.dataModelArrayList = dataModelArrayList;
    }

    @Override
    public Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item_layout, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(Adapter.MyViewHolder holder, int position) {

        holder.state.setText(dataModelArrayList.get(position).getState());
        holder.confirmed.setText(dataModelArrayList.get(position).getConfirmed());
        holder.active.setText(dataModelArrayList.get(position).getActive());
        holder.recovered.setText(dataModelArrayList.get(position).getRecovered());
        holder.deaths.setText(dataModelArrayList.get(position).getDeaths());
        holder.newcases.setText(dataModelArrayList.get(position).getNewcases());
        holder.nrecovered.setText(dataModelArrayList.get(position).getNrecovered());
        holder.ndeath.setText(dataModelArrayList.get(position).getNdeath());
    }

    @Override
    public int getItemCount() {
        return dataModelArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView state,confirmed,active,recovered,deaths,newcases,nrecovered,ndeath;

        public MyViewHolder(View itemView) {
            super(itemView);

            state = (TextView) itemView.findViewById(R.id.stateTV);
            confirmed = (TextView) itemView.findViewById(R.id.confirmTV);
            active = (TextView) itemView.findViewById(R.id.activeTV);
            recovered = (TextView) itemView.findViewById(R.id.recoveredTV);
            deaths = (TextView) itemView.findViewById(R.id.deathTV);
            newcases = (TextView) itemView.findViewById(R.id.newTV);
            nrecovered = (TextView) itemView.findViewById(R.id.nrecoveredTV);
            ndeath = (TextView) itemView.findViewById(R.id.ndeathTV);
        }

    }
}
