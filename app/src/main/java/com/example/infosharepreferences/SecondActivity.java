package com.example.infosharepreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView stvname, stvage, stvaddress, stvcontact;
    Button sbtnlogout;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        stvname = findViewById(R.id.stvname);
        stvage = findViewById(R.id.stvage);
        stvaddress = findViewById(R.id.stvaddress);
        stvcontact = findViewById(R.id.stvcontact);
        sbtnlogout = findViewById(R.id.sbtnlogout);

        sharedPreferences = getSharedPreferences("SHARED_PREF", MODE_PRIVATE);
        boolean ischkrme = sharedPreferences.getBoolean("RME", false);

        String sname = sharedPreferences.getString("NAME", "");
        stvname.setText(sname);
        int sage = sharedPreferences.getInt("AGE",0);
        stvage.setText(""+sage);
        String saddress = sharedPreferences.getString("ADDRESS","");
        stvaddress.setText(saddress);
        int scontact = sharedPreferences.getInt("CONTACT NUMBER", 0);
        stvcontact.setText(""+scontact);

        sbtnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                if (!ischkrme) {
                    editor.clear();
                }
                editor.apply();
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
