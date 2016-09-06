package com.janaissa.roteirando;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AdicionarPontoTuristicoActivity extends AppCompatActivity {
    TextView destino, dica;

    String destinoString, dicaString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_ponto_turistico);

        destino = (TextView) findViewById(R.id.destino);
        dica = (TextView) findViewById(R.id.dica);

        setInfo();

    }

    void setInfo(){
        Intent intent = getIntent();
        destinoString = intent.getStringExtra("destino");
        dicaString = intent.getStringExtra("dica");
        if(destinoString!=null && dicaString!=null){
            destino.setText(destinoString);
            dica.setText("Ponto turístico: " + dicaString);
        }
    }
}
