package com.example.laporanwarung.network;

import com.bumptech.glide.disklrucache.DiskLruCache;
import com.example.laporanwarung.model.ListProdukModel;
import com.example.laporanwarung.model.ProdukModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    @GET("read.php")
    Call<ListProdukModel> getProduk();

    @POST("read.php")
    static Call<ProdukModel> createPost(@Body ProdukModel produkModel) {
        return null;
    }

}
