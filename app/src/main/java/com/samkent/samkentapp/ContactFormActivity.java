package com.samkent.samkentapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

public class ContactFormActivity extends AppCompatActivity {
    ImageView imageProfile;
    TextView txtName, txtPhone, txtEmail;
    Chip chipSaf,chipPhone,chipGmail, chipAirtel;
    Button btnAddContact, btnCancelContact;
    final int IMAGE_REQUEST_CODE = 065;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_form);

        imageProfile = findViewById(R.id.profileimage);
        txtName= findViewById(R.id.txt_name);
        txtEmail= findViewById(R.id.txt_email);
        txtPhone= findViewById(R.id.txt_number);
        chipSaf= findViewById(R.id.chipsaf);
        chipGmail= findViewById(R.id.chipgmail);
        chipPhone= findViewById(R.id.chipphone);
        chipAirtel= findViewById(R.id.chipairtel);
        btnAddContact = findViewById(R.id.btn_add_contact);
        btnCancelContact = findViewById(R.id.btn_cancel_contact);
        btnAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!txtName.getText().toString().isEmpty() &&!txtEmail.getText().toString().isEmpty() && txtEmail.getText().toString().isEmpty())

                {
                    Intent intent = new Intent(Intent.ACTION_INSERT);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(ContactFormActivity.this, "fill the field", Toast.LENGTH_SHORT).show();
                }
            }

        });
        btnCancelContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ContactFormActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        imageProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifyPermission();
            }
        });
    }

    public void validateInputs(){
        boolean response = false;

    }
    public void verifyPermission() {
        Log.d("TEST1:::", "verifyPermissions() called");
        String[] permissions = {
                Manifest.permission.READ_EXTERNAL_STORAGE
        };

        if (
                ContextCompat.checkSelfPermission(
                        this.getApplicationContext(), permissions[0])
                        == PackageManager.PERMISSION_GRANTED
        ) {
            pickImageFromGallery();
        }

        else{
            Log.d("TEST:::", "The if condition was not met");
            ActivityCompat.requestPermissions(
                    this, permissions, 122);
        }
    }

    private void pickImageFromGallery() {
        Log.d("TEST2:::", "pickImageFromGallery() called");
        Intent pickFromGallery = new Intent(Intent.ACTION_PICK);
        pickFromGallery.setType("image/*");
        String[] mimeTypes = {
                "image/jpeg",
                "image/png",
                "image/svg",
        };

        try {
            startActivityForResult(pickFromGallery,IMAGE_REQUEST_CODE);
        }

        catch (ActivityNotFoundException e){
            //Emptiness
        }

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == IMAGE_REQUEST_CODE && resultCode == RESULT_OK){
            Uri uri = data.getData();
            imageProfile.setImageURI(uri);
        }
    }

}