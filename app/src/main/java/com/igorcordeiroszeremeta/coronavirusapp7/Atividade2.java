package com.igorcordeiroszeremeta.coronavirusapp7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Atividade2 extends AppCompatActivity {

    private Button botaoPrincipal2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        botaoPrincipal2 = findViewById(R.id.botao2);
        botaoPrincipal2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Atividade3.class);
                startActivity(intent);
            }
        });
    }
}