package com.adrian.interfaces;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class AleatoriosActivity extends AppCompatActivity implements View.OnClickListener {
    private CheckBox idchecksinrango,idcheckconrango,idcheckdecimales;
    private EditText idedittextminimo,idedittextmaximo,idedittextdecimales,idedittextnumerostotales;
    private Switch idswitchrepetir;
    private ImageButton idcohete;
    private LinearLayout layoutprincipal;
    private TextView idtextviewagregar;
    ArrayList<Integer> Aleatorios;
    ArrayList<Double> AleatoriosDobles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aleatorios);
        Aleatorios = new ArrayList<>();
        AleatoriosDobles = new ArrayList<>();
        instancias();
        acciones();
    }
    private void instancias (){
        idchecksinrango = findViewById(R.id.idchecksinrango);
        idcheckconrango = findViewById(R.id.idcheckconrango);
        idcheckdecimales = findViewById(R.id.idcheckdecimales);
        idedittextdecimales = findViewById(R.id.idedittextdecimales);
        idedittextmaximo = findViewById(R.id.idedittextmaximo);
        idedittextminimo = findViewById(R.id.idedittextminimo);
        idedittextnumerostotales = findViewById(R.id.idedittextnumerostotales);
        idswitchrepetir = findViewById(R.id.idswitchrepetir);
        idcohete = findViewById(R.id.idcohete);
        layoutprincipal = findViewById(R.id.layoutprincipal);
        idedittextminimo.setEnabled(false);
        idedittextmaximo.setEnabled(false);
        idedittextdecimales.setEnabled(false);
        idtextviewagregar = findViewById(R.id.idtextviewagregar);
    }
    private void acciones(){
        idcohete.setOnClickListener(this);
        idcheckconrango.setOnClickListener(this);
        idchecksinrango.setOnClickListener(this);
        idcheckdecimales.setOnClickListener(this);
        idswitchrepetir.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.idcohete:
                AleatoriosDobles.clear();
                Aleatorios.clear();
                idtextviewagregar.setText("");
                if(idcheckdecimales.isChecked() && idedittextdecimales.getText().toString().trim().length() > 0){
                    if (idedittextnumerostotales.getText().toString().trim().length() <= 0){
                        Toast.makeText(getApplicationContext(), "Debes introducir un número de aleatorios a generar", Toast.LENGTH_SHORT).show();
                    } else {
                        System.out.println("Cohete");
                        if (idchecksinrango.isChecked() && idcheckdecimales.isChecked() && idswitchrepetir.isChecked()) {
                            System.out.println("Generando aleatorios sin rango y con decimales repitiendo");
                            int numeroDecimales = Integer.valueOf(idedittextdecimales.getText().toString());
                            int numeroTotalAleatorios = Integer.valueOf(idedittextnumerostotales.getText().toString());
                            for (int i = 0; i < numeroTotalAleatorios; i++) {
                                double randomDoble = new Random().nextDouble();
                                double numeroRandom = Double.parseDouble(String.format("%." + numeroDecimales + "f", randomDoble));
                                AleatoriosDobles.add(numeroRandom);
                                idtextviewagregar.append((String.valueOf(numeroRandom)).concat(", "));
                            }
                        } else if (idchecksinrango.isChecked() && idcheckdecimales.isChecked() && !idswitchrepetir.isChecked()) {
                            System.out.println("Generando aleatorios sin rango y con decimales sin repetir");
                            int numeroDecimales = Integer.valueOf(idedittextdecimales.getText().toString());
                            int numeroTotalAleatorios = Integer.valueOf(idedittextnumerostotales.getText().toString());
                            for (int i = 0; i < numeroTotalAleatorios; i++) {
                                double randomDoble = new Random().nextDouble();
                                double numeroRandom = Double.parseDouble(String.format("%."+numeroDecimales+"f", randomDoble));
                                if (!AleatoriosDobles.contains(numeroRandom)) {
                                    AleatoriosDobles.add(numeroRandom);
                                    idtextviewagregar.append((String.valueOf(numeroRandom)).concat(", "));
                                } else {
                                    i--;
                                }
                            }
                        } else if (idchecksinrango.isChecked() && !idcheckdecimales.isChecked() && idswitchrepetir.isChecked()) {
                            System.out.println("Generando aleatorios sin rango y sin decimales repitiendo");
                            int numeroTotalAleatorios = Integer.valueOf(idedittextnumerostotales.getText().toString());
                            Random random = new Random();
                            for (int i = 0; i < numeroTotalAleatorios; i++) {
                                int numeroRandom = random.nextInt();
                                Aleatorios.add(numeroRandom);
                                idtextviewagregar.append((String.valueOf(numeroRandom)).concat(", "));
                            }
                        } else if (idchecksinrango.isChecked() && !idcheckdecimales.isChecked() && !idswitchrepetir.isChecked()) {
                            System.out.println("Generando aleatorios sin rango y sin decimales sin repetir");
                            int numeroTotalAleatorios = Integer.valueOf(idedittextnumerostotales.getText().toString());
                            Random random = new Random();
                            for (int i = 0; i < numeroTotalAleatorios; i++) {
                                int numeroRandom = random.nextInt();
                                if (!Aleatorios.contains(numeroRandom)) {
                                    Aleatorios.add(numeroRandom);
                                    idtextviewagregar.append((String.valueOf(numeroRandom)).concat(", "));
                                } else {
                                    i--;
                                }
                            }
                        } else if (idcheckconrango.isChecked() && idcheckdecimales.isChecked() && idswitchrepetir.isChecked()) {
                            System.out.println("Generando aleatorios con rango y con decimales repitiendo");
                            int minimoRango = Integer.valueOf(idedittextminimo.getText().toString());
                            int maximoRango = Integer.valueOf(idedittextmaximo.getText().toString());
                            int numeroDecimales = Integer.valueOf(idedittextdecimales.getText().toString());
                            int numeroTotalAleatorios = Integer.valueOf(idedittextnumerostotales.getText().toString());
                            for (int i = 0; i < numeroTotalAleatorios; i++) {
                                double randomDoble = new Random().nextDouble();
                                double numeroRandom = minimoRango + (randomDoble * (((maximoRango-minimoRango)) - 0.0));
                                numeroRandom = Double.parseDouble(String.format("%."+numeroDecimales+"f", numeroRandom));
                                AleatoriosDobles.add(numeroRandom);
                                idtextviewagregar.append((String.valueOf(numeroRandom)).concat(", "));
                            }
                        } else if (idcheckconrango.isChecked() && idcheckdecimales.isChecked() && !idswitchrepetir.isChecked()) {
                            System.out.println("Generando aleatorios con rango y con decimales sin repetir");
                            int minimoRango = Integer.valueOf(idedittextminimo.getText().toString());
                            int maximoRango = Integer.valueOf(idedittextmaximo.getText().toString());
                            int numeroDecimales = Integer.valueOf(idedittextdecimales.getText().toString());
                            int numeroTotalAleatorios = Integer.valueOf(idedittextnumerostotales.getText().toString());
                            for (int i = 0; i < numeroTotalAleatorios; i++) {
                                double randomDoble = new Random().nextDouble();
                                double numeroRandom = minimoRango + (randomDoble * (((maximoRango-minimoRango)) - 0.0));
                                numeroRandom = Double.parseDouble(String.format("%."+numeroDecimales+"f", numeroRandom));
                                AleatoriosDobles.add(numeroRandom);
                                idtextviewagregar.append((String.valueOf(numeroRandom)).concat(", "));
                                if (!AleatoriosDobles.contains(numeroRandom)) {
                                    AleatoriosDobles.add(numeroRandom);
                                    idtextviewagregar.append((String.valueOf(numeroRandom)).concat(", "));
                                } else {
                                    i--;
                                }
                            }
                        } else if (idcheckconrango.isChecked() && !idcheckdecimales.isChecked() && idswitchrepetir.isChecked()) {
                            System.out.println("Generando aleatorios con rango y sin decimales repitiendo");
                            int minimoRango = Integer.valueOf(idedittextminimo.getText().toString());
                            int maximoRango = Integer.valueOf(idedittextmaximo.getText().toString());
                            int numeroTotalAleatorios = Integer.valueOf(idedittextnumerostotales.getText().toString());
                            Random random = new Random();
                            for (int i = 0; i < numeroTotalAleatorios; i++) {
                                int numeroRandom = random.nextInt((maximoRango - minimoRango) + 1) + minimoRango;
                                Aleatorios.add(numeroRandom);
                                idtextviewagregar.append((String.valueOf(numeroRandom)).concat(", "));
                            }
                        } else if (idcheckconrango.isChecked() && !idcheckdecimales.isChecked() && !idswitchrepetir.isChecked()) {
                            System.out.println("Generando aleatorios con rango y sin decimales sin repetir");
                            int minimoRango = Integer.valueOf(idedittextminimo.getText().toString());
                            int maximoRango = Integer.valueOf(idedittextmaximo.getText().toString());
                            int numeroTotalAleatorios = Integer.valueOf(idedittextnumerostotales.getText().toString());
                            Random random = new Random();
                            for (int i = 0; i < numeroTotalAleatorios; i++) {
                                int numeroRandom = random.nextInt((maximoRango - minimoRango) + 1) + minimoRango;
                                if (!Aleatorios.contains(numeroRandom)) {
                                    Aleatorios.add(numeroRandom);
                                    idtextviewagregar.append((String.valueOf(numeroRandom)).concat(", "));
                                } else {
                                    i--;
                                }
                            }
                        }
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Debes introducir un número de decimales a generar", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.idcheckconrango:
                System.out.println("Filtando con rango");
                if(idedittextmaximo.isEnabled()){
                    idedittextmaximo.setEnabled(false);
                    idedittextminimo.setEnabled(false);
                }else if(!idedittextmaximo.isEnabled()){
                    idedittextminimo.setEnabled(true);
                    idedittextmaximo.setEnabled(true);
                }
                if(idchecksinrango.isChecked()){
                    idchecksinrango.setChecked(false);
                }
                break;
            case R.id.idchecksinrango:
                System.out.println("Filtrando sin rango");
                idedittextminimo.setEnabled(false);
                idedittextmaximo.setEnabled(false);
                if(idcheckconrango.isChecked()){
                    idcheckconrango.setChecked(false);
                }
                break;
            case R.id.idcheckdecimales:
                System.out.println("Filtrando con decimales");
                if(idcheckdecimales.isChecked()) {
                    idedittextdecimales.setEnabled(true);
                }else{
                    idedittextdecimales.setEnabled(false);
                }
                break;
        }
    }
}
