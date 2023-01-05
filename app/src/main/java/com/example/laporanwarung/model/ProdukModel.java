package com.example.laporanwarung.model;

import com.google.gson.annotations.SerializedName;

public class ProdukModel {
	private String foto_produk;
	private String nama_produk;
	private String harga_satuan;
	private String stok_barang;

	public void setFoto_produk(String foto_produk) {
		this.foto_produk = foto_produk;
	}

	public String getNama_produk() {
		return nama_produk;
	}

	public void setNama_produk(String nama_produk) {
		this.nama_produk = nama_produk;
	}

	public String getHarga_satuan() {
		return harga_satuan;
	}

	public void setHarga_satuan(String harga_satuan) {
		this.harga_satuan = harga_satuan;
	}

	public String getStok_barang() {
		return stok_barang;
	}

	public void setStok_barang(String stok_barang) {
		this.stok_barang = stok_barang;
	}

	public ProdukModel(String nama_produk, String harga_satuan, String stok_barang, String stokBarang){
		this.nama_produk = nama_produk;
		this.harga_satuan = harga_satuan;
		this.stok_barang = stok_barang;
		this.foto_produk = foto_produk;
	}


	@SerializedName("nama_produk")
	private String namaProduk;

	@SerializedName("harga")
	private String harga;

	@SerializedName("foto")
	private String foto;

	@SerializedName("id")
	private String id;

	@SerializedName("stok")
	private String stok;

	public String getNamaProduk(){
		return namaProduk;
	}

	public String getHarga(){
		return harga;
	}

	public String getFoto(){
		return foto;
	}

	public String getId(){
		return id;
	}

	public String getStok(){
		return stok;
	}
}