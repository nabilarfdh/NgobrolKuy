package com.responsi.ngobrolkuy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    private TextView tvsudahpunyaakun;
    private TextView tvregister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        tvsudahpunyaakun = findViewById(R.id.sudahpunyaakun);
        tvregister = findViewById(R.id.register);

        tvsudahpunyaakun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(pindah);
            }

        });

        tvregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(RegisterActivity.this, ProfilePicActivity.class);
                startActivity(pindah);
            }

        });
    }
}