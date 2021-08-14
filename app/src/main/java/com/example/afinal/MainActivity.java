package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv=findViewById(R.id.recycleview);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.addItemDecoration(new DividerItemDecoration(rv.getContext(), DividerItemDecoration.VERTICAL));
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.thedogapi.com/v1/").addConverterFactory(GsonConverterFactory.create()).build();
        JSONPlacehoder jsonPlacehoder = retrofit.create(JSONPlacehoder.class);
        Call<List<dog>> call = jsonPlacehoder.getPost();
        call.enqueue(new Callback<List<dog>>() {
            @Override
            public void onResponse(Call<List<dog>> call, Response<List<dog>> response) {
                if(!response.isSuccessful())
                {
                    Log.d("error", "so close...");
                    return ;
                }
                else{
                    List<dog> data = response.body();
                    CustomAdapter ca = new CustomAdapter(data);
                    rv.setAdapter(ca);
                }
            }

            @Override
            public void onFailure(Call<List<dog>> call, Throwable t) {
                Log.d("error", "mission failed we will get them next time");
            }
        });

    }
}