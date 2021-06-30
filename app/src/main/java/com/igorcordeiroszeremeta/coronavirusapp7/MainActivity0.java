package com.igorcordeiroszeremeta.coronavirusapp7;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseError;

public class MainActivity0 extends AppCompatActivity {

    private static final String TAG = null;
    private Button botaoInicial1;
    private Button botaoInicial2;
    private FirebaseAuth mAuth;
    DataSnapshot dataSnapshot;
    DatabaseError error;

    /*
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("message");

    myRef.setValue("Hello, World!");

     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main0);

        botaoInicial1 = findViewById(R.id.botaoInicial1);
        botaoInicial1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), MainActivity1.class);
                startActivity(intent);
            }
        });

        botaoInicial2 = findViewById(R.id.botaoInicial2);
        botaoInicial2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), SintomasLeves1.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser usuarioAtual = mAuth.getCurrentUser();
        //atualizaInterfaceGrafica(usuarioAtual);
    }

    // Read from the database
    /*
    myRef.addValueEventListener(new void ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot){
            // This method is called once with the initial value and again
            // whenever data at this location is updated.
            String value = dataSnapshot.getValue(String.class);
            Log.d(TAG, "Value is: " + value);
        }
    }
     */
    public void onCancelled(DatabaseError error) {
        // Failed to read value
        Log.w(TAG, "Falhou", error.toException());
    }
}