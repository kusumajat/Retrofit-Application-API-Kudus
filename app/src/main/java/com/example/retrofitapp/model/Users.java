package com.example.retrofitapp.model;

import com.bumptech.glide.load.data.DataRewinder;
import com.google.gson.annotations.SerializedName;
import java.util.List;
public class Users {

    //menghubungkan JSON field "data" dengan variabel data
    @SerializedName("data")
    private List<Data> data;

    // Getter untuk mendapatkan nilai dari variabel data
    public List<Data> getData(){
        return data;
    }
}
