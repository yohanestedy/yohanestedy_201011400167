package com.ini_package_name.yohanestedy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BarangAdapter extends RecyclerView.Adapter<BarangAdapter.BarangViewHolder> {
    private List<Barang> listBarang;

    public BarangAdapter(List<Barang> listBarang) {
        this.listBarang = listBarang;
    }

    @NonNull
    @Override
    public BarangViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_barang, parent, false);
        return new BarangViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BarangViewHolder holder, int position) {
        Barang barang = listBarang.get(position);
        holder.gambarBarang.setImageResource(barang.getGambar());
        holder.namaBarang.setText(barang.getNama());
        holder.hargaBarang.setText(String.format("Rp %d", barang.getHarga()));
    }

    @Override
    public int getItemCount() {
        return listBarang.size();
    }

    public static class BarangViewHolder extends RecyclerView.ViewHolder {
        public ImageView gambarBarang;
        public TextView namaBarang;
        public TextView hargaBarang;

        public BarangViewHolder(@NonNull View itemView) {
            super(itemView);
            gambarBarang = itemView.findViewById(R.id.gambar_barang);
            namaBarang = itemView.findViewById(R.id.nama_barang);
            hargaBarang = itemView.findViewById(R.id.harga_barang);
        }
    }
}
