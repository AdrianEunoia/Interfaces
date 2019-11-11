package com.adrian.interfaces;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // Var
    private ImageButton iddices, idshuffle, idpremio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
    }
    private void acciones(){
        iddices.setOnClickListener(this);
        idshuffle.setOnClickListener(this);
        idpremio.setOnClickListener(this);
    }
    private void instancias (){
        iddices = findViewById(R.id.iddices);
        idpremio = findViewById(R.id.idpremio);
        idshuffle = findViewById(R.id.idshuffle);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iddices:
                System.out.println("Iniciando actividad dados");
                Intent actividadDados = new Intent(getApplicationContext(),DadosActivity.class);
                startActivity(actividadDados);
                break;
            case R.id.idshuffle:
                System.out.println("Iniciando actividad cohete");
                Intent actividadAleatorios = new Intent(getApplicationContext(),AleatoriosActivity.class);
                startActivity(actividadAleatorios);
                break;
            case R.id.idpremio:
                System.out.println("Iniciando actividad premio");
                Intent actividadGanador = new Intent(getApplicationContext(),GanadorActivity.class);
                startActivity(actividadGanador);
                break;
        }

    }
}
