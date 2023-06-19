package com.example.tugasakhir;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MobilAdapter mobilAdapter;

    Button btMobil;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Mobil> mobilList = generateMobilList();
        mobilAdapter = new MobilAdapter(mobilList);
        recyclerView.setAdapter(mobilAdapter);

        btMobil = findViewById(R.id.btMobil);

//        btMobil.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, BookingActivity.class);
//                startActivity(intent);
//            }
//        });
    }

    private List<Mobil> generateMobilList() {
        List<Mobil> mobilList = new ArrayList<>();
        mobilList.add(new Mobil("Honda Civic", "Automatic/Manual", "Rp.200.000/hari"));
        mobilList.add(new Mobil("PPP", "manual", "123"));
        // Tambahkan data mobil lainnya sesuai kebutuhan
        return mobilList;
    }
}
