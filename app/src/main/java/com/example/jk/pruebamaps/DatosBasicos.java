package com.example.jk.pruebamaps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DatosBasicos extends AppCompatActivity {

    Button sig;
    EditText nom;
    EditText ced;
    EditText dir;
    EditText ciu;
    EditText pai;
    EditText cel;
    TextView hel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_basicos);
        sig=(Button) findViewById(R.id.sig);
        nom=(EditText)findViewById(R.id.nom);
        ced=(EditText)findViewById(R.id.ced);
        dir=(EditText)findViewById(R.id.dir);
        ciu=(EditText)findViewById(R.id.ciu);
        pai=(EditText)findViewById(R.id.pai);
        cel=(EditText)findViewById(R.id.cel);
        hel=(TextView) findViewById(R.id.hel);

        sig.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){

                final Info formulario=new Info();
                formulario.setNombre(nom.getText().toString());
                formulario.setCedula(ced.getText().toString());
                formulario.setDireccion(dir.getText().toString());
                formulario.setCiudad(ciu.getText().toString());
                formulario.setPais(pai.getText().toString());
                formulario.setCelular(cel.getText().toString());

                Intent inte=new Intent(DatosBasicos.this,WifiBluetooth.class);
                inte.putExtra("formulario",formulario);
                startActivity(inte);
            }
        });




    }




}
