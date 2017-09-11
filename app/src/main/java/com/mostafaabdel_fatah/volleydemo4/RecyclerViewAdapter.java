package com.mostafaabdel_fatah.volleydemo4;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Mostafa AbdEl_Fatah on 9/8/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    ArrayList<Doctor> doctorArrayList = new ArrayList<>();

    public RecyclerViewAdapter(ArrayList<Doctor> doctorArrayList) {
        this.doctorArrayList = doctorArrayList;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.name.setText(holder.name.getText()+doctorArrayList.get(position).getName());
        holder.spec.setText(holder.spec.getText()+doctorArrayList.get(position).getSpec());
        holder.address.setText(holder.address.getText()+doctorArrayList.get(position).getAddress());
        holder.phone.setText(holder.phone.getText()+doctorArrayList.get(position).getPhone());

    }

    @Override
    public int getItemCount() {
        return doctorArrayList.size();
    }

    public static  class RecyclerViewHolder extends RecyclerView.ViewHolder{

        TextView name,spec,address,phone;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.textView);
            spec = (TextView) itemView.findViewById(R.id.textView2);
            address = (TextView) itemView.findViewById(R.id.textView3);
            phone = (TextView) itemView.findViewById(R.id.textView4);
        }
    }
}
