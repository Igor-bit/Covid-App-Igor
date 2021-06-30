package com.igorcordeiroszeremeta.coronavirusapp7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Prevencao1 extends AppCompatActivity {
    private Button botaoPrevencao1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prevencao1);

        botaoPrevencao1 = findViewById(R.id.botaoPrevencao2);
        botaoPrevencao1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Prevencao2.class);
                startActivity(intent);
            }
        });
    }
}