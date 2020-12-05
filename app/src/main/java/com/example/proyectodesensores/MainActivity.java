package com.example.proyectodesensores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        Button boton_acelerometro=(Button) findViewById(R.id.acelerometro);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Button Clicked");

                Intent actividadIntent = new Intent(getApplicationContext(), actividad.class);
                startActivity(actividadIntent);
            }
        });
        boton_acelerometro.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                System.out.println("Button Clicked");

                Intent acelerometroIntent = new Intent(getApplicationContext(), actividad.class);
                startActivity(acelerometroIntent);
            }
        }
        );
    }

    }
