package com.example.myconvert;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText etSuhu;
    Spinner Opsi;
    Button btnConvert, btnClear;
    LinearLayout layoutHasil;
    TextView tvHasilHitung, tvHasilConvert, tvRumus, tvRumusnya;
    private String Pilihan [] = {"-Convert Option", "\u00B0Celcius to Kelvin", "\u00B0Celcius to \u00B0Fahrenheit", "\u00B0Celcius to \u00B0Reamur",
    "Kelvin to \u00B0Celcius", "Kelvin to \u00B0Fahrenheit", "Kelvin to \u00B0Reamur", "\u00B0Fahrenheit to \u00B0Celcius", "\u00B0Fahrenheit to Kelvin",
    "\u00B0Fahrenheit to \u00B0Reamur", "\u00B0Reamur to \u00B0Celcius", "\u00B0Reamur to Kelvin", "\u00B0Reamur to \u00B0Fahrenheit"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        etSuhu = findViewById(R.id.etSuhu);
        Opsi = findViewById(R.id.Opsi);
        btnConvert = findViewById(R.id.btnConvert);
        btnClear = findViewById(R.id.btnClear);
        layoutHasil = findViewById(R.id.LayoutHasil);
        tvHasilConvert = findViewById(R.id.tvHasilConvert);
        tvHasilHitung = findViewById(R.id.tvHasilHitung);
        tvRumus = findViewById(R.id.tvRumus);
        tvRumusnya = findViewById(R.id.tvRumusnya);

        ArrayAdapter adapter = new ArrayAdapter(
                MainActivity.this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                Pilihan
        );

        Opsi.setAdapter(adapter);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etSuhu.setText("");
                tvHasilConvert.setText("");
                tvHasilHitung.setText("");
                tvRumusnya.setText("");
                tvRumus.setText("");

                if (layoutHasil.getVisibility() == View.VISIBLE) {
                    layoutHasil.setVisibility(View.GONE);
                }
            }
        });

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String getSuhu = etSuhu.getText().toString();

                if (getSuhu.isEmpty()){
                    Toast.makeText(MainActivity.this, "Maaf, Silahkan isi Suhu Awal Terlebih Dahulu", Toast.LENGTH_SHORT).show();
                } else {
                    if (layoutHasil.getVisibility() == View.GONE) {
                        layoutHasil.setVisibility(View.VISIBLE);
                    }

                    double suhu = Double.valueOf(etSuhu.getText().toString());
                    double hasil;
                    String rumus, rumus1;
                    int Spinner = Opsi.getSelectedItemPosition();
                    switch (Spinner) {
                        case 0 :
                            if (layoutHasil.getVisibility() == View.VISIBLE) {
                                layoutHasil.setVisibility(View.GONE);
                            }
                            Toast.makeText(MainActivity.this, "Maaf, Silahkan Pilih Opsi Convert!", Toast.LENGTH_SHORT).show();
                            break;
                        case 1 : // celcius to kelvin
                            hasil = suhu + 273;
                            rumus = "Celcius + 273";
                            rumus1 = suhu + " + 273";
                            tvHasilConvert.setText("Hasil Convert = " + String.valueOf(hasil));
                            tvRumus.setText("Rumus : ");
                            tvRumusnya.setText("= " +rumus+ "\n= " +rumus1+ "\n= " +hasil);
                            break;
                        case 2 : // celcius to fahrenheit
                            hasil = 9.0/5.0 * suhu + 32;
                            rumus = "9.0/5.0 * Celcius + 32";
                            rumus1 = "9.0/5.0 * " + suhu + " + 32";
                            tvHasilConvert.setText("Hasil Convert = " + String.valueOf(hasil));
                            tvRumus.setText("Rumus : ");
                            tvRumusnya.setText("= " +rumus+ "\n= " +rumus1+ "\n= " +hasil);
                            break;
                        case 3 : // celcius to reamur
                            hasil = 4.0/5.0 * suhu;
                            rumus = "4.0/5.0 * Celcius";
                            rumus1 = "4.0/5.0 * " + suhu;
                            tvHasilConvert.setText("Hasil Convert = " + String.valueOf(hasil));
                            tvRumus.setText("Rumus : ");
                            tvRumusnya.setText("= " +rumus+ "\n= " +rumus1+ "\n= " +hasil);
                            break;
                        case 4 : // kelvin to celcius
                            hasil = suhu - 273.15;
                            rumus = "Kelvin - 273.15";
                            rumus1 = suhu + " - 273.15";
                            tvHasilConvert.setText("Hasil Convert = " + String.valueOf(hasil));
                            tvRumus.setText("Rumus : ");
                            tvRumusnya.setText("= " +rumus+ "\n= " +rumus1+ "\n= " +hasil);
                            break;
                        case 5 : // kelvin to fahrenheit
                            hasil = (suhu * 9.0/5.0) - 459.67;
                            rumus = "(Kelvin * 9.0/5.0) - 459.67";
                            rumus1 = "(" + suhu + " * 9.0/5.0) - 459.67";
                            tvHasilConvert.setText("Hasil Convert = " + String.valueOf(hasil));
                            tvRumus.setText("Rumus : ");
                            tvRumusnya.setText("= " +rumus+ "\n= " +rumus1+ "\n= " +hasil);
                            break;
                        case 6 : // kelvin to reamur
                            hasil = 4.0/5.0 * (suhu - 273);
                            rumus = "4.0/5.0 * (kelvin - 273)";
                            rumus1 = "4.0/5.0 * ("+ suhu + " - 273)";
                            tvHasilConvert.setText("Hasil Convert = " + String.valueOf(hasil));
                            tvRumus.setText("Rumus : ");
                            tvRumusnya.setText("= " +rumus+ "\n= " +rumus1+ "\n= " +hasil);
                            break;
                        case 7 : // fahrenheit to celcius
                            hasil = (suhu - 32) * 5.0/9.0;
                            rumus = "(Fahrenheit - 32) * 5.0/9.0";
                            rumus1 = "(" + suhu + " - 32) * 5.0/9.0";
                            tvHasilConvert.setText("Hasil Convert = " + String.valueOf(hasil));
                            tvRumus.setText("Rumus : ");
                            tvRumusnya.setText("= " +rumus+ "\n= " +rumus1+ "\n= " +hasil);
                            break;
                        case 8 : // fahrenheit to kelvin
                            hasil = (suhu + 459.67) * 5.0/9.0;
                            rumus = "(Fahrenheit + 459.67) * 5.0/9.0";
                            rumus1 = "(" + suhu + " + 459.67) * 5.0/9.0";
                            tvHasilConvert.setText("Hasil Convert = " + String.valueOf(hasil));
                            tvRumus.setText("Rumus : ");
                            tvRumusnya.setText("= " +rumus+ "\n= " +rumus1+ "\n= " +hasil);
                            break;
                        case 9 : // fahrenheit to reamur
                            hasil = 4.0/9.0 * (suhu - 32);
                            rumus = "4.0/9.0 * (fahrenheit - 32)";
                            rumus1 ="4.0/9.0 * ("+ suhu + " - 32)";
                            tvHasilConvert.setText("Hasil Convert = " + String.valueOf(hasil));
                            tvRumus.setText("Rumus : ");
                            tvRumusnya.setText("= " +rumus+ "\n= " +rumus1+ "\n= " +hasil);
                            break;
                        case 10 : // reamur to celcius
                            hasil = suhu / 0.8;
                            rumus = "°reamur / 0.8";
                            rumus1 = suhu + "/ 0.8";
                            tvHasilConvert.setText("Hasil Convert = " + String.valueOf(hasil));
                            tvRumus.setText("Rumus : ");
                            tvRumusnya.setText("= " +rumus+ "\n= " +rumus1+ "\n= " +hasil);
                            break;
                        case 11 : // reamur to kelvin
                            hasil = (suhu / 0.8) + 273.15;
                            rumus = "(reamur / 0.8) + 273.15";
                            rumus1 = "(" + suhu + " / 0.8) + 273.15";
                            tvHasilConvert.setText("Hasil Convert = " + String.valueOf(hasil));
                            tvRumus.setText("Rumus : ");
                            tvRumusnya.setText("= " +rumus+ "\n= " +rumus1+ "\n= " +hasil);
                            break;
                        case 12 : // reamur to fahrenheit
                            hasil = (suhu * 2.25) + 32;
                            rumus = "(reamur * 2.25) + 32";
                            rumus1 = "(" + suhu + " * 2.25) + 32";
                            tvHasilConvert.setText("Hasil Convert = " + String.valueOf(hasil));
                            tvRumus.setText("Rumus : ");
                            tvRumusnya.setText("= " +rumus+ "\n= " +rumus1+ "\n= " +hasil);
                            break;
                    }
                }
            }
        });

    }
}