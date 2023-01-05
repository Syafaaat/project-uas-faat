package com.example.laporanwarung;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void hargaSatuan(View view) {
        Intent i = new Intent(MainActivity.this, HargaSatuanActivity.class);
        startActivity(i);
    }

    public void laporanTerjual(View view) {
        Intent i = new Intent(MainActivity.this, LaporanTerjualActivity.class);
        startActivity(i);
    }

    public void stok(View view) {
        Intent i = new Intent(MainActivity.this, StokBarangActivity.class);
        startActivity(i);
    }

    public void upload(View view){
        Intent i = new Intent(MainActivity.this, ActivityUploadData.class);
        startActivity(i);
    }
}