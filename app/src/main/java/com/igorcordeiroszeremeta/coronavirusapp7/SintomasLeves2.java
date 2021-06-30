package com.igorcordeiroszeremeta.coronavirusapp7;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SintomasLeves2 extends AppCompatActivity {

    CheckBox dorDeGarganta;
    CheckBox diarreia;
    CheckBox dorDeCabeca;

    Button botaoPaginaAnterior2;
    Button botaoProximo2;
    TextView textoDoResultado2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        //  int resultado1 = parametros.getInt("resultado1");

        setContentView(R.layout.sintomasleves2);

        botaoProximo2 = findViewById(R.id.botaoProximo2);

        dorDeGarganta = findViewById(R.id.dorDeGarganta);
        diarreia = findViewById(R.id.diarreia);
        dorDeCabeca = findViewById(R.id.dorDeCabeca);
        botaoPaginaAnterior2 = findViewById(R.id.botaoPaginaAnterior2);
        textoDoResultado2 = findViewById(R.id.textoDoResultado2);

        botaoProximo2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                int resultado2 = 0;

                if (dorDeGarganta.isChecked()) {
                    resultado2 += 1;
                }

                if (diarreia.isChecked()) {
                    resultado2 += 1;
                }

                if (dorDeCabeca.isChecked()) {
                    resultado2 += 1;
                }

                Intent intentRecebedora = getIntent();
                Bundle bundleRecebedor = intentRecebedora.getExtras();
                int resultado1 = bundleRecebedor.getInt("resultado1");
                resultado2 += resultado1;
                textoDoResultado2.setText(String.valueOf(resultado2));

                Intent intentEnviadora = new Intent(getApplicationContext(), SintomasMediosEGraves.class);
                Bundle bundleEnviador = new Bundle();
                bundleEnviador.putInt("resultado2", resultado2);
                intentEnviadora.putExtras(bundleEnviador);
                startActivity(intentEnviadora);
                //  Intent intent = new Intent(getApplicationContext(), Teste2.class);
            }
        });

        botaoPaginaAnterior2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SintomasLeves1.class);
                startActivity(intent);
            }
        });
    }
}