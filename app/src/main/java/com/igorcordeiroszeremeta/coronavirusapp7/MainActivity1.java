package com.igorcordeiroszeremeta.coronavirusapp7;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity1 extends AppCompatActivity {

    private Button botaoPrincipal1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        botaoPrincipal1 = findViewById(R.id.botao1);
        botaoPrincipal1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* Intent intent = new Intent(getApplicationContext(), MainActivity2.class); */
                Intent intent = new Intent(getApplication(), MainActivity2.class);
                startActivity(intent);
            }
        });
    }
}