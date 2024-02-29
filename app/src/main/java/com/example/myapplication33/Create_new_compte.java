package com.example.myapplication33;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Create_new_compte extends AppCompatActivity {

    Button create;
    EditText email , password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_compte);

        create = findViewById(R.id.create);
        email = findViewById(R.id.createEmail);
        password = findViewById(R.id.createPassword);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Compte compte = new Compte();
                compte.createNewCompte(String.valueOf(email.getText()) , String.valueOf(password.getText()));
            }
        });
    }
}