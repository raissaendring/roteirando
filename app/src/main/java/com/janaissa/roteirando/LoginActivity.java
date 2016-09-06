package com.janaissa.roteirando;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnEntrar, btnCadastrar, btnSemLogar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnEntrar = (Button) findViewById(R.id.btn_entrar);
        btnCadastrar = (Button) findViewById(R.id.btn_cadastrar);
        btnSemLogar = (Button) findViewById(R.id.btn_entrar_sem_logar);

        btnEntrar.setOnClickListener(this);
        btnCadastrar.setOnClickListener(this);
        btnSemLogar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.btn_entrar:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_cadastrar:
                break;
            case R.id.btn_entrar_sem_logar:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}
