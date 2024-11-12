package com.example.retrofitapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.retrofitapp.model.Data;
import java.util.List;

public class CustomAdapter extends BaseAdapter {

    private Context context;
    private List<Data> dataList;
    private int[] userImages;

    // Constructor CustomAdapter untuk menerima data API dan gambar dari drawable
    public CustomAdapter(Context context, List<Data> dataList, int[] userImages) {
        this.context = context;
        this.dataList = dataList;
        this.userImages = userImages;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        }

        // Bind ImageView dan TextView
        ImageView imageView = convertView.findViewById(R.id.item_image);
        TextView textView = convertView.findViewById(R.id.item_text);

        // Set gambar dari drawable berdasarkan posisi
        imageView.setImageResource(userImages[position % userImages.length]);

        // Set teks berdasarkan data yang diterima dari API
        Data data = dataList.get(position);
        String userDetails = "Surveyor: " + data.getNamaSurveyor() + "\n" +
                "Usia: " + data.getUsia() + "\n" +
                "Jenis Kelamin: " + data.getJenisKelamin() + "\n" +
                "Pekerjaan: " + data.getPekerjaan() + "\n" +
                "Nama Desa: " + data.getNamaDesa();
        textView.setText(userDetails);

        return convertView;
    }
}
