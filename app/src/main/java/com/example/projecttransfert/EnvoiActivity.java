package com.example.projecttransfert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.net.URL;


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

                Intent intent = new Intent(EnvoiActivity.this, EmetteurActivity.class);
                startActivity(intent);

            }
        });


    }

}