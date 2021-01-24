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
              new HttpReqTask().execute();
                Intent intent = new Intent(EmetteurActivity.this, RecepteurActivity.class);
                startActivity(intent);

            }
        });


    }
    private class HttpReqTask extends AsyncTask<Void, Void, Emetteur[]>{

        @Override
        protected Emetteur[] doInBackground(Void... params) {

            try {
                String apiUrl = "";
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                Emetteur[ ] emetteurs = restTemplate.getForObject(apiUrl, Emetteur[].class);

          return emetteurs;

            } catch (Exception ex){
               Log.e("",ex.getMessage());

        }
            return null;
    }
    protected void  onPostExecute(Emetteur[] emetteurs){
            super.onPostExecute(emetteurs  );


            for(Emetteur em: emetteurs){
                Log.i("Emetteur: ", "emetteur ajouté");
                Log.i("emetteur_id: ", String.valueOf(em.getIdE()));
                Log.i("emetteur_nom: ",String.valueOf(em.getNomE()));
                Log.i("emetteur_prenom: ",String.valueOf(em.getPrenomE()));
                Log.i("emetteur_telephone: ",String.valueOf(em.getTelephone()));
                Log.i("emetteur_cni: ",String.valueOf(em.getCni()));



            }
    }


    }
    }
