package com.example.sqllite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.sqllite.database.DBController;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;

public class TemanBaru extends AppCompatActivity {
    private TextInputEditText tNama, tTelepon;
    private Button simpanBtn;
    String nm, tlp;
    DBController controller = new DBController(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teman_baru);

        tNama = (TextInputEditText)findViewById(R.id.tietNama);
        tTelepon = (TextInputEditText)findViewById(R.id.tietTelepon);
        simpanBtn = (Button)findViewById(R.id.buttonSave);

        simpanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tNama.getText().toString().equals("")||tTelepon.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Data Belum Komplit !", Toast.LENGTH_SHORT).show();
                } else {
                    nm = tNama.getText().toString();
                    tlp = tTelepon.getText().toString();

                    HashMap<String, String> qvalues =  new HashMap<>();
                    qvalues.put("Nama", nm);
                    qvalues.put("Telepon", tlp);

                    controller.InsertData(qvalues);
                    callHome();
                }
            }
        });
    }

    public void callHome() {
        Intent intent = new Intent(TemanBaru.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}