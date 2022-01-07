package com.samkent.samkentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.samkent.samkentapp.Adapter.ContactAdapter;
import com.samkent.samkentapp.Model.Contact;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Contact App";
    RecyclerView selectContactRecyclerView;
    ContactAdapter contactAdapter;
    Button btnAdd;
    List<Contact> contactList = new ArrayList<Contact>();
    RecyclerView recyclerView;
    ContactAdapter rAdapter;
    RecyclerView.LayoutManager layoutManager;
    FloatingActionButton floatingBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        displayContact();
        Log.d(TAG, "onCreate: " +contactList.toString());
        Toast.makeText(this, "Contact count = " +contactList.size(), Toast.LENGTH_SHORT).show();
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.contactRecyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        rAdapter = new ContactAdapter(MainActivity.this, contactList);
        recyclerView.setAdapter(rAdapter);
        floatingBtn = findViewById(R.id.fab);



        floatingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ContactFormActivity.class);
                startActivity(intent);
            }
        });

    }

    private void displayContact() {
        Contact user1 = new Contact("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQR65yg_goFcAga2IIAnSkV2s5B6-OuBcY3Rw&usqp=CAU","samuel",1);
        Contact user2 = new Contact("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQR65yg_goFcAga2IIAnSkV2s5B6-OuBcY3Rw&usqp=CAU","Mary", 2);
        Contact user3 = new Contact("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQR65yg_goFcAga2IIAnSkV2s5B6-OuBcY3Rw&usqp=CAU","Peter", 3);
        Contact user4 = new Contact("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQR65yg_goFcAga2IIAnSkV2s5B6-OuBcY3Rw&usqp=CAU","Charles", 4);
        Contact user5 = new Contact("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQR65yg_goFcAga2IIAnSkV2s5B6-OuBcY3Rw&usqp=CAU","Yvonne", 5);

        contactList.addAll(Arrays.asList(new Contact[]{user1, user2, user3, user4, user5}));
    }


}