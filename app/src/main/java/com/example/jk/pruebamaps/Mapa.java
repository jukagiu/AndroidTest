package com.example.jk.pruebamaps;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Looper;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Mapa extends AppCompatActivity {

    Button sig2;
    Button mp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);
        mp = (Button) findViewById(R.id.mp);

        mp.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){


                Intent inte=new Intent(Mapa.this,MapsActivity2.class);
                startActivity(inte);



            }
        });
        sig2 = (Button) findViewById(R.id.sig2);

        sig2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){


                final Info formulario=(Info) getIntent().getSerializableExtra("formulario");
                Intent inte=new Intent(Mapa.this,EnviarDatos.class);
                inte.putExtra("formulario",formulario);
                startActivity(inte);



            }
        });
    }

}
