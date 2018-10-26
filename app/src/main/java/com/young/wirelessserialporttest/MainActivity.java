package com.young.wirelessserialporttest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.young.wirelessserialport.ComBean;
import com.young.wirelessserialport.WirelessSerialPort;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new WirelessSerialPort("/dev/ttyS3", "9600", new WirelessSerialPort.OnReceiveListener() {
            @Override
            public void onReceive(ComBean comBean) {
                Log.d(TAG, "onReceive: " + comBean.bRec.length);
            }
        }).openPort();
    }
}
