package com.example.proyectodesensores;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import  android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class Termometer extends AppCompatActivity implements SensorEventListener{
    private TextView cosa;
    private Button button2;
    private SensorManager sensorManager;
    private Sensor tempSensor;
    private Boolean isTemperatureSensorAvalaible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.termometro);

        cosa = findViewById(R.id.Cosa);
        button2 = findViewById(R.id.button2);
        sensorManager=(SensorManager)getSystemService(Context.SENSOR_SERVICE);

        if(sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE)!=null){
            tempSensor=sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
            isTemperatureSensorAvalaible = true;

        }else{
            cosa.setText("Temperature Sensor not available");
            isTemperatureSensorAvalaible = false;

        }

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Termometer.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
    
    public void onSensorChanged(SensorEvent sensorEvent){
        cosa.setText(sensorEvent.values[0]+"°C");
    }
    
    public void onAccuracyChanged(Sensor sensor, int accuracy){
        
    }
    
    protected void onResume(){
        super.onResume();
        if(isTemperatureSensorAvalaible){
            sensorManager.registerListener(this,tempSensor,SensorManager.SENSOR_DELAY_NORMAL);

        }
    }

    protected void onPause(){
        super.onPause();
        if(isTemperatureSensorAvalaible){
            sensorManager.unregisterListener(this);
        }
    }
    
}
