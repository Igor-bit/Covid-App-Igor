package com.igorcordeiroszeremeta.coronavirusapp7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity4 extends AppCompatActivity {

    private Button botao4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        botao4 = findViewById(R.id.botao4);
        botao4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), SintomasLeves1.class);
                startActivity(intent);
            }
        });
    }
}