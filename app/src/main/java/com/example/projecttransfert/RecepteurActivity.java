package com.example.projecttransfert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RecepteurActivity extends AppCompatActivity {


    //====================DECLARATION DES VARIABLE=======================
    private Button btnSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recepteur);

        //===================  GESTION DES EVENEMENTS =========================
        btnSubmit=findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RecepteurActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });


    }
}