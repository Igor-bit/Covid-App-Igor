package com.igorcordeiroszeremeta.coronavirusapp7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Resultado extends AppCompatActivity {

    Button tratamento;
    Button botaoPrevencao1;
    Button resetar;
    TextView pontuacaoFinal;
    Button botaoSalvar;
    TextView teste;
    static String resultadoResumido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultado);

        tratamento = findViewById(R.id.tratamento);
        botaoPrevencao1 = findViewById(R.id.botaoPrevencao1);
        pontuacaoFinal = findViewById(R.id.pontuacaoFinal);
        botaoSalvar = findViewById(R.id.botaoSalvar);
        teste = findViewById(R.id.teste);
        resetar = findViewById(R.id.resetar);

        Intent intentRecebedora = getIntent();
        Bundle bundleRecebedor = intentRecebedora.getExtras();
        final int resultadoDoTeste = bundleRecebedor.getInt("resultado4");

        if (resultadoDoTeste >= 0 && resultadoDoTeste <= 3) {
            teste.setText(String.valueOf("Você apresenta sintomas leves. \nPor favor, se cuide."));
            resultadoResumido = "Sintomas Leves";

        } else if (resultadoDoTeste >= 4 && resultadoDoTeste <= 27) {
            teste.setText(String.valueOf("Você apresenta sintomas medianos. Por favor, tome cuidado. Em caso de piora, por favor, procure urgentemente uma unidade de saúde."));
            resultadoResumido = "Sintomas Médios";

        } else if (resultadoDoTeste >= 28 && resultadoDoTeste <= 78) {
            teste.setText(String.valueOf("Você apresenta sintomas graves. \nPor favor, vá para uma unidade de \nsaúde."));
            resultadoResumido = "Sintomas Graves";
        } else if (resultadoDoTeste > 78) {
            teste.setText(String.valueOf("Você apresenta sintomas gravíssimos. Por favor, procure o mais rápido \npossível uma unidade de saúde."));
            resultadoResumido = "Sintomas Gravíssimos";
        }

        pontuacaoFinal.setText(String.valueOf(resultadoDoTeste));
        //teste.setText(textoFinal);

        resetar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Por favor, aguarde até o teste ser reiniciado", Toast.LENGTH_LONG).show();
                teste.setText("");
                recreate();
                Intent intent = new Intent(getApplicationContext(), SintomasLeves1.class);
                startActivity(intent);

                CheckBox tosseSeca = findViewById(R.id.tosseSeca);
                if (tosseSeca.isChecked()) {
                    tosseSeca.setChecked(false);
                }

                CheckBox cansaco = findViewById(R.id.cansaco);
                if (cansaco.isChecked()) {
                    cansaco.setChecked(false);
                }

                CheckBox doresEDesconfortos = findViewById(R.id.doresEDesconfortos);
                if (doresEDesconfortos.isChecked()) {
                    doresEDesconfortos.setChecked(false);
                }

                CheckBox dorDeGarganta = findViewById(R.id.dorDeGarganta);
                if (dorDeGarganta.isChecked()) {
                    dorDeGarganta.setChecked(false);
                }

                CheckBox diarreia = findViewById(R.id.diarreia);
                if (diarreia.isChecked()) {
                    diarreia.setChecked(false);
                }

                CheckBox conjuntivite = findViewById(R.id.conjuntivite);
                if (conjuntivite.isChecked()) {
                    conjuntivite.setChecked(false);
                }

                CheckBox dorDeCabeca = findViewById(R.id.dorDeCabeca);
                if (dorDeCabeca.isChecked()) {
                    dorDeCabeca.setChecked(false);
                }

                CheckBox febre = findViewById(R.id.febre);
                if (febre.isChecked()) {
                    febre.setChecked(false);
                }

                CheckBox perdaDePaladarOuOlfato = findViewById(R.id.perdaDePaladarOuOlfato);
                if (perdaDePaladarOuOlfato.isChecked()) {
                    perdaDePaladarOuOlfato.setChecked(false);
                }

                CheckBox erupcaoCutanea = findViewById(R.id.erupcaoCutanea);
                if (erupcaoCutanea.isChecked()) {
                    erupcaoCutanea.setChecked(false);
                }

                CheckBox dificuldadesParaRespirar = findViewById(R.id.dificuldadesParaRespirar);
                if (dificuldadesParaRespirar.isChecked()) {
                    dificuldadesParaRespirar.setChecked(false);
                }

                CheckBox dorOuPressaoNoPeito = findViewById(R.id.dorOuPressaoNoPeito);
                if (dorOuPressaoNoPeito.isChecked()) {
                    dorOuPressaoNoPeito.setChecked(false);
                }

                CheckBox perdaDeFalaOuPerdaDeMovimento = findViewById(R.id.perdaDeFalaOuMovimento);
                if (perdaDeFalaOuPerdaDeMovimento.isChecked()) {
                    perdaDeFalaOuPerdaDeMovimento.setChecked(false);
                }
            }
        });

        botaoPrevencao1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Prevencao1.class);
                startActivity(intent);
            }
        });

        tratamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Tratamentos1.class);
                startActivity(intent);
            }
        });

        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intentEnviadora = new Intent(Resultado.this, CadastroDeUsuarios.class);
                Intent intentEnviadora = new Intent(getApplicationContext(), CadastroDeUsuarios1.class);
                Bundle bundleEnviador = new Bundle();
                bundleEnviador.putString("resultadoResumido", resultadoResumido);
                intentEnviadora.putExtras(bundleEnviador);
                startActivity(intentEnviadora);

                Toast.makeText(getApplicationContext(), "Foi enviado: " + resultadoResumido, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), CadastroDeUsuarios1.class);
                startActivity(intent);
            }
        });
    }
}