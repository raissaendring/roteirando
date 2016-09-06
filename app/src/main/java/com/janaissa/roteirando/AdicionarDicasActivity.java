package com.janaissa.roteirando;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdicionarDicasActivity extends AppCompatActivity implements View.OnClickListener {
    EditText destino, tipo, dica;
    AlertDialog dialog;
    Button btnProx;

    String[] tipos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_dicas);

        destino = (EditText) findViewById(R.id.destino);
        tipo = (EditText) findViewById(R.id.tipo);
        dica = (EditText) findViewById(R.id.dica);
        btnProx = (Button) findViewById(R.id.btn_prox);

        tipos = getResources().getStringArray(R.array.tipos_dicas);

        btnProx.setOnClickListener(this);

        setTipos();
    }



    void setTipos() {
        dialog = new AlertDialog.Builder(this)
                .setTitle("Escolha o tipo de dica")
                .setItems(tipos, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tipo.setText(tipos[which]);

                        View view = getCurrentFocus();
                        if (view != null) {
                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                        }
                    }
                }).create();
        tipo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });
        tipo.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus)
                    dialog.show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        String destinoString = destino.getText().toString(),
                tipoString = tipo.getText().toString(),
                dicaString = dica.getText().toString();

        if(destinoString.isEmpty()){
            Toast.makeText(this,getString(R.string.msg_sem_destino),Toast.LENGTH_SHORT).show();
            return;
        }

        if(tipoString.equals(tipos[0])){
            intent = new Intent(this, AdicionarPontoTuristicoActivity.class);
        }else if(tipoString.equals(tipos[1])){
            intent = new Intent(this, AdicionarRestauranteActivity.class);
        }else{
            Toast.makeText(this,getString(R.string.msg_sem_tipo),Toast.LENGTH_SHORT).show();
            return;
        }

        if(dicaString.isEmpty()){
            Toast.makeText(this,getString(R.string.msg_sem_dica),Toast.LENGTH_SHORT).show();
            return;
        }

        intent.putExtra("destino",destinoString);
        intent.putExtra("dica",dicaString);

        startActivity(intent);


    }
}
