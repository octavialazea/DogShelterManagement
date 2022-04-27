package com.example.dogsheltermanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    FloatingActionButton addButton;

    MyDatabaseHelper database;
    ArrayList<String> dogName, dogBreed, dogAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recView);
        addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });

        database = new MyDatabaseHelper(MainActivity.this);
        dogName = new ArrayList<>();
        dogBreed = new ArrayList<>();
        dogAge = new ArrayList<>();

        storeData();
    }

    void storeData(){
        Cursor cursor = database.readAllData();
        if (cursor.getCount() == 0){
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext()){
                dogName.add(cursor.getString(0));
                dogBreed.add(cursor.getString(1));
                dogAge.add(cursor.getString(2));
            }
        }
    }


}