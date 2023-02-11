package com.example.infosharepreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtname, edtage, edtaddress, edtcontact;
    CheckBox chkrme;
    Button btnlogin;
    Button btnretrieve;
    SharedPreferences sharedPreferences;
    boolean ischkrme = false;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtname = findViewById(R.id.edtname);
        edtage = findViewById(R.id.edtage);
        edtaddress = findViewById(R.id.edtaddress);
        edtcontact = findViewById(R.id.edtcontact);
        chkrme = findViewById(R.id.chkrme);
        btnlogin = findViewById(R.id.btnlogin);
        btnretrieve = findViewById(R.id.btnretrieve);

        sharedPreferences = getSharedPreferences("SHARED_PREF", MODE_PRIVATE);
        ischkrme = sharedPreferences.getBoolean("RME", false);

        if (ischkrme) {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
            finish();
        }

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n = edtname.getText().toString();
                int ag = Integer.parseInt(edtage.getText().toString().trim());
                String ad = edtaddress.getText().toString();
                int c = Integer.parseInt(edtcontact.getText().toString().trim());
                boolean rme = chkrme.isChecked();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("NAME", n);
                editor.putInt("AGE", ag);
                editor.putString("ADDRESS", ad);
                editor.putInt("CONTACT NUMBER", c);
                editor.putBoolean("RME", rme);
                editor.apply();

                Toast.makeText(MainActivity.this, "Information Saved!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}