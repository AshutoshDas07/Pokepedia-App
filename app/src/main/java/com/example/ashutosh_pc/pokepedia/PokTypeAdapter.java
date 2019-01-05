package com.example.ashutosh_pc.pokepedia;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class PokTypeAdapter extends RecyclerView.Adapter<PokTypeAdapter.MyHolder> {

    ArrayList<String> pokTypes;

    public PokTypeAdapter(ArrayList<String> pokTypes) {
        this.pokTypes = pokTypes;
    }


    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_elements,parent,false);
        return new MyHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.elementName.setText(pokTypes.get(position));
    }


    @Override
    public int getItemCount() {
        return pokTypes.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {

       TextView elementName;
        public MyHolder(final View itemView)
        {
            super(itemView);
            elementName=itemView.findViewById(R.id.name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(itemView.getContext(),PokTypeList.class);
                    intent.putExtra("POS",getAdapterPosition());
                    itemView.getContext().startActivity(intent);
                }
            });
        }

    }

}
