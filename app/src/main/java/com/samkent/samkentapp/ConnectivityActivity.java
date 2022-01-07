package com.samkent.samkentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import android.os.Bundle;

public class ConnectivityActivity extends AppCompatActivity {
    private ConnectivityManager mConnMgr;
    public NetworkRequest nReceive;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connectivity);


    }
}