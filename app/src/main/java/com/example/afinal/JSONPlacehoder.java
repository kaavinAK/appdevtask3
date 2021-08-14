package com.example.afinal;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JSONPlacehoder {
    @GET("breeds")
    Call<List<dog>>getPost();
    @GET("breeds")
    Call<List<fulldog>>getALL();
}
