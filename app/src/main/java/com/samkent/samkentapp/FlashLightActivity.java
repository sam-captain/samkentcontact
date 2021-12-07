package com.samkent.samkentapp;


import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FlashLightActivity extends AppCompatActivity {
    private ImageButton toggleOn;
    boolean hasFlashOn = false;
    boolean hasCamera = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_light);

        toggleOn = findViewById(R.id.btn_toggle);
        hasCamera = getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
        toggleOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hasCamera){
                    if (hasFlashOn){
                        hasFlashOn = false;
                        toggleOn.setImageResource(R.drawable.turnoff);
                        try {
                            flashLightOff();
                        } catch (CameraAccessException e) {
                            e.printStackTrace();
                        }
                    }
                    else{
                        hasFlashOn = true;
                        toggleOn.setImageResource(R.drawable.turnon);
                        try {
                            flashLightOn();
                        } catch (CameraAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
                else{
                    Toast.makeText(FlashLightActivity.this, "no flashlight available on your device", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void flashLightOn() throws CameraAccessException {
        CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        String camera_id = cameraManager.getCameraIdList()[0];
        cameraManager.setTorchMode(camera_id,true);
        Toast.makeText(this, "flashlight on", Toast.LENGTH_SHORT).show();
    }
    private void flashLightOff() throws CameraAccessException {
        CameraManager cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        String camera_id = cameraManager.getCameraIdList()[0];
        cameraManager.setTorchMode(camera_id,false);
        Toast.makeText(this, "flashlight off", Toast.LENGTH_SHORT).show();
    }
}