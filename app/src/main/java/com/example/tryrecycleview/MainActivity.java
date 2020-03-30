package com.example.tryrecycleview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Herdi_WORK on 15.09.16.
 */
public class MainActivity extends AppCompatActivity {

    private RecyclerView rvView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<String> dataSet;
    private ArrayList<String> addDataSet;
    private FloatingActionButton fab;

    TextView textViewMessage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataSet = new ArrayList<>();
        addDataSet = new ArrayList<>();
        initDataset();

        rvView = (RecyclerView) findViewById(R.id.rv_main);
        rvView.setHasFixedSize(true);

        /**
         * Kita menggunakan LinearLayoutManager untuk list standar
         * yang hanya berisi daftar item
         * disusun dari atas ke bawah
         */
        layoutManager = new LinearLayoutManager(this);
        rvView.setLayoutManager(layoutManager);

        adapter = new RecyclerViewAdapter(dataSet);
        rvView.setAdapter(adapter);

        Button btnSecondActivity = findViewById(R.id.button_tambah);
        btnSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ActivitySecond.class);
                startActivity(intent);
            }
        });

            fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    // menyiapkan integer random dari 0 - 9
                    int i = new Random().nextInt(9 - 0 + 1);

                    // mengambil nama pada posisi random 0 - 9
                    String additional = addDataSet.get(i);

                    // memasukkan nama tersebut ke dalam
                    // daftar nama di RecyclerView
                    ((RecyclerViewAdapter)adapter).add(dataSet.size(), additional);

                    // membuat RecyclerView otomatis
                    // scroll ke bawah setelah nama baru ditambahkan
                    rvView.scrollToPosition(dataSet.size()-1);
                }
            });
        }

    }



    private void initDataset(){

        /**
         * Tambahkan item ke dataset
         * dalam prakteknya bisa bermacam2
         * tidak hanya String seperti di kasus ini
         */
        dataSet.add("Kumpul UKM");
        dataSet.add("Bayar Kemeja");
        dataSet.add("Desain Kaleidoskop");
        dataSet.add("Tabel HTML");
        dataSet.add("Desain ig");
        dataSet.add("Cari barang bekas");
        dataSet.add("Up followers");
        dataSet.add("Latihan");
        dataSet.add("Edit foto");
        dataSet.add("Watch miss americana");

    }
}