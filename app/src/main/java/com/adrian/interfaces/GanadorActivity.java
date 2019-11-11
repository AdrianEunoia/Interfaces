package com.adrian.interfaces;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class GanadorActivity extends AppCompatActivity implements View.OnClickListener {
    private Button idbtnagregar, idbtngenerar;
    private EditText idedittextnombre;
    private TextView idtextviewlista;
    ArrayList<String> Nombres;
    private boolean flagGanador = false;
    private boolean limpiarArray= false;
    private boolean generarGanador = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ganador);
        instancias();
        acciones();
        Nombres = new ArrayList<>();
    }
    private void acciones(){
        idbtnagregar.setOnClickListener(this);
        idbtngenerar.setOnClickListener(this);
    }
    private void instancias (){
        idbtngenerar = findViewById(R.id.idbtngenerar);
        idbtnagregar = findViewById(R.id.idbtnagregar);
        idedittextnombre = findViewById(R.id.idedittextnombre);
        idtextviewlista = findViewById(R.id.idtextviewlista);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.idbtnagregar:
                if (!flagGanador) {
                    System.out.println("Agregando...");
                    Nombres.add(idedittextnombre.getText().toString());
                    idtextviewlista.append(" \n");
                    idtextviewlista.append(idedittextnombre.getText().toString());
                    idedittextnombre.setText("");
                    generarGanador=true;
                }else {
                    idtextviewlista.setText("");
                    System.out.println("Agregando...");
                    Nombres.add(idedittextnombre.getText().toString());
                    idtextviewlista.append(" \n");
                    idtextviewlista.append(idedittextnombre.getText().toString());
                    idedittextnombre.setText("");
                    flagGanador=false;
                    generarGanador=true;
                }
                break;
            case R.id.idbtngenerar:
                if(generarGanador){
                    System.out.println("Generando...");
                    String elegido = Nombres.get(new Random().nextInt(Nombres.size()));
                    idtextviewlista.setText(elegido);
                    flagGanador=true;
                    if(!limpiarArray){
                        Nombres.clear();
                        limpiarArray=true;
                        generarGanador=false;
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Debes introducir concursantes para poder obtener un ganador", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}

