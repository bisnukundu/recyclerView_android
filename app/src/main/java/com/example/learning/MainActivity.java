package com.example.learning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

RecyclerView myRecycle;
    ArrayList<Data> data = new ArrayList<>();
    CustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data.add(new Data("A","017252525"));
        data.add(new Data("B","0172523625"));
        data.add(new Data("C","01725236525"));
        data.add(new Data("D","01725222525"));
        data.add(new Data("E","017252745"));
        data.add(new Data("F","017252525"));
        data.add(new Data("G","0172523625"));
        data.add(new Data("H","01725236525"));
        data.add(new Data("I","01725222525"));
        data.add(new Data("Soyob","017252745"));
        data.add(new Data("Bisnu","017252525"));
        data.add(new Data("Badhon","0172523625"));
        data.add(new Data("Pram","01725236525"));
        data.add(new Data("Noman","01725222525"));
        data.add(new Data("Soyob","017252745"));

        adapter = new CustomAdapter(this,data);
        myRecycle = findViewById(R.id.recycleViewID);
        myRecycle.setLayoutManager(new LinearLayoutManager(this));
        myRecycle.setAdapter(adapter);

        FloatingActionButton flot_btn = findViewById(R.id.flot_btn);


        flot_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.dialog);
                dialog.show();

                EditText number = dialog.findViewById(R.id.edt_number);
                EditText name = dialog.findViewById(R.id.edt_name);

            Button btn = dialog.findViewById(R.id.insert_btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    data.add(new Data(name.getText().toString(),number.getText().toString()));
                    Toast.makeText(getApplicationContext(), "Insert Successfully", Toast.LENGTH_SHORT).show();
                    adapter.notifyItemInserted(data.size()-1);
                    myRecycle.scrollToPosition(data.size()-1);
                    dialog.dismiss();
                }
            });

            }
        });

    }

}