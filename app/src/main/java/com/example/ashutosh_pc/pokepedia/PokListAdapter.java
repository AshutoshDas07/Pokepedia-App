package com.example.ashutosh_pc.pokepedia;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class PokListAdapter extends RecyclerView.Adapter<PokListAdapter.MyViewHolder> {

    ArrayList<Pokemon> poke;
    static String p="";




    public PokListAdapter(ArrayList<Pokemon> poke) {
        this.poke = poke;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_elements_pic_name,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        p=poke.get(position).getPokemon().getUrl();
        String[] urls = p.split("/");
        int pokeRank = Integer.parseInt(urls[urls.length - 1]);
        holder.pokTV.setText(poke.get(position).getPokemon().getName());
        Picasso.get().load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+pokeRank+".png").into(holder.pokIV);
    }

    @Override
    public int getItemCount() {
        return poke.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
       ImageView pokIV;
       TextView pokTV;
       FrameLayout watermark;
        public MyViewHolder(View itemView) {
            super(itemView);
            pokIV=itemView.findViewById(R.id.pokpic);
            pokTV=itemView.findViewById(R.id.pokname);
            watermark=itemView.findViewById(R.id.framelayout);
        }
    }
}
