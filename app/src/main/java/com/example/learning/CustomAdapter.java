package com.example.learning;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.myViewHolder> {
    ArrayList<Data> contacts;
    Context context;
    private int position;

    public CustomAdapter(Context context, ArrayList contacts) {
        this.contacts = contacts;
        this.context = context;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.number, parent, false);
        myViewHolder vh = new myViewHolder(v);
        return vh;
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        int p = position;
        holder.name.setText(contacts.get(position).name+position);
        holder.number.setText(contacts.get(position).number);

//LongPress action
        holder.row.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                action(p);
                return true;
            }
        });

//Set Animation
        Animation myAnimation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
        holder.row.startAnimation(myAnimation);
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView name, number;
        CardView row;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            number = itemView.findViewById(R.id.number);
            row = itemView.findViewById(R.id.row);

        }
    }

    ////////////////////////-----Custom Method Created by Bisnu kundu-------/////////////////////
    //LongPress Dialog show
    public void action(int position) {
        AlertDialog.Builder alert = new AlertDialog.Builder(context)
                .setTitle("Action id " +position)
                .setMessage("What do you want to do?")
                .setIcon(R.drawable.ic_launcher_foreground)
                .setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        deleteItem(position);
                    }
                }).setNegativeButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        updateItem(position);
                    }
                });
        alert.show();
    }

    //Update Item
    public void updateItem(int position) {
        Dialog updateDialog = new Dialog(context);
        updateDialog.setContentView(R.layout.dialog);
        updateDialog.show();

        Button insert_btn = updateDialog.findViewById(R.id.insert_btn);
        EditText name = updateDialog.findViewById(R.id.edt_name);
        EditText number = updateDialog.findViewById(R.id.edt_number);
        insert_btn.setText("Update");
        insert_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contacts.set(position, new Data(name.getText().toString(), number.getText().toString()));
                notifyItemChanged(position);
    updateDialog.dismiss();
                Toast.makeText(context, "Update", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void deleteItem(int position) {
        contacts.remove(position);
        notifyItemRemoved(position);
        Toast.makeText(context, "Delete Successfully " + position, Toast.LENGTH_SHORT).show();
    }
}
