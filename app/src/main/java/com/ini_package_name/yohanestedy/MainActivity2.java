package com.ini_package_name.yohanestedy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    private List<Barang> listBarang = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

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
