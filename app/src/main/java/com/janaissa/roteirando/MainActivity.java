package com.janaissa.roteirando;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Toolbar toolbar;
    LinearLayout criarRoteiro, addDicas, meusRoteiros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        criarRoteiro = (LinearLayout) findViewById(R.id.criar_roteiro);
        addDicas = (LinearLayout) findViewById(R.id.add_dicas);
        meusRoteiros = (LinearLayout) findViewById(R.id.meus_roteiros);

        criarRoteiro.setOnClickListener(this);
        addDicas.setOnClickListener(this);
        meusRoteiros.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.add_dicas:
                intent = new Intent(this,AdicionarDicasActivity.class);
                startActivity(intent);
                break;
        }
    }
}
