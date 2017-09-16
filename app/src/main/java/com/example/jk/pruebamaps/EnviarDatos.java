package com.example.jk.pruebamaps;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class EnviarDatos extends AppCompatActivity {


    TextView hel;
    Button env;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enviar_datos);
        final Info formulario=(Info) getIntent().getSerializableExtra("formulario");
        hel=(TextView)findViewById(R.id.hel);
        env=(Button)findViewById(R.id.env);
        env.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){


                    try {
                        JSONObject toSend = new JSONObject();
                        toSend.put("nombre", formulario.getNombre());
                        toSend.put("cedula", formulario.getCedula());
                        toSend.put("direccion", formulario.getDireccion());
                        toSend.put("ciudad", formulario.getCiudad());
                        toSend.put("pais", formulario.getPais());
                        toSend.put("celular", formulario.getCelular());
                        toSend.put("wifi", formulario.getWifi());
                        toSend.put("bluetooth", formulario.getBluetooth());
                        toSend.put("longitud", 0);
                        toSend.put("latitud", 0);
                        toSend.put("foto", formulario.getFoto());
                        JSONTransmitter transmitter = new JSONTransmitter();
                        transmitter.execute(new JSONObject[] {toSend});
                        if(transmitter.get()){
                        Toast.makeText(getApplicationContext(),
                                "Envio exitoso", Toast.LENGTH_LONG).show();}
                        else{
                            Toast.makeText(getApplicationContext(),
                                    "Error en el envio", Toast.LENGTH_LONG).show();}
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }




            }
        });

        // check if you are connected or not
        if(isConnected()){
            hel.setBackgroundColor(0xFF00CC00);
            hel.setText("You are conncted");
        }
        else{
            hel.setText("You are NOT conncted");
        }
    }
    public boolean isConnected(){
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Activity.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected())
            return true;
        else
            return false;
    }
}
