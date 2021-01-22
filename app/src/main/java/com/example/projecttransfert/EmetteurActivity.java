package com.example.projecttransfert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EmetteurActivity extends AppCompatActivity {

   //====================DECLARATION DES VARIABLE=======================
   private Button btnSuivant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emetteur);




//===================  GESTION DES EVENEMENTS =========================
        btnSuivant=findViewById(R.id.btnSuivant);
        btnSuivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(EmetteurActivity.this, RecepteurActivity.class);
                startActivity(intent);

            }
        });


    }
    }
