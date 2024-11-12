package com.example.retrofitapp.network;

import com.example.retrofitapp.model.Data;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    //alamat endpoint yang dituju
    @GET("3319")
    Call <List<Data>> getAllUsers();
}
