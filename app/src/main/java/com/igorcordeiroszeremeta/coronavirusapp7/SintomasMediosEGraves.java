package com.igorcordeiroszeremeta.coronavirusapp7;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SintomasMediosEGraves extends AppCompatActivity {

    CheckBox febre;
    CheckBox perdaDePaladarOuOlfato;
    CheckBox conjuntivite;
    CheckBox erupcaoCutanea;

    Button botaoPaginaAnterior3;
    Button botaoProximo3;
    TextView textoDoResultado3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.sintomasmediosegraves);

        botaoProximo3 = findViewById(R.id.botaoProximo3);

        febre = findViewById(R.id.febre);
        perdaDePaladarOuOlfato = findViewById(R.id.perdaDePaladarOuOlfato);
        conjuntivite = findViewById(R.id.conjuntivite);
        erupcaoCutanea = findViewById(R.id.erupcaoCutanea);

        botaoPaginaAnterior3 = findViewById(R.id.botaoPaginaAnterior3);

        botaoProximo3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                textoDoResultado3 = findViewById(R.id.textoDoResultado3);
                int resultado3 = 0;

                if(febre.isChecked()) {
                    resultado3 += 7;
                }

                if(perdaDePaladarOuOlfato.isChecked()) {
                    resultado3 += 7;
                }

                if(conjuntivite.isChecked()) {
                    resultado3 += 21;
                }

                if(erupcaoCutanea.isChecked()) {
                    resultado3 += 21;;
                }

                Intent intentRecebedora = getIntent();
                Bundle bundleRecebedor = intentRecebedora.getExtras();
                int resultado2 = bundleRecebedor.getInt("resultado2");
                resultado3 += resultado2;
                textoDoResultado3.setText(String.valueOf(resultado3));

                Intent intentEnviadora = new Intent(getApplicationContext(), SintomasGravissimos.class);
                Bundle bundleEnviador = new Bundle();
                bundleEnviador.putInt("resultado3", resultado3);
                intentEnviadora.putExtras(bundleEnviador);
                startActivity(intentEnviadora);
                // Intent intent = new Intent(getApplicationContext(), Teste3.class);
            }
        });

        botaoPaginaAnterior3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SintomasLeves2.class);
                startActivity(intent);
            }
        });
    }
}