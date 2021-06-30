package com.igorcordeiroszeremeta.coronavirusapp7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Atividade1 extends AppCompatActivity {

    private Button botaoInicial1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        botaoInicial1 = findViewById(R.id.botaoInicial1);
        botaoInicial1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), Atividade2.class);
                startActivity(intent);
            }
        });
    }
}