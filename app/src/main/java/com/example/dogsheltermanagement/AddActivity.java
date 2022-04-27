package com.example.dogsheltermanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText nameInput, breedInput, ageInput;
    Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        nameInput = findViewById(R.id.name_input);
        breedInput = findViewById(R.id.breed_input);
        ageInput = findViewById(R.id.age_input);
        addButton = findViewById(R.id.add_button);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               MyDatabaseHelper db = new MyDatabaseHelper(AddActivity.this);
               db.addDog(nameInput.getText().toString().trim(), breedInput.getText().toString().trim(), Integer.parseInt(ageInput.getText().toString().trim()));

            }
        });
    }
}