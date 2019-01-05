package com.example.ashutosh_pc.pokepedia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> pokTypes=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pokTypes.add("Normal");
        pokTypes.add("Fighting");
        pokTypes.add("Flying");
        pokTypes.add("Poison");
        pokTypes.add("Ground");
        pokTypes.add("Rock");
        pokTypes.add("Bug");
        pokTypes.add("Ghost");
        pokTypes.add("Steel");
        pokTypes.add("Fire");
        pokTypes.add("Water");
        pokTypes.add("Grass");
        pokTypes.add("Electric");
        pokTypes.add("Psychic");
        pokTypes.add("Ice");
        pokTypes.add("Dragon");
        pokTypes.add("Dark");
        pokTypes.add("Fairy");

        RecyclerView mainview=findViewById(R.id.mainview);
        PokTypeAdapter mainadapter=new PokTypeAdapter(pokTypes);
        mainview.setLayoutManager(new LinearLayoutManager(this));
        mainview.setAdapter(mainadapter);



    }
}
