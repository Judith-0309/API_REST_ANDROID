package com.example.projecttransfert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EnvoiActivity extends AppCompatActivity {
//===================  DECLARATION DES VARIABLE =========================
   private Button btnSuiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_envoi);

//===================  GESTION DES EVENEMENTS =========================
        btnSuiv=findViewById(R.id.btnSuiv);
        btnSuiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(EnvoiActivity.this,MainActivityS.class);
                startActivity(intent);

            }
        });


    }


}