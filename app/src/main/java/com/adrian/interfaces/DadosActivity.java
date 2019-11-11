package com.adrian.interfaces;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class DadosActivity extends AppCompatActivity implements View.OnClickListener {

    private Button idbuttontirar;
    private ImageView idimgdados;
    ArrayList<Integer> Dados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados);
        Dados = new ArrayList<>();
        instancias();
        acciones();
    }
    private void instancias(){
        idbuttontirar = findViewById(R.id.idbuttontirar);
        idimgdados = findViewById(R.id.idimgdados);
        Dados.add(1);
        Dados.add(2);
        Dados.add(3);
        Dados.add(4);
        Dados.add(5);
        Dados.add(6);
        Integer elegido = Dados.get(new Random().nextInt(Dados.size()));
        elegirDado(elegido);
    }
    private void acciones(){
        idbuttontirar.setOnClickListener(this);
    }

    public void elegirDado(Integer elegido){
        switch (elegido) {
            case 1:
                idimgdados.setImageResource(R.drawable.dado_uno);
                break;
            case 2:
                idimgdados.setImageResource(R.drawable.dado_dos);
                break;
            case 3:
                idimgdados.setImageResource(R.drawable.dado_tres);
                break;
            case 4:
                idimgdados.setImageResource(R.drawable.dado_cuatro);
                break;
            case 5:
                idimgdados.setImageResource(R.drawable.dado_cinco);
                break;
            case 6:
                idimgdados.setImageResource(R.drawable.dado_seis);
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.idbuttontirar:
                System.out.println("Tirando dado...");
                Integer elegido = Dados.get(new Random().nextInt(Dados.size()));
                elegirDado(elegido);
                break;
        }
    }
}
