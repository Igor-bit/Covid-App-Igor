package com.igorcordeiroszeremeta.coronavirusapp7;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Atividade4 extends AppCompatActivity {

    private Button botaoPrincipal4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_principal4);

        botaoPrincipal4 = findViewById(R.id.botaoTeste4);
        botaoPrincipal4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SintomasLeves1.class);
                startActivity(intent);

            }
        });
    }
}