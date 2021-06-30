package com.igorcordeiroszeremeta.coronavirusapp7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CadastroDeUsuarios1 extends AppCompatActivity {

    EditText campoNome, campoDataDeNascimento, campoCidade;
    Button proximaPagina;
    String resultadoResumido;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastrodeusuario1);
        testando();
    }

    public void testando() {
        Intent intentRecebedora = getIntent();
        Bundle bundleRecebedor = intentRecebedora.getExtras();
        resultadoResumido = bundleRecebedor.getString("resultadoResumido");
        Toast.makeText(CadastroDeUsuarios1.this, "Recebendo o Resultado Resumido: " +resultadoResumido, Toast.LENGTH_LONG).show();

        campoNome = findViewById(R.id.campoNomeOficial);
        campoDataDeNascimento = findViewById(R.id.campoDataDeNascimento);
        campoCidade = findViewById(R.id.campoCidade);

        final String nome = campoNome.getText().toString();
        final String dataDeNascimentoEmString = campoDataDeNascimento.getText().toString();
        final String cidade = campoCidade.getText().toString();

        proximaPagina = findViewById(R.id.proximaPagina);

        proximaPagina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentEnviadora = new Intent(getApplicationContext(), CadastroDeUsuarios2.class);
                Bundle parametro = new Bundle();

                parametro.putString("nome", nome);
                parametro.putString("dataDeNascimentoEmString", dataDeNascimentoEmString);
                parametro.putString("cidade", cidade);

                intentEnviadora.putExtras(parametro);
                startActivity(intentEnviadora);
            }
        });
    }
}