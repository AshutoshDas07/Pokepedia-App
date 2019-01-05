package com.example.ashutosh_pc.pokepedia;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import javax.security.auth.login.LoginException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.example.ashutosh_pc.pokepedia.PokListAdapter.p;


public class PokTypeList extends AppCompatActivity {

    private String default_url="https://pokeapi.co/api/v2/type/";
    private String url="";
    int getAdapterPosition;
    ArrayList<Pokemon> pokemon=new ArrayList<>();
    PokDetails object_Result1;
    OkHttpClient client=new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pok_type_list);
        final Intent receivedIntent=getIntent();
        getAdapterPosition=receivedIntent.getIntExtra("POS",0)+1;
        url=default_url+getAdapterPosition+"/";
        Log.e("TAG", "onCreate: " + url );
        final Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                final String result = response.body().string();
                Gson gson = new Gson();
                final pok object_Result=gson.fromJson(result,pok.class);
                pokemon = object_Result.getPokemon();

                    Log.e("TAG", "onResponse: " + p);

//                    Request request1 = new Request.Builder().url(p).build();
//
//                    Response pokeResponse = client.newCall(request1).execute();
//
//                    String jsonResponseOfPokemon = pokeResponse.body().string();
//
//                    object_Result1 = gson.fromJson(jsonResponseOfPokemon, PokDetails.class);

                    PokTypeList.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            RecyclerView myview = findViewById(R.id.pokview);
                            PokListAdapter adapter = new PokListAdapter(pokemon);
                            myview.setLayoutManager(new GridLayoutManager(getBaseContext(), 2));
                            myview.setAdapter(adapter);
                            final Context context = myview.getContext();
                            final LayoutAnimationController controller =
                                    AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_fall_down);

                            myview.setLayoutAnimation(controller);
                            myview.getAdapter().notifyDataSetChanged();
                            myview.scheduleLayoutAnimation();
                        }
                    });
            }
        });

//        client.newCall(request1).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                e.printStackTrace();
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                final String result1=response.body().string();
//
//
//                PokTypeList.this.runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//
//                    }
//                });
//            }
//        });

    }
}
