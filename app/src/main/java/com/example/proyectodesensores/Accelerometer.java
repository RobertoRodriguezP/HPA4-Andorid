package com.example.proyectodesensores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Accelerometer extends AppCompatActivity implements SensorEventListener {

    private Button button2;
    private TextView textView;
    private SensorManager sensorManager;
    private Sensor sensor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acelerometro);
        button2 = findViewById(R.id.button2);
        textView = findViewById(R.id.text_accelerometer);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(Accelerometer.this, sensor, sensorManager.SENSOR_DELAY_NORMAL);



        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Accelerometer.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void onSensorChanged(SensorEvent event) {
        // Original: public void onSensorChanged(SensorEvent sensorEvent) {
        // here the event.values will provide you with the data
        // index 0 for x axis, 1 for y axis and 2 for z axis


        textView.setText("X: "+event.values[0]+"\nY: "+event.values[1]+"\nZ: "+event.values[2]);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }



}
