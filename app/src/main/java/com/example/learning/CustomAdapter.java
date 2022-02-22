package com.example.learning;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.myViewHolder> {
    ArrayList<Data> contacts;
    Context context;

    public CustomAdapter(Context context, ArrayList contacts){
        this.contacts = contacts;
        this.context = context;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.number,parent,false);
        myViewHolder vh = new myViewHolder(v);
        return vh;
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
            holder.name.setText(contacts.get(position).name);
            holder.number.setText(contacts.get(position).number);
    }

    public class myViewHolder extends RecyclerView.ViewHolder{
        TextView name,number;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            number = itemView.findViewById(R.id.number);
        }
    }
}
