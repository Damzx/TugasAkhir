package com.example.tugasakhir;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class KonfirmasiActivity extends AppCompatActivity {

    private Button buttonKonfirmasi;
    private EditText editTextLokasi;
    private Switch switchSopir;
    private CalendarView calendarView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konfirmasi);

        buttonKonfirmasi = findViewById(R.id.button4);
        editTextLokasi = findViewById(R.id.etLokasi);
        switchSopir = findViewById(R.id.swSopir);
        calendarView = findViewById(R.id.calendarView);

        buttonKonfirmasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Menampilkan pop-up berhasil dipesan
                showSuccessDialog();

                // Menyimpan semua data
                saveData();
            }
        });

        // Menerima data dari Intent
        Bundle data = getIntent().getExtras();
        if (data != null) {
            String lokasi = data.getString("lokasi");
            boolean sopir = data.getBoolean("sopir");
            long tanggal = data.getLong("tanggal");

            // Menampilkan data pada EditText, Switch, dan CalendarView
            editTextLokasi.setText(lokasi);
            switchSopir.setChecked(sopir);
            calendarView.setDate(tanggal);
        }
    }

    private void showSuccessDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Berhasil");
        builder.setMessage("Pesanan Anda telah berhasil diproses.");
        builder.setPositiveButton("OK", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void saveData() {
        // Mengambil data dari EditText, Switch, dan CalendarView
        String lokasi = editTextLokasi.getText().toString();
        boolean sopir = switchSopir.isChecked();
        long tanggal = calendarView.getDate();

        // Implementasikan logika penyimpanan data di sini
        // Misalnya, simpan data ke database atau lakukan tindakan lainnya

        Toast.makeText(this, "Data berhasil disimpan", Toast.LENGTH_SHORT).show();
    }
}
