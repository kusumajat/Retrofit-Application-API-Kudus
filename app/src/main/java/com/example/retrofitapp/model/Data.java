package com.example.retrofitapp.model;

import com.google.gson.annotations.SerializedName;

public class Data {

    //menghubungkan JSON field dengan variable Java
    @SerializedName("nama_surveyor")
    private String namaSurveyor;

    @SerializedName("usia")
    private String usia;

    @SerializedName("jenis_kelamin")
    private String jenisKelamin;

    @SerializedName("pekerjaan")
    private String pekerjaan;

    @SerializedName("id_desa")
    private String idDesa;

    @SerializedName("nama_desa")
    private String namaDesa;

    @SerializedName("latitude")
    private String latitude;

    @SerializedName("longitude")
    private String longitude;

    //Getter untuk mendapatkan nilai dari variabel
    public String getNamaSurveyor(){
        return namaSurveyor;
    }
    public String getUsia(){
        return usia;
    }
    public String getJenisKelamin(){
        return jenisKelamin;
    }
    public String getPekerjaan(){
        return pekerjaan;
    }
    public String getIdDesa(){
        return idDesa;
    }
    public String getNamaDesa() {
        return namaDesa;
    }
    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }
}
