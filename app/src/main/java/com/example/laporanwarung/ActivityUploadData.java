package com.example.laporanwarung;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.laporanwarung.model.ProdukModel;
import com.example.laporanwarung.network.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ActivityUploadData extends AppCompatActivity {

    private EditText EdtFoto, EdtProduk, EdtHarga, EdtStok;
    private Button postBarangBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_data);

        EdtFoto = findViewById(R.id.EdtFoto);
        EdtProduk = findViewById(R.id.EdtProduk);
        EdtHarga = findViewById(R.id.EdtHarga);
        EdtStok = findViewById(R.id.EdtStok);
        postBarangBtn = findViewById(R.id.BtnTambahBarang);

        postBarangBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (EdtFoto.getText().toString().isEmpty() && EdtProduk.getText().toString().isEmpty() && EdtHarga.getText().toString().isEmpty() && EdtStok.getText().toString().isEmpty()) {
                    Toast.makeText(ActivityUploadData.this, "Masukan datanya", Toast.LENGTH_SHORT).show();
                    return;
                }
                postBarang(EdtFoto.getText().toString(), EdtProduk.getText().toString(), EdtHarga.getText().toString(), EdtStok.getText().toString());
            }
        });
    }
    private void postBarang(String foto_produk, String nama_produk, String harga_satuan, String stok_barang){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://cvsyalsyahsyafaath.000webhostapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        ProdukModel model = new ProdukModel(foto_produk, nama_produk, harga_satuan, stok_barang);
        Call<ProdukModel> call = ApiService.createPost(model);
        call.enqueue(new Callback<ProdukModel>() {
            @Override
            public void onResponse(Call<ProdukModel> call, Response<ProdukModel> response) {
                Toast.makeText(ActivityUploadData.this,"data sudah di tambahkan Ke API", Toast.LENGTH_SHORT).show();
                EdtFoto.setText("");
                EdtProduk.setText("");
                EdtHarga.setText("");
                EdtStok.setText("");

                ProdukModel responseFromAPI = response.body();

                assert responseFromAPI != null;
                String responseString = "Response Code: " + response.code() +"\nfoto: " +responseFromAPI.getFoto() +"\n" + "nama_produk :" + responseFromAPI.getNama_produk() + "\n" + "harga :" + responseFromAPI.getHarga_satuan() + "\n" + "stok :" + responseFromAPI.getStok_barang();


            }

            @Override
            public void onFailure(Call<ProdukModel> call, Throwable t) {


            }
        });

    }
}