package com.vit.gokul.newapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.tbruyelle.rxpermissions2.RxPermissions;

public class MainActivity extends AppCompatActivity {
    private Button mDriver;
    private Button mStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDriver=findViewById(R.id.homeDriver);
        mStudent=findViewById(R.id.homeStudent);
        RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions
                .request(android.Manifest.permission.ACCESS_FINE_LOCATION,
                        android.Manifest.permission.ACCESS_COARSE_LOCATION) // ask single or multiple permission once
                .subscribe(granted -> {
                    if (granted) {
                        Log.d("Cab","Location Granted");

                    } else {
                        Log.d("Cab","Location not granted");

                    }
                });

        mDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,driverLogin.class);
                startActivity(intent);
                finish();

            }
        });

        mStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,studentLogin.class);
                startActivity(intent);
                finish();

            }
        });
    }
}
