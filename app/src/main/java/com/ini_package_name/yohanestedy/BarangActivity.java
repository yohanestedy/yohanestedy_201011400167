package com.ini_package_name.yohanestedy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.ini_package_name.yohanestedy.model.Barang;
import com.ini_package_name.yohanestedy.model.BarangAdapter;

import java.util.ArrayList;
import java.util.List;

public class BarangActivity extends AppCompatActivity {
    private List<Barang> listBarang = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barang);

        // Inisialisasi RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        BarangAdapter adapter = new BarangAdapter(listBarang);
        recyclerView.setAdapter(adapter);

        // Tambahkan data barang ke list
        listBarang.add(new Barang("Buku", 50000, R.drawable.ic_book));
        listBarang.add(new Barang("Pensil", 5000, R.drawable.ic_pencil));
        listBarang.add(new Barang("Baju", 150000, R.drawable.ic_shirt));
        listBarang.add(new Barang("Sepatu", 300000, R.drawable.ic_shoes));
        listBarang.add(new Barang("Tas", 200000, R.drawable.ic_bag));

        // Beri tahu adapter bahwa data telah berubah
        adapter.notifyDataSetChanged();
    }
}
