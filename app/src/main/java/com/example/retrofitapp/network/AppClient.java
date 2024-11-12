package com.example.retrofitapp.network;

import java.security.cert.CertPathBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppClient {
    public static ApiService getInstance() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient mOkhHttpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor).build();

        // Membuat instance Retrofit dengan base URL, converter Gson, dan OkHttpClient
        Retrofit builder = new Retrofit.Builder()
                .baseUrl("https://inarisk2.bnpb.go.id/api/siagamasyarakat/get-data/") // URL dasar API
                .addConverterFactory(GsonConverterFactory.create()) // Converter untuk JSON response
                .client(mOkhHttpClient) // OkHttpClient khusus dengan logging
                .build();
        return builder.create(ApiService.class);
    }
}
