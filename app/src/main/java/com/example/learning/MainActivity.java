package com.example.learning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

RecyclerView myRecycle;
    ArrayList<Data> data = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data.add(new Data("Bisnu","017252525"));
        data.add(new Data("Badhon","0172523625"));
        data.add(new Data("Pram","01725236525"));
        data.add(new Data("Noman","01725222525"));
        data.add(new Data("Soyob","017252745"));
        data.add(new Data("Bisnu","017252525"));
        data.add(new Data("Badhon","0172523625"));
        data.add(new Data("Pram","01725236525"));
        data.add(new Data("Noman","01725222525"));
        data.add(new Data("Soyob","017252745"));
        data.add(new Data("Bisnu","017252525"));
        data.add(new Data("Badhon","0172523625"));
        data.add(new Data("Pram","01725236525"));
        data.add(new Data("Noman","01725222525"));
        data.add(new Data("Soyob","017252745"));
        data.add(new Data("Bisnu","017252525"));
        data.add(new Data("Badhon","0172523625"));
        data.add(new Data("Pram","01725236525"));
        data.add(new Data("Noman","01725222525"));
        data.add(new Data("Soyob","017252745"));

        myRecycle = findViewById(R.id.recycleViewID);
        myRecycle.setLayoutManager(new LinearLayoutManager(this));

        myRecycle.setAdapter(new CustomAdapter(this,data));

    }

}