package com.example.retrofitapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import com.example.retrofitapp.model.Data;
import com.example.retrofitapp.network.AppClient;
import com.example.retrofitapp.network.ApiService;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Menemukan ListView berdasarkan ID
        ListView listView = findViewById(R.id.tv_name);

        // Membuat service Retrofit
        ApiService client = AppClient.getInstance();

        // Panggilan API untuk mendapatkan data pengguna
        Call<List<Data>> response = client.getAllUsers();

        // List untuk menyimpan data pengguna
        List<Data> dataUser = new ArrayList<>();

        // Enqueue panggilan
        response.enqueue(new Callback<List<Data>>() {
            @Override
            public void onResponse(Call<List<Data>> call, Response<List<Data>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    dataUser.addAll(response.body());

                    // Array untuk gambar pengguna (gunakan gambar yang ada di drawable)
                    int[] userImages = {
                            R.drawable.image1, // Gambar 1
                            R.drawable.image2, // Gambar 2
                            R.drawable.image3, // Gambar 3
                            R.drawable.image4  // Gambar 4
                    };

                    // Menggunakan CustomAdapter
                    CustomAdapter adapter = new CustomAdapter(MainActivity.this, dataUser, userImages);
                    listView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Data>> call, Throwable t) {
                // Tangani kegagalan
            }
        });
    }
}
