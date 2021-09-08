package com.android.serialport;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.deemons.serialportlib.SerialPort;

public class MainActivity extends AppCompatActivity {
    private SerialPort mSerialPort;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}