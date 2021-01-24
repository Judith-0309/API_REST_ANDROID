package com.example.projecttransfert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

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
        private class HttpReqTask extends AsyncTask<Void, Void, Recepteur[]> {

            @Override
            protected Recepteur[] doInBackground(Void... params) {

                try {
                    String apiUrl = "http://localhost:8080/api/recepteurs/";
                    RestTemplate restTemplate = new RestTemplate();
                    restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                    Recepteur[ ] recepteurs = restTemplate.getForObject(apiUrl, Recepteur[].class);

                    return recepteurs;

                } catch (Exception ex){
                    Log.e("",ex.getMessage());

                }
                return null;
            }
            protected void  onPostExecute(Recepteur[] recepteurs){
                super.onPostExecute(recepteurs  );


                for(Recepteur recept: recepteurs){
                    Log.i("Recepteur: ", "Recepteur ajouté");
                    Log.i("recepteur_id: ", String.valueOf(recept.getIdR()));
                    Log.i("recepteur_nom: ",String.valueOf(recept.getNomR()));
                    Log.i("recepteur_prenom: ",String.valueOf(recept.getPrenomR()));
                    Log.i("recepteur_telephone: ",String.valueOf(recept.getTelR()));
                    Log.i("recepteur_cni: ",String.valueOf(recept.getCni()));



                }
            }


        }
    }