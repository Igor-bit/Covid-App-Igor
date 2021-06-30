package com.igorcordeiroszeremeta.coronavirusapp7;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SintomasGravissimos extends AppCompatActivity {

    CheckBox dificuldadesParaRespirar;
    CheckBox dorOuPressaoNoPeito;
    CheckBox perdaDeFalaOuPerdaDeMovimento;
    Button botaoPaginaAnterior4;
    Button botaoProximo4;
    TextView textoDoResultado4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.sintomasgravissimos);

        botaoProximo4 = findViewById(R.id.botaoProximo4);
        dificuldadesParaRespirar = findViewById(R.id.dificuldadesParaRespirar);
        dorOuPressaoNoPeito = findViewById(R.id.dorOuPressaoNoPeito);
        perdaDeFalaOuPerdaDeMovimento = findViewById(R.id.perdaDeFalaOuMovimento);
        botaoPaginaAnterior4 = findViewById(R.id.botaoPaginaAnterior4);
        textoDoResultado4 = findViewById(R.id.textoDoResultado4);

        botaoProximo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int resultado4 = 0;

                if (dificuldadesParaRespirar.isChecked()) {
                    resultado4 += 63;
                }
                if (dorOuPressaoNoPeito.isChecked()) {
                    resultado4 += 63;
                }
                if (perdaDeFalaOuPerdaDeMovimento.isChecked()) {
                    resultado4 += 63;
                }

                Intent intentRecebedora = getIntent();
                Bundle bundleRecebedor = intentRecebedora.getExtras();
                int resultado3 = bundleRecebedor.getInt("resultado3");
                resultado4 += resultado3;
                textoDoResultado4.setText(String.valueOf(resultado4));

                Intent intentEnviadora = new Intent(getApplicationContext(), Resultado.class);
                Bundle bundleEnviador = new Bundle();
                bundleEnviador.putInt("resultado4", resultado4);
                intentEnviadora.putExtras(bundleEnviador);
                startActivity(intentEnviadora);
                // Intent intent = new Intent(getApplicationContext(), Teste4.class);

            }
        });

        botaoPaginaAnterior4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), SintomasMediosEGraves.class);
                startActivity(intent);
            }
        });
    }
}