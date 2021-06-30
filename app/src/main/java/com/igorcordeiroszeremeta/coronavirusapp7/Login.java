package com.igorcordeiroszeremeta.coronavirusapp7;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

public class Login extends AppCompatActivity {
    EditText mEmail, mPassword;
    Button mLoginBtn, mCreateBtn, button3, forgotTextLink;
    //ProgressBar progressBar;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmail = findViewById(R.id.email);
        mPassword = findViewById(R.id.password);
        //progressBar = findViewById(R.id.progressBar);
        fAuth = FirebaseAuth.getInstance();
        mLoginBtn = findViewById(R.id.loginBtn);
        mCreateBtn = findViewById(R.id.createText);
        forgotTextLink = findViewById(R.id.forgotTextLink);


        mLoginBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "O botão de login foi clicado",  Toast.LENGTH_LONG).show();
                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(Login.this, "O campo do e-mail está vazio", Toast.LENGTH_LONG).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(Login.this, "O campo da senha está vazio", Toast.LENGTH_LONG).show();
                    return;
                }

                if (password.length() < 6) {
                    Toast.makeText(getApplicationContext(), "A senha deve ser maior ou igual a 6 caracteres", Toast.LENGTH_LONG).show();
                    return;
                }
//                progressBar.setVisibility(View.VISIBLE);

                // authenticate the user
                fAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(Login.this, "Você foi logado com sucesso!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplication(), MainActivity0.class));
                        } else {
                            Toast.makeText(Login.this, "Erro! " + ((FirebaseAuthException)task.getException()).getErrorCode(), Toast.LENGTH_LONG).show();
//                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });

       /*
       ((FirebaseAuthException)task.getException()).getErrorCode()
        */

        mCreateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Registro.class));
            }
        });

        forgotTextLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText resetMail = new EditText(v.getContext());
                AlertDialog.Builder passwordResetDialog =  new AlertDialog.Builder(v.getContext());
                passwordResetDialog.setTitle("Resetar a Senha");
                passwordResetDialog.setMessage("Digite o seu E-mail para ter o link para resetar a senha");
                passwordResetDialog.setView(resetMail);

                passwordResetDialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // extrai o e-mail e envia o link para resetar
                        String mail = resetMail.getText().toString();
                        fAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(Login.this, "O link de Resetar foi enviado para o seu E-mail", Toast.LENGTH_LONG).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Login.this, "Erro! O link para resetar não foi enviado" + e.getMessage(), Toast.LENGTH_LONG).show();

                            }
                        });

                    }
                });

                passwordResetDialog.setNegativeButton("Não", new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // fecha o dialog
                    }
                });
                passwordResetDialog.create().show();
            }
        });
    }
}