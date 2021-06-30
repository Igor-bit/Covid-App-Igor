package com.igorcordeiroszeremeta.coronavirusapp7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    private Button botaoPrincipal3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        botaoPrincipal3 = findViewById(R.id.botao3);
        botaoPrincipal3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), MainActivity4.class);
                startActivity(intent);
            }
        });
    }
}