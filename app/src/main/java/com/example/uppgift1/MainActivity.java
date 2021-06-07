package com.example.uppgift1;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    Button btn;
    ImageView img;

    TextView X,Y,Z , A;
    Sensor mySensor;
    SensorManager SM;


    @Override
    public void onSensorChanged(SensorEvent event) {
        X.setText("X: " + event.values[0]);
        Y.setText("Y: " + event.values[1]);
        Z.setText("Z: " + event.values[2]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Används ej
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    //instance of our fragment
        BlankFragment fragment = new BlankFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.container,fragment).commit();


        //Skapa en SensorManager
        SM = (SensorManager)getSystemService(SENSOR_SERVICE);

        // Accelerator sensor
        mySensor = (SM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER));

        // SensorListener
        SM.registerListener(this, mySensor, SensorManager.SENSOR_DELAY_NORMAL);

            X = (TextView)findViewById(R.id.textView);
            Y = (TextView)findViewById(R.id.textView3);
            Z = (TextView)findViewById(R.id.textView2);
            A = (TextView)findViewById(R.id.textView4);

            A.setText("Accelerator");


        btn = (Button) findViewById(R.id.button4);
        img = (ImageView) findViewById(R.id.imageView4);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img.setImageResource(R.mipmap.android);
            }
        });





    }
}