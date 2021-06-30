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

import java.text.SimpleDateFormat;
import java.util.Date;

public class CadastroDeUsuarios2 extends AppCompatActivity {

    EditText campoGenero, campoEtnia, campoCpf;
    Button salvar;
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
        Toast.makeText(CadastroDeUsuarios2.this, "Recebendo o Resultado Resumido: " +resultadoResumido, Toast.LENGTH_LONG).show();


        campoGenero = findViewById(R.id.campoGenero);
        campoEtnia = findViewById(R.id.campoEtnia);
        campoCpf = findViewById(R.id.campoCPF);

        salvar = findViewById(R.id.salvarNoBancoDeDados);

        //Salvar os dados no Firebase
        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    rootNode = FirebaseDatabase.getInstance();
                    //    reference = rootNode.getReference("usuarios");
                    // reference = rootNode.getReference("users");

                    // Pega todos os valores

                    Intent intentRecebedora = getIntent();
                    Bundle bundleRecebedor = intentRecebedora.getExtras();
                    String nome = bundleRecebedor.getString("nome");
                    String dataDeNascimentoEmString = bundleRecebedor.getString("dataDeNascimentoEmString");
                    Date dataDeNascimento = new SimpleDateFormat("dd/MMMM/yyyy").parse(dataDeNascimentoEmString);
                    String cidade = bundleRecebedor.getString("cidade");

                    String genero = campoGenero.getText().toString();
                    String etnia = campoEtnia.getText().toString();
                    String cpfEmString = campoCpf.getText().toString();
                    int cpf = Integer.parseInt(cpfEmString);

                    ClasseAuxiliar classeAuxiliar = new ClasseAuxiliar(nome, dataDeNascimento, cidade, genero, etnia, cpf, resultadoResumido);
                    DatabaseReference studentDbRef = FirebaseDatabase.getInstance().getReference().child("usuarios");
                    classeAuxiliar.setNome(nome);
                    classeAuxiliar.setDataDeNascimento(dataDeNascimento);
                    classeAuxiliar.setCidade(cidade);
                    classeAuxiliar.setGenero(genero);
                    classeAuxiliar.setEtnia(etnia);
                    classeAuxiliar.setCpf(cpf);
                    classeAuxiliar.setResultadoResumido(resultadoResumido);

                    studentDbRef.push().setValue(classeAuxiliar);
                    //reference.child(nome).setValue(classeAuxiliar);

                    Toast.makeText(getApplication(), "Os dados foram armazenados no Banco de Dados! Você já pode voltar.", Toast.LENGTH_LONG).show();
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}