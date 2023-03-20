package com.ini_package_name.yohanestedy;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvUserId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvUserId = findViewById(R.id.tv_user_id);
        Button btnExit = findViewById(R.id.btn_exit);

        Intent intent = getIntent();
        String userId = intent.getStringExtra("USER_ID");

        tvUserId.setText("Selamat Datang: " + userId);

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Exit");
                builder.setMessage("Yakin mau keluar nih?");
                builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Untuk masuk ke Dialog form
                        showExitReasonDialog();
                    }
                });
                builder.setNegativeButton("Tidak", null);
                builder.show();
            }
        });

        Button btnBarang = findViewById(R.id.btn_barang);
        btnBarang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BarangActivity.class);
                startActivity(intent);
            }
        });

    }

    private void showExitReasonDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Alasan Keluar");
        final EditText input = new EditText(this);
        builder.setView(input);
        builder.setPositiveButton("Simpan", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String exitReason = input.getText().toString();
                // simpan alasan keluar
                saveExitReason(exitReason);
                // keluar dari aplikasi
                finishAffinity();
            }
        });
        builder.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.show();
    }

    private void saveExitReason(String exitReason) {
        // kode untuk menyimpan alasan keluar
    }



}

