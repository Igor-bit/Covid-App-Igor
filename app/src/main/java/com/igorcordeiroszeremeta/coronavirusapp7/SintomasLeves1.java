package com.igorcordeiroszeremeta.coronavirusapp7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SintomasLeves1 extends AppCompatActivity {

    CheckBox tosseSeca;
    CheckBox cansaco;
    CheckBox doresEDesconfortos;

    Button botaoPaginaAnterior1;
    Button botaoProximo1;
    TextView textoDoResultado1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.sintomasleves1);

        botaoProximo1 = findViewById(R.id.botaoProximo4);
        tosseSeca = findViewById(R.id.tosseSeca);
        cansaco = findViewById(R.id.cansaco);
        doresEDesconfortos = findViewById(R.id.doresEDesconfortos);
        botaoPaginaAnterior1 = findViewById(R.id.botaoPaginaAnterior4);
        textoDoResultado1 = findViewById(R.id.textoDoResultado1);

        botaoProximo1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                int resultadoDaPrimeiraPagina = 0;

                if (tosseSeca.isChecked()) {
                    resultadoDaPrimeiraPagina += 1;
                }

                if (cansaco.isChecked()) {
                    resultadoDaPrimeiraPagina += 1;
                }

                if (doresEDesconfortos.isChecked()) {
                    resultadoDaPrimeiraPagina += 1;
                }
                textoDoResultado1.setText(String.valueOf(resultadoDaPrimeiraPagina));
                Intent intentEnviadora = new Intent(getApplicationContext(), SintomasLeves2.class);
                Bundle parametro = new Bundle();

                parametro.putInt("resultado1", resultadoDaPrimeiraPagina);
                intentEnviadora.putExtras(parametro);
                startActivity(intentEnviadora);

                //   Intent intent = new Intent(getApplicationContext(), Teste1.class);
            }
        });

        botaoPaginaAnterior1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity4.class);
                startActivity(intent);
            }
        });
    }
}