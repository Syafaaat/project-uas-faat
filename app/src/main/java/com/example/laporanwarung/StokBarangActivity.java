package com.example.laporanwarung;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.laporanwarung.model.ListProdukModel;
import com.example.laporanwarung.model.ProdukModel;
import com.example.laporanwarung.network.ApiClient;
import com.example.laporanwarung.network.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StokBarangActivity extends AppCompatActivity {

    private List<ProdukModel> mListProduk = new ArrayList<>();
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stok_barang);

        gridView = findViewById(R.id.gridView3);

        getAllData();
    }

    private void getAllData() {
        ApiService apiService = ApiClient.getRetrofit().create(ApiService.class);
        Call<ListProdukModel> call = apiService.getProduk();
        call.enqueue(new Callback<ListProdukModel>() {
            @Override
            public void onResponse(Call<ListProdukModel> call, Response<ListProdukModel> response) {
                mListProduk = response.body().getResult();

                CustomAdapterStok customAdapter = new CustomAdapterStok(mListProduk, StokBarangActivity.this);

                gridView.setAdapter(customAdapter);
            }

            @Override
            public void onFailure(Call<ListProdukModel> call, Throwable t) {
                Toast.makeText(StokBarangActivity.this, "Koneksi Gagal!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public class CustomAdapterStok extends BaseAdapter {

        private List<ProdukModel> produkModel;
        private Context context;
        private LayoutInflater layoutInflater;

        public CustomAdapterStok(List<ProdukModel> produkModel, Context context) {
            this.produkModel = produkModel;
            this.context = context;
            this.layoutInflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return produkModel.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if(view == null){
                view = layoutInflater.inflate(R.layout.item_stok_list, viewGroup, false);
            }

            ImageView imageView = view.findViewById(R.id.iv_icon_stok);
            TextView namaProduk = view.findViewById(R.id.nama_produk_stok);
            TextView hargaProduk = view.findViewById(R.id.harga_barang_stok);

            Integer stok = Integer.valueOf(produkModel.get(i).getStok());

            namaProduk.setText(produkModel.get(i).getNamaProduk());
            hargaProduk.setText(String.valueOf(stok));

            Glide.with(context).load(produkModel.get(i).getFoto()).into(imageView);

            return view;
        }
    }
}