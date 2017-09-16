package com.example.jk.pruebamaps;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class WifiBluetooth extends AppCompatActivity {

    Switch wif;
    Switch blu;
    Button sig1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi_bluetooth);
        wif=(Switch)findViewById(R.id.wif);
        wif.setClickable(false);
        wif.setChecked(false);


        blu = (Switch) findViewById(R.id.blu);
        blu.setClickable(false);
        blu.setChecked(false);

        sig1=(Button)findViewById(R.id.sig1);
        sig1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){

                final Info formulario=(Info) getIntent().getSerializableExtra("formulario");
                formulario.setBluetooth(blu.isChecked());
                formulario.setWifi(wif.isChecked());

                Intent inte=new Intent(WifiBluetooth.this,Imagen.class);
                inte.putExtra("formulario",formulario);
                startActivity(inte);
            }
        });

        this.registerReceiver(this.WifiStateChangedReceiver, new IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION));
        this.registerReceiver(this.BluStateChangedReceiver, new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED));
        BluetoothAdapter ba=BluetoothAdapter.getDefaultAdapter();
        if(ba.getState()==BluetoothAdapter.STATE_ON){
            blu.setChecked(true);
        }

    }
    private BroadcastReceiver WifiStateChangedReceiver
            = new BroadcastReceiver(){

        @Override
        public void onReceive(Context context, Intent intent) {
            // TODO Auto-generated method stub

            int extraWifiState = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE ,
                    WifiManager.WIFI_STATE_UNKNOWN);

            switch(extraWifiState){
                case WifiManager.WIFI_STATE_DISABLED:
                    wif.setChecked(false);
                    break;
                case WifiManager.WIFI_STATE_DISABLING:
                    wif.setChecked(false);
                    break;
                case WifiManager.WIFI_STATE_ENABLED:
                    wif.setChecked(true);
                    break;
                case WifiManager.WIFI_STATE_ENABLING:
                    wif.setChecked(true);
                    break;
                case WifiManager.WIFI_STATE_UNKNOWN:
                    wif.setChecked(false);
                    break;
            }

        }};
    private BroadcastReceiver BluStateChangedReceiver
            = new BroadcastReceiver(){

        @Override
        public void onReceive(Context context, Intent intent) {
            // TODO Auto-generated method stub


            int extraBluState = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE ,
                    BluetoothAdapter.SCAN_MODE_NONE);

            switch(extraBluState){
                case BluetoothAdapter.STATE_OFF:
                    blu.setChecked(false);
                    break;
                case BluetoothAdapter.STATE_TURNING_OFF:
                    blu.setChecked(false);
                    break;
                case BluetoothAdapter.STATE_ON:
                    blu.setChecked(true);
                    break;
                case BluetoothAdapter.STATE_TURNING_ON:
                    blu.setChecked(true);
                    break;
                case BluetoothAdapter.SCAN_MODE_NONE:
                    blu.setChecked(false);
                    break;
            }

        }};
}
