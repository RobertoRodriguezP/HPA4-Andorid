package com.example.proyectodesensores;

import androidx.appcompat.app.AppCompatActivity;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.media.MediaPlayer;
import android.graphics.Color;
import android.os.Bundle;

public class Accelerometer extends AppCompatActivity {
    SensorManager sensorm;
    Sensor sensor;
    SensorEventListener sensorEvent;
    int whip=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acelerometro);
        sensorm=(SensorManager)getSystemService(SENSOR_SERVICE);
        sensor=sensorm.getDefaultSensor(sensor.TYPE_ACCELEROMETER);
        if (sensor==null) {
            finish();
        }
        sensorEvent=new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                float x=sensorEvent.values[0];
                System.out.println("valor giro " + x);
                if((x<-5) && (whip==0)) {
                    whip++;
                    getWindow().getDecorView().setBackgroundColor(Color.BLUE);
                }else if(x>5 && whip==1){

                    whip++;
                    getWindow().getDecorView().setBackgroundColor(Color.RED);
                }
                if(whip==2){
                    sonido();
                    whip=0;
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }

        };
        start();
    }
    private void sonido(){
        MediaPlayer mediaplayer = MediaPlayer.create(this,R.raw.latigo);
        mediaplayer.start();
    }
    private void start(){
        sensorm.registerListener(sensorEvent,sensor,SensorManager.SENSOR_DELAY_NORMAL);
    }
    private void stop(){
        sensorm.unregisterListener(sensorEvent);
    }

    @Override
    protected void onPause() {
        stop();
        super.onPause();
    }

    @Override
    protected void onResume() {
        start();
        super.onResume();
    }


}
