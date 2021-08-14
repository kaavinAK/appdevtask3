package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class fullpage extends AppCompatActivity {
    int id;
    fulldog alldata;
    TextView name;
    TextView origin;
    TextView temperament;
    TextView height;
    TextView width;
    TextView life;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullpage);
        Intent intent = getIntent();
        id=intent.getIntExtra("id",0);
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.thedogapi.com/v1/").addConverterFactory(GsonConverterFactory.create()).build();
        findViewById(R.id.backfull).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),MainActivity.class);
                v.getContext().startActivity(intent);
            }
        });
        JSONPlacehoder jsonPlacehoder = retrofit.create(JSONPlacehoder.class);
        Call<List<fulldog>> call = jsonPlacehoder.getALL();

        call.enqueue(new Callback<List<fulldog>>() {
            @Override
            public void onResponse(Call<List<fulldog>> call, Response<List<fulldog>> response) {
                if(!response.isSuccessful())
                {
                    Log.d("error", "so close...");
                    return ;
                }
                else{
                    List<fulldog> data = response.body();
                    //Picasso.with(viewHolder.getCtx()).load(url).into(viewHolder.getImageview());
                    for(int i=0;i<data.size();i++)
                    {
                        if(data.get(i).id==id)
                        {
                            alldata=data.get(i);
                        }
                    }
                    Picasso.with(getBaseContext()).load(alldata.image.url).into((ImageView) findViewById(R.id.imagefull));
                    name=findViewById(R.id.namefull);
                    origin=findViewById(R.id.originfull);
                    temperament=findViewById(R.id.temperamentfull);
                    height=findViewById(R.id.heightfull);
                    width=findViewById(R.id.widthfull);
                    life=findViewById(R.id.lifefull);
                    name.setText("NAME: "+alldata.name);
                    origin.setText("ORIGIN: "+alldata.origin);
                    height.setText("HEIGHT(in m): "+alldata.height.metric);
                    width.setText("WEIGHT(in m): "+alldata.weight.metric);
                    life.setText("LIFE-SPAN(in years): "+alldata.life_span);
                    temperament.setText(alldata.temperament);
                }
            }

            @Override
            public void onFailure(Call<List<fulldog>> call, Throwable t) {
                Log.d("error", "mission failed we will get them next time");
            }
        });
    }
}