package com.igorcordeiroszeremeta.coronavirusapp7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Tratamentos1 extends AppCompatActivity {
    Button botaoTratamentos1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tratamentos1);

        botaoTratamentos1 = findViewById(R.id.botaoTratamentos1);

        botaoTratamentos1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), Tratamentos2.class);
                startActivity(intent);
            }
        });
    }
}