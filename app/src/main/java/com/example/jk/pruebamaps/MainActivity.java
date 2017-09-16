package com.example.jk.pruebamaps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button dat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dat=(Button)findViewById(R.id.dat);



        dat.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                Intent inte=new Intent(MainActivity.this,DatosBasicos.class);
                startActivity(inte);
            }
        });
    }
}
